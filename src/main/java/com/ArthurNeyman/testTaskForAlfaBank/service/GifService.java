package com.ArthurNeyman.testTaskForAlfaBank.service;

import com.ArthurNeyman.testTaskForAlfaBank.client.GifServiceClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

@Service
public class GifService {

    @Autowired
    GifServiceClient gifServiceClient;

    public byte[] getGif(boolean isIncrease) throws IOException, FeignException {

        String url = isIncrease ? gifServiceClient.getRichGif().getGifUrl() : gifServiceClient.getBrokeGif().getGifUrl();
        url = url.replaceAll("\\/\\/media[0-9]+.", "//i.");

        return  getByteArrayFromInputStream(new URL(url).openStream());

    }

    private byte[] getByteArrayFromInputStream(InputStream stream) throws IOException {

        ByteArrayOutputStream bufferedImage = new ByteArrayOutputStream();

        byte[] byteChunk = new byte[4096];
        int n;
        while ((n = stream.read(byteChunk)) > 0) {
            bufferedImage.write(byteChunk, 0, n);
        }
        return bufferedImage.toByteArray();
    }

}
