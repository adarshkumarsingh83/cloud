package com.epsark.adarsh.web;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class ApplicationController {

    private Feature labelDetection = null;
    private Feature textDetection = null;


    @Autowired
    private ImageAnnotatorClient client;

    @PostConstruct
    public void init() {
        labelDetection = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
        textDetection = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();
    }


    @PostMapping("/analyze")
    String analyze(@RequestParam MultipartFile image) throws IOException {

        byte[] data = image.getBytes();
        ByteString imgBytes = ByteString.copyFrom(data);
        Image img = Image.newBuilder().setContent(imgBytes).build();

        AnnotateImageRequest request = AnnotateImageRequest
                .newBuilder()
                .addFeatures(this.labelDetection)
                .addFeatures(this.textDetection)
                .setImage(img)
                .build();
        BatchAnnotateImagesResponse responses = this.client
                .batchAnnotateImages(Collections.singletonList(request));
        AnnotateImageResponse reply = responses.getResponses(0);
        return reply.toString();
    }

}
