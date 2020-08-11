package com.espark.adarsh.aws;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.espark.adarsh.aws.util.AwsClientUtil;

public class SendMessage {
    static AmazonSQSClient client;

    public static void main(String[] args) throws Exception {
        try {
            client = AwsClientUtil.getClient();
            String myQueueUrl = client.getQueueUrl("espark").getQueueUrl();
            System.out.println("Sending a message to MyQueue.");
            String msg = "This is my from "+System.getProperty("user.name");
            SendMessageResult result = client.sendMessage(new SendMessageRequest(myQueueUrl, msg));
            System.out.println(result);
        } catch (AmazonServiceException ase) {
            System.err.println(ase.getMessage());
        }
    }
}
