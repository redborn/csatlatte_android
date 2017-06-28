package org.redborn.csatlatte.android.view.commons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.LoginIdActivity;
import org.redborn.csatlatte.android.view.MainActivity;
import org.redborn.csatlatte.android.view.MyInfoActivity;
import org.redborn.csatlatte.android.view.RandomQuestionActivity;
import org.redborn.csatlatte.android.view.SettingActivity;

import java.io.File;

/**
 * Created by admin on 2017-06-28.
 */

public class CsatlatteActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        Context context = getApplicationContext();
        boolean result = false;

        if (id == R.id.nav_home) {
            intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        } else if (id == R.id.nav_random_question) {
            intent = new Intent(context, RandomQuestionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        } else if (id == R.id.nav_settings) {
            intent = new Intent(context, SettingActivity.class);

        }

        if (intent != null) {
            result = true;
            startActivity(intent);
        }

        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            result = true;
        }

        return result;
    }

    public Intent navigationHeader(Context context, View view) {
        int id = view.getId();
        Intent intent = null;

        if (id == R.id.nav_header_layout) {
            intent = new Intent(context, LoginIdActivity.class);

        } else if (id == R.id.nav_header_layout_user) {
            intent = new Intent(context, MyInfoActivity.class);

        }

        return intent;
    }

    public void shootingNewPhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + "jpg";
        Uri imageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageCaptureUri);
        startActivityForResult(intent, 1);
    }

    public void takeAlbumPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, 2);
    }

}
