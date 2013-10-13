package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/11/13
 * Time: 6:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SparkFreeMarker {
    public static void main(String[] args) {
        final Configuration c = new Configuration();
        c.setClassForTemplateLoading(SparkFreeMarker.class,"/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Template template = c.getTemplate("hello.ftl");
                    HashMap<String, Object> aMap = new HashMap<String, Object>();
                    aMap.put("name","Spark-FreeMarker");
                    StringWriter writer = new StringWriter();
                    template.process(aMap,writer);
                    return writer;
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (TemplateException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
