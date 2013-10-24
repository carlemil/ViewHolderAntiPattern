package se.kjellstrand.viewholderantipattern;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public class ItemListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

    }

}
