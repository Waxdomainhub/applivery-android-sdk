/*
 * Copyright (c) 2019 Applivery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.applivery.sample

import android.app.Application
import android.util.Log
import com.applivery.android.sdk.updates.IsUpToDateCallback
import com.applivery.applvsdklib.Applivery

class AppliveryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appPreferences = AppPreferences(applicationContext)

        if (BuildConfig.BUILD_TYPE != "release") {
            Applivery.init(this, BuildConfig.APPLIVERY_APP_TOKEN)
            Applivery.setCheckForUpdatesBackground(appPreferences.checkForUpdatesBackground)
        }

        com.applivery.android.sdk.Applivery.init(this, BuildConfig.APPLIVERY_APP_TOKEN)
        com.applivery.android.sdk.Applivery.getInstance().isUpToDate(object : IsUpToDateCallback{
            override fun onResponse(isUpToDate: Boolean) {

            }
        })
    }

    companion object {
        lateinit var appPreferences: AppPreferences
    }
}
