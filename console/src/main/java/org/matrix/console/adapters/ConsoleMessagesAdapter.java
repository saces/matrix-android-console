/*
 * Copyright 2015 OpenMarket Ltd
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

package org.matrix.console.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import org.matrix.androidsdk.MXSession;
import org.matrix.androidsdk.rest.model.Event;
import org.matrix.console.adapters.MessageRow;
import org.matrix.androidsdk.adapters.AbstractMessagesAdapter;
import org.matrix.androidsdk.db.MXMediasCache;
import org.matrix.androidsdk.rest.model.message.FileMessage;
import org.matrix.androidsdk.rest.model.message.ImageMessage;
import org.matrix.androidsdk.rest.model.message.Message;
import org.matrix.androidsdk.rest.model.message.VideoMessage;
import org.matrix.androidsdk.util.JsonUtils;
import org.matrix.console.ConsoleApplication;
import org.matrix.console.R;
import org.matrix.console.activity.CommonActivityUtils;
import org.matrix.console.activity.ImageSliderActivity;
import org.matrix.console.activity.MemberDetailsActivity;
import org.matrix.console.util.SlidableImageInfo;

import java.io.File;
import java.util.ArrayList;

/**
 * An adapter which can display room information.
 */
public class ConsoleMessagesAdapter extends AbstractMessagesAdapter {

    private Handler mUiHandler;

    public ConsoleMessagesAdapter(MXSession session, Context context, MXMediasCache mediasCache) {
        super(context, 0); // FIXME SACES

        // for dispatching data to add to the adapter we need to be on the main thread
        mUiHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void notifyDataSetChanged() {
        //  do not refresh the room when the application is in background
        // on large rooms, it drains a lot of battery
        if (!ConsoleApplication.isAppInBackground()) {
            super.notifyDataSetChanged();
        }
    }

    public int presenceOnlineColor() {
        return getContext().getResources().getColor(R.color.presence_online);
    }

    public int presenceOfflineColor() {
        return getContext().getResources().getColor(R.color.presence_offline);
    }

    public int presenceUnavailableColor() {
        return getContext().getResources().getColor(R.color.presence_unavailable);
    }

    @Override
    public void add(org.matrix.androidsdk.adapters.MessageRow messageRow, boolean b) {

    }

    @Override
    public void addToFront(org.matrix.androidsdk.adapters.MessageRow messageRow) {

    }

    @Override
    public org.matrix.androidsdk.adapters.MessageRow getMessageRow(String s) {
        return null;
    }

    @Override
    public org.matrix.androidsdk.adapters.MessageRow getClosestRow(Event event) {
        return null;
    }

    @Override
    public org.matrix.androidsdk.adapters.MessageRow getClosestRowFromTs(String s, long l) {
        return null;
    }

    @Override
    public org.matrix.androidsdk.adapters.MessageRow getClosestRowBeforeTs(String s, long l) {
        return null;
    }

    @Override
    public void updateEventById(Event event, String s) {

    }

    @Override
    public void removeEventById(String s) {

    }

    @Override
    public void setIsPreviewMode(boolean b) {

    }

    @Override
    public void setIsUnreadViewMode(boolean b) {

    }

    @Override
    public boolean isUnreadViewMode() {
        return false;
    }

    @Override
    public void setSearchPattern(String s) {

    }

    @Override
    public void resetReadMarker() {

    }

    @Override
    public void updateReadMarker(String s, String s1) {

    }

    @Override
    public int getMaxThumbnailWidth() {
        return 0;
    }

    @Override
    public int getMaxThumbnailHeight() {
        return 0;
    }

    @Override
    public void onBingRulesUpdate() {

    }
}
