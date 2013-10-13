package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.*;

import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/11/13
 * Time: 6:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class MongoSpakFM {
    public static void main(String[] args) throws IOException, TemplateException {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        final DB databse = client.getDB("test");
        DBCollection things = databse.getCollection("col2");
        final DBObject dbObject = things.findOne();

        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");


        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                Template helloTemplate = null;
                try {
                    helloTemplate = config.getTemplate("hello.ftl");

                    StringWriter writer = new StringWriter();
                    if (helloTemplate != null) {
                        helloTemplate.process(dbObject, writer);
                    }
                    return writer;
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return null;
            }
        });

    }
}
