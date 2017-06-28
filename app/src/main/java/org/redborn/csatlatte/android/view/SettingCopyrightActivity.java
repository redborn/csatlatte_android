package org.redborn.csatlatte.android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.CsatlatteActivity;

/**
 * Created by admin on 2017-06-21.
 */

public class SettingCopyrightActivity extends CsatlatteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_copyright_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}