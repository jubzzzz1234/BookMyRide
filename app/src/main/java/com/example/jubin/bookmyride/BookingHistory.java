package com.example.jubin.bookmyride;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingHistory extends Fragment {
    Realm realm;
    ListView listView;
    List<ModelClass> model;


    public BookingHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_booking_history, container, false);

        model=new ArrayList<>();
        Realm.init(getActivity());
        realm=Realm.getDefaultInstance();
        listView=(ListView)view.findViewById(R.id.listview);

        RealmResults<RealmClass> results=realm.where(RealmClass.class).findAll();
        for (RealmClass realmClass:results)
        {
            ModelClass modelClass=new ModelClass(realmClass.getCar(),realmClass.getBaseFare(),realmClass.getExtra(),
            realmClass.getName(),realmClass.getNo(),realmClass.getPurpose(),realmClass.getDate(),
                    realmClass.getTime(),realmClass.getStatus());
            model.add(modelClass);


        }

        AdapterClass adapterClass=new AdapterClass(getActivity(),model);
        listView.setAdapter(adapterClass);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ModelClass modelClass=model.get(position);
                update(modelClass.getNo());
            }


        });
        return view;
    }

    private void update(final String no) {
        AlertDialog.Builder dialogbuilder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View update=inflater.inflate(R.layout.dialogbox,null);
        dialogbuilder.setView(update);

        final EditText edt_no=(EditText)update.findViewById(R.id.edt_no);
        final EditText edt_statusup=(EditText)update.findViewById(R.id.edt_statusup);

        edt_no.setText(no);
        edt_statusup.setText("Returned");
        final String stat=edt_statusup.getText().toString();
        final Button btn_update=(Button)update.findViewById(R.id.btn_uptd);
        final Button btn_delete=(Button) update.findViewById(R.id.btn_del);
        dialogbuilder.setTitle(" Update your Booking status for \n Mobile no "+ no);
        final AlertDialog alertDialog=dialogbuilder.create();
        alertDialog.show();

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBooking(no);
                alertDialog.dismiss();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBook(no,stat);
                alertDialog.dismiss();
            }
        });

    }

    private void updateBook(String no,String stat) {
        RealmResults<RealmClass> result=realm.where(RealmClass.class).equalTo("no",no).findAll();
        realm.beginTransaction();

        for(RealmClass realmClass : result)
        {
            realmClass.setStatus(stat);
        }
        realm.commitTransaction();
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);


    }

    private void deleteBooking(String no) {

        RealmResults<RealmClass> result=realm.where(RealmClass.class).equalTo("no",no).findAll();
        realm.beginTransaction();
        result.deleteAllFromRealm();
        realm.commitTransaction();
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        realm.close();
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
