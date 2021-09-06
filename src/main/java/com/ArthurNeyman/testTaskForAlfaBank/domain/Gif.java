package com.ArthurNeyman.testTaskForAlfaBank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gif {

    @JsonProperty("data")
    private Url url;

    public String getGifUrl() {
        return url.getGifUrl();
    }

    static class Url {

        @JsonProperty("image_original_url")
        private String gifUrl;

        public String getGifUrl() {
            return gifUrl;
        }
    }
}

