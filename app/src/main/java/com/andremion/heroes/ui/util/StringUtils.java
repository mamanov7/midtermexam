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

package com.andremion.heroes.ui.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.andremion.heroes.R;
import com.andremion.heroes.api.MarvelException;

import java.io.IOException;

public class StringUtils {

    private StringUtils() {
    }

    public static String getApiErrorMessage(@NonNull Context context, @NonNull Throwable e) {
        if (e instanceof IOException) {
            return context.getString(R.string.connection_error);
        } else if (e instanceof MarvelException) {
            return context.getString(R.string.server_error);
        } else {
            return "";
        }
    }

}