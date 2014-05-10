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

import javax.xml.namespace.QName;

public class ExtensionConstants {

    public static final String NAMESPACE = "http://hasithaa.github.io/BPEL-ClassActivity/";

    public static final String INVOKE_CLASS = "invokeClass";

    //Faults related constants
    public static final String FAULT_MALFORMED = "malformedActivityError";
    public static final String FAULT_RUNTIME_ERROR = "runtimeError";

    public static final QName QNAME_FAULT_MALFORMED_ACTIVITY = new QName(NAMESPACE, FAULT_MALFORMED);
    public static final QName QNAME_FAULT_RUNTIME_ERROR = new QName(NAMESPACE, FAULT_RUNTIME_ERROR);

    //Element and attributes related constants
    public static final String ACTIVITY_NAME = "name";
    public static final String ACTIVITY_PARAM = "param";
    public static final String ACTIVITY_CLASS_NAME = "class";
}
