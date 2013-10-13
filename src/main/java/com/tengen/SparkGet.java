package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/12/13
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SparkGet {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World\n";
            }
        });

        Spark.get(new Route("test") {
            @Override
            public Object handle(Request request, Response response) {
                return "This is a test page\n";
            }
        });

        Spark.get(new Route("/echo/:thing") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":thing");
            }
        });
    }
}
