package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.R;
import com.example.medsy.entity.Users;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Contacts extends Fragment {
    private ListView contactsListView;
    private DoctorContactAdapter doctorContactAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contacts,container,false);
        contactsListView = view.findViewById(R.id.contact_List);
        List<Users> users = new ArrayList<>();
        Users user1 = new Users();
        user1.setuName("zhangsan");
        users.add(user1);
        doctorContactAdapter = new DoctorContactAdapter(getContext(),users,R.layout.contact_users_item);
        contactsListView.setAdapter(doctorContactAdapter);
        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),Chat.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
