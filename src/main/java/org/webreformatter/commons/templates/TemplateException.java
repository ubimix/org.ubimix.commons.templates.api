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

/**
 * @author kotelnikov
 */
public class TemplateException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 4380675365152765705L;

    /**
     * 
     */
    public TemplateException() {
        super();
    }

    /**
     * @param message
     */
    public TemplateException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public TemplateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public TemplateException(Throwable cause) {
        super(cause);
    }

}
