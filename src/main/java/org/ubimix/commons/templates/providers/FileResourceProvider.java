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
package org.ubimix.commons.templates.providers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.ubimix.commons.templates.ITemplateProvider;


/**
 * @author kotelnikov
 */
public class FileResourceProvider implements ITemplateProvider {

    protected File fRootDir;

    /**
     * @param rootDir
     */
    public FileResourceProvider(File rootDir) {
        super();
        fRootDir = rootDir;
    }

    /**
     * @see org.ubimix.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getLastModified(java.lang.String)
     */
    public long getLastModified(String key) throws IOException {
        File file = newFile(key);
        return file.exists() ? file.lastModified() : -1;
    }

    /**
     * @see org.ubimix.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#getTemplate(java.lang.String)
     */
    public InputStream getTemplate(String key) throws IOException {
        File file = newFile(key);
        if (!file.exists())
            throw new IOException("The resource '" + key + "' does not exist");
        return new BufferedInputStream(new FileInputStream(file));
    }

    /**
     * @param key the key of the resource
     * @return the file corresponding to the given resource identifier
     */
    protected File newFile(String key) {
        return new File(fRootDir, key);
    }

    /**
     * @see org.ubimix.commons.templates.semanticdesktop.common.ITemplateProvider.IResourceProvider#templateExists(java.lang.String)
     */
    public boolean templateExists(String key) throws IOException {
        File file = newFile(key);
        return file.exists();
    }

}
