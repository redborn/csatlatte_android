package org.redborn.csatlatte.android.view;

import android.app.Dialog;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by admin on 2017-06-16.
 */

public class JoinProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_profile_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.join_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> satList = new ArrayList<String>();
        satList.add("2018학년도 대학수학능력시험(2017년 실시)");
        satList.add("2019학년도 대학수학능력시험");
        satList.add("2020학년도 대학수학능력시험");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, satList);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_sat_list);
        spinner.setAdapter(adapter);

        Button btnJoinSecurityNext = (Button) findViewById(R.id.btn_join_complete);
        ImageButton btnProfileImageUpload = (ImageButton) findViewById(R.id.btn_profile_image_upload);
        btnJoinSecurityNext.setOnClickListener(this);
        btnProfileImageUpload.setOnClickListener(this);
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
        Intent intent = new Navigation(context).header(view);

        if (id == R.id.btn_join_complete) {
            intent = new Intent(context, JoinResultActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        } else if (id == R.id.btn_profile_image_upload) {
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
