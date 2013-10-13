package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/12/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class SparkPost {

    public static void main(String[] args) throws IOException {

        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(SparkPost.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                HashMap<String,Object> fruitMap = new HashMap<String, Object>();
                fruitMap.put("fruits", Arrays.asList("Apple","Orange","Banana", "Peach"));
                try {
                    Template helloTemplate = config.getTemplate("fruitPicker.ftl");
                    StringWriter writer = new StringWriter();
                    helloTemplate.process(fruitMap,writer);
                    return writer;

                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return null;
            }
        });

        Spark.get(new Route("/pickfruit") {
            @Override
            public Object handle(Request request, Response response) {
                String fruit = request.queryParams("fruit");
                if(fruit == null){
                    return "Please pick your most favourite fruit...";
                }
                else{
                    return  "Your favorite fruit is " + fruit;
                }
            }
        });
    }


}
