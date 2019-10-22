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

package com.andremion.heroes.ui.home;

import android.support.annotation.NonNull;

import com.andremion.heroes.api.data.CharacterVO;

import java.util.List;

public interface MainContract {

    interface View {

        void showProgress();

        void stopProgress(boolean hasMore);

        void showAttribution(String attribution);

        void showResult(@NonNull List<CharacterVO> entries);

        void showError(@NonNull Throwable e);

        void openCharacter(@NonNull android.view.View heroView, @NonNull CharacterVO character);

        void openSearch();
    }

    interface Actions {

        void initScreen();

        void loadCharacters(int offset);

        void characterClick(@NonNull android.view.View heroView, @NonNull CharacterVO character);

        void searchClick();

        void refresh();
    }
}
