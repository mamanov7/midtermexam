/*
 * Copyright (c) 2017. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.andremion.heroes.api.auth;

import com.andremion.heroes.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticatorInterceptor implements Interceptor {

    private static final String QUERY_NAME_TIMESTAMP = "ts";
    private static final String QUERY_NAME_APIKEY = "apikey";
    private static final String QUERY_NAME_HASH = "hash";

    @Override
    public Response intercept(Chain chain) throws IOException {

        String ts = String.valueOf(System.currentTimeMillis());
        String hash = HashHelper.generate(ts + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_PUBLIC_KEY);

        Request currentRequest = chain.request();

        HttpUrl url = currentRequest.url().newBuilder()
                .addQueryParameter(QUERY_NAME_TIMESTAMP, ts)
                .addQueryParameter(QUERY_NAME_APIKEY, BuildConfig.MARVEL_PUBLIC_KEY)
                .addQueryParameter(QUERY_NAME_HASH, hash).build();

        Request newRequest = currentRequest.newBuilder().url(url).build();

        return chain.proceed(newRequest);
    }
}
