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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ode.bpel.runtime.extension.AbstractExtensionBundle;

public class ExtensionBundle extends AbstractExtensionBundle {

    private static Log log = LogFactory.getLog(ExtensionBundle.class);

    @Override
    public String getNamespaceURI() {
        return ExtensionConstants.NAMESPACE;
    }

    @Override
    public void registerExtensionActivities() {
        log.info("Registering ODE Java extension operation: " + ExtensionConstants.INVOKE_CLASS);
        this.registerExtensionOperation(ExtensionConstants.INVOKE_CLASS, SyncClassActivity.class);
    }
}
