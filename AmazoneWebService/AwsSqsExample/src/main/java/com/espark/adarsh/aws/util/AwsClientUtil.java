package com.espark.adarsh.aws.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by adarsh_k on 2/22/2017.
 */
public class AwsClientUtil {

   private static AmazonSQSClient client;

    static {
        try{
            createClient();
        }catch (Exception e){

        }
    }

    private static void createClient() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("src\\main\\resources\\AwsCredentials.properties");
        AWSCredentials credentials = new PropertiesCredentials(fileInputStream);
        client = new AmazonSQSClient(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        client.setRegion(usWest2);
    }

    public static AmazonSQSClient getClient(){
        return client;
    }
}
