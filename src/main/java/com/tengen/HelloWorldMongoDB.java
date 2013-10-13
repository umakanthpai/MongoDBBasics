package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Umakanth
 * Date: 10/9/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDB {

    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("localhost",27017));
        DB databse = client.getDB("test");
        DBCollection things = databse.getCollection("things");
        DBObject dbObject = things.findOne();
        dbObject.toString();
        System.out.println(dbObject);


    }
}
