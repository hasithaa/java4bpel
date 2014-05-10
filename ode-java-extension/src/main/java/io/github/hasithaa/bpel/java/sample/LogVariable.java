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
package io.github.hasithaa.bpel.java.sample;

import io.github.hasithaa.bpel.java.InvokeClassActivity;
import io.github.hasithaa.bpel.java.ProcessData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ode.utils.DOMUtils;
import org.w3c.dom.Node;

public class LogVariable implements InvokeClassActivity {

    private static Log log = LogFactory.getLog(LogVariable.class);

    @Override
    public void invokeClass(ProcessData data, String[] params) {
        if (params != null && params.length > 0) {
            for (String variable : params) {
                try {
                    if (data.isVariableVisible(variable)) {
                        Node node = data.readVariable(variable);
                        if (node == null) {
                            log.info("Logging Variable " + variable + " =" + null);
                            continue;
                        }
                        String s = DOMUtils.domToString(node);
                        log.info("Logging Variable " + variable + " =" + s);
                    }
                } catch (Exception e) {
                    log.error("Error occurred while reading variable " + variable, e);
                }
            }
        }
    }
}
