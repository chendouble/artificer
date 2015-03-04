/*
 * Copyright 2013 JBoss Inc
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
package org.artificer.ui.client.shared.beans;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brett Meyer
 */
@Portable
public class ArtifactRelationshipsBean implements Serializable {

    private static final long serialVersionUID = ArtifactRelationshipsBean.class.hashCode();

    private List<ArtifactRelationshipBean> relationships = new ArrayList<ArtifactRelationshipBean>();

    /**
     * Constructor.
     */
    public ArtifactRelationshipsBean() {
    }

    /**
     * @return the relationships
     */
    public List<ArtifactRelationshipBean> getRelationships() {
        return relationships;
    }
}