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
package org.webreformatter.commons.templates;

import java.io.Writer;
import java.util.Map;
import java.util.Properties;

/**
 * Template processors are used to render the given key/value pairs using
 * underlying templates.
 * 
 * @author kotelnikov
 */
public interface ITemplateProcessor {

    /**
     * Closes this template processor
     */
    void close();

    /**
     * @return template processor properties
     */
    Properties getProperties();

    /**
     * @return a resource provider used as a source of templates
     */
    ITemplateProvider getResourceProvider();

    /**
     * Renders the template using the given context
     * 
     * @param templateName
     * @param params
     * @param writer
     * @throws TemplateException
     */
    void render(String templateName, Map<String, Object> params, Writer writer)
        throws TemplateException;
}
