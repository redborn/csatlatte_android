package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.CsatlatteActivity;

/**
 * Created by admin on 2017-06-16.
 */

public class JoinLoginInfoActivity extends CsatlatteActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_login_info_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.join_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnJoinLoginInfoNext = (Button) findViewById(R.id.btn_join_login_info_next);
        btnJoinLoginInfoNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Context context = getApplicationContext();
        Intent intent = null;

        if (id == R.id.btn_join_login_info_next) {
            intent = new Intent(context, JoinSecurityActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}