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
package io.github.hasithaa.java4bpel;

import org.apache.ode.bpel.common.FaultException;
import org.apache.ode.bpel.evar.ExternalVariableModuleException;
import org.apache.ode.bpel.o.OProcess;
import org.apache.ode.bpel.o.OScope;
import org.apache.ode.bpel.runtime.extension.ExtensionContext;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import java.net.URI;

public class ProcessData {

    private ExtensionContext extensionContext;

    public ProcessData(ExtensionContext extensionContext) {
        this.extensionContext = extensionContext;
    }

    public boolean isVariableVisible(String s) {
        return this.extensionContext.isVariableVisible(s);
    }

    public Node readVariable(OScope.Variable variable) throws FaultException {
        return extensionContext.readVariable(variable);
    }

    public Node readVariable(String variable) throws FaultException {
        return extensionContext.readVariable(variable);
    }

    public void writeVariable(OScope.Variable variable, Node node) throws FaultException, ExternalVariableModuleException {
        extensionContext.writeVariable(variable, node);
    }

    public void writeVariable(String variable, Node node) throws FaultException, ExternalVariableModuleException {
        extensionContext.writeVariable(variable, node);
    }

    public long getProcessId() {
        return extensionContext.getProcessId();
    }

    public QName getProcessQName() {
        return extensionContext.getProcessModel().getQName();
    }

    public String getProcessName() {
        return extensionContext.getProcessModel().getName();
    }

    public String getActivityName() {
        return extensionContext.getActivityName();
    }

    public void printToConsole(String s) {
        extensionContext.printToConsole(s);
    }

    public boolean isPartnerLinkVisible(String s) {
        return extensionContext.isPartnerLinkVisible(s);
    }

    public OProcess getProcessModel() {
        return extensionContext.getProcessModel();
    }

    public URI getDUDir() {
        return extensionContext.getDUDir();
    }
}
