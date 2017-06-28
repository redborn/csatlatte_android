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
import org.redborn.csatlatte.android.view.commons.CsatlatteActivity;

import java.io.File;

/**
 * Created by admin on 2017-06-21.
 */

public class MyInfoModifyProfileActivity extends CsatlatteActivity implements View.OnClickListener {

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
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = null;

        if (id == R.id.btn_myinfo_modify_profile_complete) {
            intent = new Intent(context, MyInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

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
}
