package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

/**
 * Created by admin on 2017-06-16.
 */

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView settingListView = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settingListView = (ListView) findViewById(R.id.settingListView);
        adapter = new ListViewAdapter(this);
        settingListView.setAdapter(adapter);

        adapter.addItem(getResources().getDrawable(R.drawable.ic_menu_settings), "임의 문제 풀기 설정");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_copyright), "Copyright");

        settingListView.setOnItemClickListener(this);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListData data = adapter.listData.get(i);
        Context context = getApplicationContext();
        Intent intent = null;

        if (data.title == "임의 문제 풀기 설정") {
            intent = new Intent(context, SettingRandomQuestionActivity.class);
        } else if (data.title == "Copyright") {

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
