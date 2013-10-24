package se.kjellstrand.viewholderantipattern;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class ItemListFragment extends ListFragment {

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new NoViewHolderAdapter(getActivity().getBaseContext()));
    }

}
