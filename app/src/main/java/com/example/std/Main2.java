package com.example.std;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.std.RecyclerContactAdapterMain2.Listener;

import java.util.ArrayList;

public class Main2 extends AppCompatActivity implements Listener{
    String id;
    ArrayList<ContactModel> arrContatcts=new ArrayList<>();

    public void setId(String id){
        this.id = id;
    }
    @Override
    public void onCreateClick(String id) {
        Intent iNext = new Intent(Main2.this, Main3.class);
        iNext.putExtra("contact_id", id);
        startActivity(iNext);
        finish();
    }

    @Override
    public void onJoinClick(String id) {
        Intent iNext;
        iNext = new Intent(Main2.this, userlist.class);
        iNext.putExtra("contact_id", id);
        startActivity(iNext);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        RecyclerView recyclerView=findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrContatcts.add(new ContactModel(R.drawable.cricket_bat,"Cricket","c"));
        arrContatcts.add(new ContactModel(R.drawable.ftbal,"Foot Ball","f"));
        arrContatcts.add(new ContactModel(R.drawable.hockey,"Hockey","h"));
        arrContatcts.add(new ContactModel(R.drawable.basketball,"Basket Ball", "bas"));
        arrContatcts.add(new ContactModel(R.drawable.download,"Badminton","d"));
        arrContatcts.add(new ContactModel(R.drawable.lawntennis,"Lawn Tennis","lt"));
        arrContatcts.add(new ContactModel(R.drawable.kabaddi,"Lawn Tennis","k"));
        arrContatcts.add(new ContactModel(R.drawable.volleyball,"Volley Ball","v"));
        arrContatcts.add(new ContactModel(R.drawable.tabletennis,"Table Tennis","tb"));
        arrContatcts.add(new ContactModel(R.drawable.kabaddi,"Kabaddi","kab"));
        arrContatcts.add(new ContactModel(R.drawable.khokho,"Kho-Kho","kho"));
        arrContatcts.add(new ContactModel(R.drawable.swimming,"Swimming","sw"));
        arrContatcts.add(new ContactModel(R.drawable.karate,"Karate","ka"));
        arrContatcts.add(new ContactModel(R.drawable.chess,"Chess","ch"));
        arrContatcts.add(new ContactModel(R.drawable.fooseball,"Foose Ball","fos"));
        arrContatcts.add(new ContactModel(R.drawable.ballpool,"8-Bit Pool","bal"));
        arrContatcts.add(new ContactModel(R.drawable.snooker,"Snooker","sn"));

        RecyclerContactAdapterMain2 adapter=new RecyclerContactAdapterMain2(this,arrContatcts, this);
        recyclerView.setAdapter(adapter);

//        setContentView(R.layout.contact_row);
//
//        Button3 = findViewById(R.id.button3);
//        Button2 = findViewById(R.id.button2);
//        System.out.println("Here");
//        Button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent iNext;
//                iNext = new Intent(contact_row.this, Main22.class);
//                startActivity(iNext);
//                finish();
//            }
//        });
    }
}