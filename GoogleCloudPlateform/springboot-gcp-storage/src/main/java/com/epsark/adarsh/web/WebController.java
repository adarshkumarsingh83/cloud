package com.epsark.adarsh.web;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST Controller that exposes read and write operations on a Google Cloud Storage file accessed using the Spring
 * Resource Abstraction.
 */
@RestController
public class WebController {

    @Value("gs://${gcs-resource-test-bucket}/my-file.txt")
    private Resource gcsFile;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String readGcsFile() throws IOException {
        return StreamUtils.copyToString(
                this.gcsFile.getInputStream(),
                Charset.defaultCharset()) + "\n";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String writeGcs(@RequestBody String data) throws IOException {
        try (OutputStream os = ((WritableResource) this.gcsFile).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "file was updated\n";
    }
}
