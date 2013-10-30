package se.kjellstrand.viewholderantipattern;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


/**
 * Created by Carl-Emil Kjellstrand on 10/25/13.
 */
public class ItemListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

    }

}
