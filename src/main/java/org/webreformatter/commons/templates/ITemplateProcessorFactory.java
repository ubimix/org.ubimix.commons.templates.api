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

import java.util.Properties;

/**
 * Template factories are used to create template processors. All templates
 * (their content) are loaded by this factory using the specified resource
 * providers.
 * 
 * @author kotelnikov
 */
public interface ITemplateProcessorFactory {

    /**
     * @param templateProvider
     * @param properties
     * @return a new template processor
     * @throws TemplateException
     */
    ITemplateProcessor newTemplateProcessor(
        ITemplateProvider templateProvider,
        Properties properties) throws TemplateException;

}
