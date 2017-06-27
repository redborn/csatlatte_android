package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemClickListener {

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

        boolean isLogin = true; // 로그인 상태를 표시함, true = 로그인 상태 / false = 로그오프 상태, 화면 리뷰 이후 cache를 활용해서 처리 예정
        LinearLayout navHeaderLayoutUser = (LinearLayout) headerLayout.findViewById(R.id.nav_header_layout_user);
        LinearLayout linearLayout = (LinearLayout) headerLayout.findViewById(R.id.nav_header_layout);
        if (isLogin) {
            navHeaderLayoutUser.setOnClickListener(this);
            linearLayout.setVisibility(LinearLayout.GONE);
        } else {
            navHeaderLayoutUser.setVisibility(LinearLayout.GONE);
            linearLayout.setOnClickListener(this);
        }


        listView = (ListView) findViewById(R.id.listView);

        adapter = new ListViewAdapter(this);
        listView.setAdapter(adapter);

        adapter.addItem(getResources().getDrawable(R.drawable.ic_menu_pencil), "임의 문제 풀기");
        adapter.addItem(getResources().getDrawable(R.drawable.ic_menu_info), "웹사이트 방문하기");

        listView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListData data = adapter.listData.get(i);
        Context context = getApplicationContext();
        Intent intent = null;

        if (data.title == "임의 문제 풀기") {
            intent = new Intent(context, RandomQuestionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        } else if (data.title == "웹사이트 방문하기") {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.csatlatte.com"));

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
