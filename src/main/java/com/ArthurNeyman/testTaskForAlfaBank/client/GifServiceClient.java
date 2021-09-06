package com.ArthurNeyman.testTaskForAlfaBank.client;

import com.ArthurNeyman.testTaskForAlfaBank.domain.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gif-api-client", url = "${gif-api-client.url}")
public interface GifServiceClient {

    @GetMapping(value = "${gif-api-client.brokeParam}")
    Gif getBrokeGif();

    @GetMapping(value = "${gif-api-client.richParam}")
    Gif getRichGif();
}
