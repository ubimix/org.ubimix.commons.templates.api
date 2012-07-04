/*******************************************************************************
 * Copyright (c) 2005-2009 Cognium Systems SA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, Version 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Cognium Systems SA - initial API and implementation
 *******************************************************************************/
package org.webreformatter.commons.templates.providers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.webreformatter.commons.templates.ITemplateProvider;


/**
 * @author kotelnikov
 */
public class ClasspathResourceProvider implements ITemplateProvider {

    /**
     *
     */
    public ClasspathResourceProvider() {
        super();
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getLastModified(java.lang.String)
     */
    public long getLastModified(String key) throws IOException {
        String resourceName = getResourceName(key);
        URL resource = getClass().getResource(resourceName);
        return resource != null
            ? resource.openConnection().getLastModified()
            : -1;
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getTemplate(java.lang.String)
     */
    public InputStream getTemplate(String key) throws IOException {
        String resourceName = getResourceName(key);
        return getClass().getResourceAsStream(resourceName);
    }

    /**
     * @param key the key of the resource to transform to the resource name
     * @return the name of the resource corresponding to the given id.
     */
    protected String getResourceName(String key) {
        if (!key.startsWith("/"))
            key = "/" + key;
        return key;
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#templateExists(java.lang.String)
     */
    public boolean templateExists(String key) throws IOException {
        String resourceName = getResourceName(key);
        return getClass().getResource(resourceName) != null;
    }

}
