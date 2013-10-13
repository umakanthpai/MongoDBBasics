package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/11/13
 * Time: 5:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloSpark {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello From Spark Neel";
            }
        });
    }
}
