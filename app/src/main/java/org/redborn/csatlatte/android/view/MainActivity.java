package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import org.redborn.csatlatte.android.view.commons.Navigation;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.commons.Navigation;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ListView listView = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ImageView appBarBackground = (ImageView) findViewById(R.id.app_bar_background);
        appBarBackground.setImageResource(R.drawable.title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        LinearLayout linearLayout = (LinearLayout) headerLayout.findViewById(R.id.nav_header_layout);
        linearLayout.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ListViewAdapter(this);
        listView.setAdapter(adapter);

        adapter.addItem(getResources().getDrawable(R.drawable.ic_menu_pencil), "임의 문제 풀기");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_menu_info), "웹사이트 방문하기");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListData data = adapter.listData.get(i);
                Context context = getApplicationContext();

                if (data.title == "임의 문제 풀기") {
                    Intent intent = new Intent(context, RandomQuestionActivity.class);
                    startActivity(intent);
                } else if (data.title == "웹사이트 방문하기") {

                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean result = false;
        Intent intent = new Navigation(getApplicationContext()).select(item);

        if (intent != null) {
            result = true;
            startActivity(intent);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

        return result;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Navigation(getApplicationContext()).header(view);

        if (intent != null) {
            startActivity(intent);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
