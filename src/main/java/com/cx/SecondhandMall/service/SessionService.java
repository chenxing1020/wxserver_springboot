package com.cx.SecondhandMall.service;

import com.cx.SecondhandMall.model.SessionValue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SessionService {

    @GET("/sns/jscode2session")
    Call<SessionValue> getSessionValue(
            @Query("grant_type") String grantType,
            @Query("appid") String appId,
            @Query("secret") String secret,
            @Query("js_code") String code
    );
}