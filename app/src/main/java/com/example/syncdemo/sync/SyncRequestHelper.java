package com.example.syncdemo.sync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.os.Bundle;

public class SyncRequestHelper {
    public void requestPeriodicSyncWithMinuteFrequency(Account account, String contentAuthority, int frequency) {
        ContentResolver.setSyncAutomatically(account, contentAuthority, true);
        ContentResolver.addPeriodicSync(account, contentAuthority, Bundle.EMPTY, frequency * 60);
    }

    public void requestImmediateSync(Account account, String contentAuthority) {
        Bundle syncSettingsBundle = new Bundle();
        syncSettingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL,
                true);
        syncSettingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED,
                true);

        ContentResolver.requestSync(account, contentAuthority, syncSettingsBundle);
    }
}
