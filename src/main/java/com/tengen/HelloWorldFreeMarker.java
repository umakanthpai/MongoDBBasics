package com.tengen;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/11/13
 * Time: 5:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreeMarker {
    private static Configuration createDefaultConfiguration() {
        Configuration configuration = new Configuration();
        //configuration.setClassForTemplateLoading(FreeMarkerRoute.class, "");
        File f = new File("");
        String template_dir = f.getAbsolutePath();

        try {
            File fd = new File(template_dir + "/resources/");
            configuration.setDirectoryForTemplateLoading(fd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configuration;
    }
    public static void main(String[] args) throws IOException {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
//        Configuration config = createDefaultConfiguration();
        Template helloTemplate = config.getTemplate("hello.ftl");
        StringWriter writer = new StringWriter();
        Map<String,Object> helloMap = new HashMap<String,Object>();
        helloMap.put("name", "Umakanth Pai");
        try {
            helloTemplate.process(helloMap,writer);
            System.out.println(writer);
        } catch (TemplateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
