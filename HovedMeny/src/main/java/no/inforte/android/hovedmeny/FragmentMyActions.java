package no.inforte.android.hovedmeny;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentMyActions extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_myactions, container, false);


        Activity activity = getActivity();

        ListView listView1 = (ListView) mainView.findViewById(R.id.listViewMyActions);

        String[] items = getResources().getStringArray(R.array.mygoals);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, items);
        //listView1.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items));

        listView1.setAdapter(adapter);
        return mainView;
    }
}
