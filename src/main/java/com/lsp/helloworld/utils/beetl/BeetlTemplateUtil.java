package com.lsp.helloworld.utils.beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;

/**
 * @author lishuaipeng
 * @date 2020/11/2 4:30 下午
 */
public class BeetlTemplateUtil {

    /**
     *
     * @param templateName templates下面的模板
     * @return
     */
    public static Template getByName(String templateName) {
        try {
            ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/templates/");
            Configuration cfg = Configuration.defaultConfiguration();
            cfg.add("/zdoc-beetl.properties");
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            return gt.getTemplate(templateName);
        } catch (IOException e) {
            throw new RuntimeException("Can't get Beetl template.");
        }
    }
}
