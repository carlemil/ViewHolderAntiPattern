package se.kjellstrand.viewholderantipattern;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

/**
 * Created by Carl-Emil Kjellstrand on 10/25/13.
 */
public class ItemListFragment extends ListFragment {

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ItemAdapter(getActivity().getBaseContext()));
    }
}
