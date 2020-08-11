package com.espark.adarsh.aws;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.espark.adarsh.aws.util.AwsClientUtil;

public class CreateQueue {
    static AmazonSQSClient client;

    public static void main(String[] args) throws Exception {
        try {
            client = AwsClientUtil.getClient();
            CreateQueueRequest createQueueRequest = new CreateQueueRequest("espark");
            String myQueueUrl = client.createQueue(createQueueRequest).getQueueUrl();
            System.out.println("Created: " + myQueueUrl);
            System.out.println("Listing all queues in your account.");
            for (String queueUrl : client.listQueues().getQueueUrls()) {
                System.out.println("  QueueUrl: " + queueUrl);
            }
            System.out.println();
        } catch (AmazonServiceException ase) {
            System.err.println(ase.getMessage());
        }
    }
}
