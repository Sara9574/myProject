package com.sara.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

import com.idunnololz.widgets.AnimatedExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuFragment extends Fragment {
    int previousGroup=-1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView toolbarTitle;
        toolbarTitle = view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getString(R.string.bot_menu));

        final AnimatedExpandableListView listView;
         final ExpandableListAdapter listAdapter;
         List<String> listDataHeader;
         HashMap<String,List<String>> listHash;

        listView = view.findViewById(R.id.catMenu);
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        initData(listDataHeader,listHash);
        listAdapter = new ExpandableListAdapter(getContext(),listDataHeader,listHash);
        listView.setAdapter(listAdapter);



        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                    previousGroup=-1;
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                    if(previousGroup!=-1){
                        listView.collapseGroupWithAnimation(previousGroup);
                    }
                    previousGroup=groupPosition;
                }

                return true;
            }

        });

        listView.setOnChildClickListener(new OnChildClickListener() {



            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                final String selected = (String) listAdapter.getChild(
                        groupPosition, childPosition);

                Intent intent;


                switch(selected){
                    case "\u200Fاول ابتدایی":
                        intent = new Intent(getActivity(),ListOfSubjectsActivity.class);
                        intent.putExtra("title","\u200Fاول ابتدایی");
                        startActivity(intent);
                        break;

                    case "\u200Fدوم ابتدایی":
                        intent = new Intent(getActivity(),ListOfSubjectsActivity.class);
                        intent.putExtra("title","\u200Fدوم ابتدایی");
                        startActivity(intent);

                        break;

                    case "\u200Fسوم ابتدایی":
                        intent = new Intent(getActivity(),ListOfSubjectsActivity.class);
                        intent.putExtra("title","\u200Fسوم ابتدایی");
                        startActivity(intent);

                        break;
                }

                return true;
            }
        });



    }

    private void initData(List<String> listDataHeader,HashMap<String,List<String>> listHash) {

        String ebt = "\u200Fابتدایی";
        String mot1 = "\u200Fمتوسطه اول";
        String mot2 = "\u200Fمتوسطه دوم";
        String konkoor = "\u200Fکنکور سراسری";
        String zab = "\u200Fزبان‌های خارجی";
        String ol = "\u200Fالمپیاد علمی";
        String uni = "\u200Fدروس دانشگاهی";


        String ebt1 = "\u200Fاول ابتدایی";
        String ebt2 = "\u200Fدوم ابتدایی";
        String ebt3 = "\u200Fسوم ابتدایی";
        String ebt4 = "\u200Fچهارم ابتدایی";
        String ebt5 = "\u200Fپنجم ابتدایی";
        String ebt6 = "\u200Fششم ابتدایی";

        String mot1_1 = "\u200Fهفتم ابتدایی";
        String mot1_2 = "\u200Fهشتم ابتدایی";
        String mot1_3 = "\u200Fنهم ابتدایی";

        listDataHeader.add(ebt);
        listDataHeader.add(mot1);
        listDataHeader.add(mot2);
        listDataHeader.add(konkoor);
        listDataHeader.add(zab);
        listDataHeader.add(ol);
        listDataHeader.add(uni);

        List<String> something = new ArrayList<>();
        something.add(ebt1);
        something.add(ebt2);
        something.add(ebt3);
        something.add(ebt4);
        something.add(ebt5);
        something.add(ebt6);

        List<String> someOtherThing = new ArrayList<>();
        someOtherThing.add(mot1_1);
        someOtherThing.add(mot1_2);
        someOtherThing.add(mot1_3);

        List<String> somethingElse = new ArrayList<>();
        somethingElse.add("Salad");
        somethingElse.add("Beer");

        List<String> anotherThing = new ArrayList<>();
        anotherThing.add("hello! :)");
        anotherThing.add("Goodbye! :(");

        List<String> lastThing = new ArrayList<>();
        lastThing.add("hello! :)");
        lastThing.add("I'm Sara :)");
        lastThing.add("Goodbye! :(");


        List<String> olThing = new ArrayList<>();
        olThing.add("hello! :)");
        olThing.add("I'm Sara :)");
        olThing.add("Goodbye! :(");

        List<String> uniThings = new ArrayList<>();
        uniThings.add("hello! :)");
        uniThings.add("I'm Sara :)");
        uniThings.add("Goodbye! :(");

        listHash.put(listDataHeader.get(0),something);
        listHash.put(listDataHeader.get(1),someOtherThing);
        listHash.put(listDataHeader.get(2),somethingElse);
        listHash.put(listDataHeader.get(3),anotherThing);
        listHash.put(listDataHeader.get(4),lastThing);
        listHash.put(listDataHeader.get(5),olThing);
        listHash.put(listDataHeader.get(6),uniThings);

    }



}

