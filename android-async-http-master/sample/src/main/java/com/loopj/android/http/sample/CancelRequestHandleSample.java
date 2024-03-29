/*
    Android Asynchronous Http Client Sample
    Copyright (c) 2014 Marek Sebera <marek.sebera@gmail.com>
    https://loopj.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.loopj.android.http.sample;

import android.util.Log;

import java.util.Locale;

import com.loopj.android.http.RequestHandle;

public class CancelRequestHandleSample extends ThreadingTimeoutSample {

    private static final String LOG_TAG = "CancelRequestHandleSample";

    @Override
    public int getSampleTitle() {
        return R.string.title_cancel_handle;
    }

    @Override
    public void onCancelButtonPressed() {
        Log.d(LOG_TAG, String.format(Locale.US, "Number of handles found: %d", getRequestHandles().size()));
        int counter = 0;
        for (RequestHandle handle : getRequestHandles()) {
            if (!handle.isCancelled() && !handle.isFinished()) {
                Log.d(LOG_TAG, String.format(Locale.US, "Cancelling handle %d", counter));
                Log.d(LOG_TAG, String.format(Locale.US, "Handle %d cancel", counter) + (handle.cancel(true) ? " succeeded" : " failed"));
            } else {
                Log.d(LOG_TAG, String.format(Locale.US, "Handle %d already non-cancellable", counter));
            }
            counter++;
        }
    }
}
