package org.redborn.csatlatte.android.view;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by admin on 2017-05-26.
 */

public class ListData {

    public Drawable icon;

    public String title;

    public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
    private final Collator collator = Collator.getInstance();

        @Override
        public int compare(ListData listData1, ListData listData2) {
            return collator.compare(listData1, listData2);
        }
    };

}
