package com.cx.SecondhandMall.configuration;


import com.cx.SecondhandMall.interceptor.LoggingInterceptor;
import com.cx.SecondhandMall.service.SessionService;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@Configuration
public class RetrofitConfig {

    @Value("${retrofit.url}")
    private String baseUrl;

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
                .addInterceptor(new LoggingInterceptor())
                .build();

        return client;
    }

    @Bean
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Bean
    public SessionService sessionService(Retrofit retrofit) {
        return retrofit.create(SessionService.class);
    }
}
