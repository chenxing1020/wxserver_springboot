package com.cx.SecondhandMall.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Logger logger = LoggerFactory.getLogger("LoggingInterceptor");
        Request request = chain.request();

        long t1 = System.nanoTime();
        logger.info(String.format("Sending request {} on {}{}",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        logger.info(String.format("Received response for {} in {}{}",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}
