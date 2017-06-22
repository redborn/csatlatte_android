package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

import java.io.File;

/**
 * Created by admin on 2017-06-21.
 */

public class MyInfoModifyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo_modify_profile_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton btnMyInfoModifyProfileImage = (ImageButton) findViewById(R.id.btn_myinfo_modify_profile_image);
        Button btnMyInfoModifyProfileComplete = (Button) findViewById(R.id.btn_myinfo_modify_profile_complete);
        btnMyInfoModifyProfileImage.setOnClickListener(this);
        btnMyInfoModifyProfileComplete.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = new Navigation(getApplicationContext()).header(view);

        if (id == R.id.btn_myinfo_modify_profile_complete) {
            onBackPressed();
        } else if (id == R.id.btn_myinfo_modify_profile_image) {
            CharSequence[] items = {"사진촬영", "앨범선택", "취소"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("업로드할 이미지 선택");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int index) {
                    switch (index) {
                        case 0:
                            shootingNewPhoto();
                            break;
                        case 1:
                            takeAlbumPhoto();
                            break;
                        case 2:
                            dialogInterface.dismiss();
                            break;
                    }
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }

        if (intent != null) {
            startActivity(intent);
        }
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
