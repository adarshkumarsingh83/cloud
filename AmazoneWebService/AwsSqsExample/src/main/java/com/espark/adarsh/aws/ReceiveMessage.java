package com.espark.adarsh.aws;

import java.util.List;
import java.util.Map.Entry;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.espark.adarsh.aws.util.AwsClientUtil;

public class ReceiveMessage {
    static AmazonSQSClient client;

    public static void main(String[] args) throws Exception {
        try {
            client = AwsClientUtil.getClient();
            String myQueueUrl = client.getQueueUrl("espark").getQueueUrl();
            System.out.println("Receiving messages from MyQueue.");
            ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl);
            receiveMessageRequest.setMaxNumberOfMessages(10);
            List<Message> messages = client.receiveMessage(receiveMessageRequest).getMessages();
            for (Message message : messages) {
                System.out.println("  Message");
                System.out.println("    MessageId:     " + message.getMessageId());
                System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
                System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
                System.out.println("    Body:          " + message.getBody());
                for (Entry<String, String> entry : message.getAttributes().entrySet()) {
                    System.out.println("  Attribute");
                    System.out.println("    Name:  " + entry.getKey());
                    System.out.println("    Value: " + entry.getValue());
                }
                System.out.println("Deleting a message.");
                String messageRecieptHandle = message.getReceiptHandle();
                client.deleteMessage(new DeleteMessageRequest(myQueueUrl, messageRecieptHandle));
            }
            System.out.println();
        } catch (AmazonServiceException ase) {
            System.err.println(ase.getMessage());
        }
    }
}
