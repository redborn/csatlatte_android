package org.redborn.csatlatte.android.view.commons;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import org.redborn.csatlatte.android.R;
import org.redborn.csatlatte.android.view.MainActivity;
import org.redborn.csatlatte.android.view.RandomQuestionActivity;

/**
 * Created by admin on 2017-06-14.
 */

public class Navigation {

    public Intent select(MenuItem item, Context context) {
        int id = item.getItemId();
        Intent intent = new Intent();


        if (id == R.id.nav_home) {
            intent = new Intent(context, MainActivity.class);

        } else if (id == R.id.nav_random_question) {
            intent = new Intent(context, RandomQuestionActivity.class);

        } else if (id == R.id.nav_settings) {

        }

        return intent;
    }

}
