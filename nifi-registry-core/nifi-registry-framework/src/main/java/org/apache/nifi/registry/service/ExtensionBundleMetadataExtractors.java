/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.registry.service;

import org.apache.nifi.registry.extension.BundleExtractor;
import org.apache.nifi.registry.extension.ExtensionBundleType;
import org.apache.nifi.registry.extension.minificpp.MiNiFiCppBundleExtractor;
import org.apache.nifi.registry.extension.nar.NarBundleExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExtensionBundleMetadataExtractors {

    private Map<ExtensionBundleType, BundleExtractor> extractors;

    @Bean
    public synchronized Map<ExtensionBundleType, BundleExtractor> getExtractors() {
        if (extractors == null) {
            extractors = new HashMap<>();
            extractors.put(ExtensionBundleType.NIFI_NAR, new NarBundleExtractor());
            extractors.put(ExtensionBundleType.MINIFI_CPP, new MiNiFiCppBundleExtractor());
        }

        return extractors;
    }

}
