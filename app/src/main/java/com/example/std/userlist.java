package com.example.std;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {

    Button back2btn;
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter1 myAdapter;
    ArrayList<user1> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        String contactId = getIntent().getStringExtra("contact_id");
        System.out.println(contactId);
        recyclerView = findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference(contactId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter1(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    user1 user = dataSnapshot.getValue(user1.class);
                    list.add(user);


                }
                myAdapter.notifyDataSetChanged();
                //TextView textView = findViewById(R.id.tvfirstName);
                list.get(0).showData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back2btn = findViewById(R.id.back2Btn);
        back2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Main2 activity
                Intent intent = new Intent(userlist.this, Main2.class);
                startActivity(intent);
            }
        });
    }
}