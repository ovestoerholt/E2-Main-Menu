package no.inforte.android.hovedmeny;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentMyTriggers extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_mytriggers, container, false);

        Activity activity = getActivity();

        ListView listView1 = (ListView) activity.findViewById(R.id.listViewMyTriggers);

        String[] items = { "Glad", "Sint", "Gira", "Sulten", "Oppblåst" };

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items);
        //listView1.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items));

        listView1.setAdapter(adapter);



        return mainView;
    }


}
