/*
*Copyright (c) 2014 Hasitha Aravinda
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/
package io.github.hasithaa.bpel.java;


import org.apache.ode.bpel.common.FaultException;
import org.apache.ode.bpel.runtime.extension.AbstractSyncExtensionOperation;
import org.apache.ode.bpel.runtime.extension.ExtensionContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class SyncClassActivity extends AbstractSyncExtensionOperation {


    private String name;
    private String className;
    private String[] params;

    @Override
    protected void runSync(ExtensionContext extensionContext, Element element) throws FaultException {
        parseElement(element);
        invokeClass(new ProcessData(extensionContext));
    }

    private void invokeClass(ProcessData processData) throws FaultException {
        InvokeClassActivity invokeClassActivity;
        try {
            Object c = Class.forName(className).newInstance();
            if (c instanceof InvokeClassActivity) {
                invokeClassActivity = (InvokeClassActivity) c;
                invokeClassActivity.invokeClass(processData, params);
            }
        } catch (Exception e) {
            throw new FaultException(ExtensionConstants.QNAME_FAULT_RUNTIME_ERROR,
                    e.getMessage(), e.getCause());
        }
    }

    private void parseElement(Element element) throws FaultException {

        //Validating element
        if (!element.getLocalName().equals(ExtensionConstants.INVOKE_CLASS) ||
                !element.getNamespaceURI().equals(ExtensionConstants.NAMESPACE)) {
            throw new FaultException(ExtensionConstants.QNAME_FAULT_MALFORMED_ACTIVITY,
                    "No " + ExtensionConstants.INVOKE_CLASS + " activity found");
        }

        name = element.getAttribute(ExtensionConstants.ACTIVITY_NAME);
        className = element.getAttribute(ExtensionConstants.ACTIVITY_CLASS_NAME);
        if (className == null || className.equals("")) {
            throw new FaultException(ExtensionConstants.QNAME_FAULT_MALFORMED_ACTIVITY,
                    "Invalid class name found.");
        }

        NodeList paramList = element.getChildNodes();
        Node param = null;
        ArrayList<String> paramsList = new ArrayList<String>();
        for (int i = 0; i < paramList.getLength(); i++) {
            param = paramList.item(i);
            if (ExtensionConstants.ACTIVITY_PARAM.equals(param.getLocalName()) &&
                    ExtensionConstants.NAMESPACE.equals(param.getNamespaceURI())) {
                try {
                    String textContent = param.getTextContent();
                    paramsList.add(textContent);
                } catch (Exception e) {
                    throw new FaultException(ExtensionConstants.QNAME_FAULT_MALFORMED_ACTIVITY,
                            "Found malformed param element");
                }
            } else {
                throw new FaultException(ExtensionConstants.QNAME_FAULT_MALFORMED_ACTIVITY,
                        "Found unsupported element :" + param.getLocalName());
            }
        }
        params = (String[]) paramsList.toArray();
    }

}
