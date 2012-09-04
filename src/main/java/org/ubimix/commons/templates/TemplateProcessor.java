/*******************************************************************************
 * Copyright (c) 2005,2006 Cognium Systems SA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cognium Systems SA - initial API and implementation
 *******************************************************************************/
package org.ubimix.commons.templates;

import java.util.Properties;

/**
 * The default superclass for all template processors.
 * 
 * @author kotelnikov
 */
public abstract class TemplateProcessor implements ITemplateProcessor {

    protected Properties fProperties;

    protected ITemplateProvider fTemplateProvider;

    /**
     * @param templateProvider
     * @param properties
     */
    public TemplateProcessor(
        ITemplateProvider templateProvider,
        Properties properties) {
        fTemplateProvider = templateProvider;
        fProperties = properties;
    }

    /**
     * @see org.ubimix.commons.templates.ITemplateProcessor#getProperties()
     */
    public Properties getProperties() {
        return fProperties;
    }

    /**
     * @see org.ubimix.commons.templates.ITemplateProcessor#getResourceProvider()
     */
    public ITemplateProvider getResourceProvider() {
        return fTemplateProvider;
    }

}