package com.hawkins.tapducky.launcher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public final class MainActivity extends Activity {
    private static final String TARGET_PACKAGE = "org.kaijinlab.tap_ducky";
    private static final String TARGET_ACTIVITY = "org.kaijinlab.tap_ducky.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openTapDucky();
    }

    private void openTapDucky() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(TARGET_PACKAGE);

        if (launchIntent == null) {
            launchIntent = new Intent().setClassName(TARGET_PACKAGE, TARGET_ACTIVITY);
        }

        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

        try {
            startActivity(launchIntent);
        } catch (ActivityNotFoundException | SecurityException error) {
            Toast.makeText(
                    this,
                    "TapDucky is not installed or cannot be opened.",
                    Toast.LENGTH_LONG
            ).show();
        } finally {
            finish();
        }
    }
}
