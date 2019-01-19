package com.example.hong4poker.network;

import com.example.hong4poker.network.POJO.Configs;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface ApiFileConfiguration {
    @Streaming
    @GET("testAccountDigitalChoo/configFile/master/README.md")
    Single<Configs> downloadConfigFile();
}
