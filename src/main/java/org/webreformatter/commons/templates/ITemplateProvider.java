/**
 * 
 */
package org.webreformatter.commons.templates;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kotelnikov
 */
public interface ITemplateProvider {

    long getLastModified(String name) throws IOException;

    InputStream getTemplate(String name) throws IOException;

    boolean templateExists(String name) throws IOException;

}
