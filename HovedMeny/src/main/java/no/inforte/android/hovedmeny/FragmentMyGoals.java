package no.inforte.android.hovedmeny;

import android.support.v4.app.ListFragment;
import android.os.Bundle;

public class FragmentMyGoals extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Vekt", "Energi", "Fysisk form"};

        GoalListArrayAdapter goalListAdapter = new GoalListArrayAdapter(getActivity(),values);
        setListAdapter(goalListAdapter);

        getActivity().invalidateOptionsMenu();
    }
}