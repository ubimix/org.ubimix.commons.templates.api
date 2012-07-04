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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.webreformatter.commons.templates.ITemplateProvider;


/**
 * @author kotelnikov
 */
public class StringBasedResourceProvider implements ITemplateProvider {

    /**
     * This class is used as a container for resource information.
     */
    protected class ResourceInfo {
        /**
         * The "modification date" of this resource.
         */
        public long fLastModified;

        /**
         * The resource content
         */
        public String fStr;

        /**
         * @param str
         */
        public ResourceInfo(String str) {
            fStr = str;
            fLastModified = System.currentTimeMillis();
        }

        /**
         * @return the input stream with the content
         */
        public InputStream getStream() {
            byte[] array = {};
            try {
                array = fStr.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                // ;
            }
            return new ByteArrayInputStream(array);
        }
    }

    private Map<String, ResourceInfo> fMap = new HashMap<String, ResourceInfo>();

    /**
     * 
     */
    public StringBasedResourceProvider() {
        super();
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getLastModified(java.lang.String)
     */
    public long getLastModified(String key) throws IOException {
        key = normalizeKey(key);
        ResourceInfo resourceInfo = fMap.get(key);
        return resourceInfo != null ? resourceInfo.fLastModified : -1;
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getTemplate(java.lang.String)
     */
    public InputStream getTemplate(String key) throws IOException {
        key = normalizeKey(key);
        ResourceInfo info = fMap.get(key);
        if (info == null)
            return null;
        return info.getStream();
    }

    /**
     * @param key the key to normalize
     * @return a normalized form of the key
     */
    private String normalizeKey(String key) {
        if (key == null)
            key = "";
        key = key.replace('\\', '/');
        if (key.startsWith("/")) {
            if (key.length() > 0)
                key = key.substring(1);
            else
                key = "";
        }
        if (key.endsWith("/")) {
            key = key.substring(0, key.length() - 1);
        }
        return key;
    }

    /**
     * Registers a new resource
     * 
     * @param key the key of the resource
     * @param resource the resource content
     */
    public void register(String key, String resource) {
        key = normalizeKey(key);
        fMap.put(key, new ResourceInfo(resource));
    }

    /**
     * @see org.webreformatter.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#templateExists(java.lang.String)
     */
    public boolean templateExists(String key) throws IOException {
        key = normalizeKey(key);
        return fMap.containsKey(key);
    }

    /**
     * Removes a resource with the given name
     * 
     * @param key the key of the resource to remove
     */
    public void unregister(String key) {
        key = normalizeKey(key);
        fMap.remove(key);
    }

}
