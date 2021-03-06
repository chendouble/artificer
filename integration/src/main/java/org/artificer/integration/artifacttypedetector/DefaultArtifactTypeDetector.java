/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.artificer.integration.artifacttypedetector;

import org.artificer.common.ArtifactContent;
import org.artificer.common.ArtifactType;
import org.artificer.integration.ArchiveContext;

/**
 * @author Brett Meyer.
 */
public class DefaultArtifactTypeDetector extends AbstractArtifactTypeDetector {

    @Override
    public ArtifactType detect(ArtifactContent content) {
        String filename = content.getFilename().toLowerCase();
        if (filename.endsWith(".xml")) {
            return ArtifactType.XmlDocument();
        } else if (filename.endsWith(".wsdl")) {
            return ArtifactType.WsdlDocument();
        } else if (filename.endsWith(".xsd")) {
            return ArtifactType.XsdDocument();
        } else if (filename.endsWith(".wspolicy")) {
            return ArtifactType.PolicyDocument();
        } else if (!isArchive(content)) {
			// Don't allow archives within archives to become documents!  Only process if explicitly OK'd by another
			// detector (JavaArtifactTypeDetector, etc.).
            return ArtifactType.Document();
        } else {
			return null;
		}
    }

    @Override
    public ArtifactType detect(ArtifactContent content, ArchiveContext archiveContext) {
        if (archiveContext.isExpandedFromArchive()) {
            return detect(content);
        }
        if (content.getFilename().endsWith(".zip")) {
            return ArtifactType.valueOf("ZipArchive", true);
        }
        return null;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
