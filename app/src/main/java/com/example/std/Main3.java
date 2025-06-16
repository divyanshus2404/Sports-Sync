package com.example.std;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class Main3 extends AppCompatActivity {
    Button createBtn,back1Btn;
    EditText inputName,inputDate,inputTime,inputLocation,inputParticipant,inputPhone;

//    FirebaseUser mUser;
//    FirebaseAuth mAuth;

    //    private DatabaseReference rootDatabaseref;
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        System.out.println("hey");
        String contactId = getIntent().getStringExtra("contact_id");
        System.out.println(contactId);
        Button button = findViewById(R.id.back1Btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3.this, Main2.class); // Replace with the name of your second activity

                startActivity(intent);
            }
        });

//        EditText Roomname=(EditText) findViewById(R.id.roomname);
//        createbtn = findViewById(R.id.createbtn);
//        createbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(MainActivity2.this, MainActivity.class);
//                startActivity(i);
//
//                String Roomname1=Roomname.getText().toString();
//                Toast.makeText(MainActivity2.this, "RoomCreated "+Roomname1, Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        });
        System.out.println();
        inputName=findViewById(R.id.roomname);
        inputDate=findViewById(R.id.editTextDate);
        inputTime=findViewById(R.id.editTextTime);
        inputLocation=findViewById(R.id.editLocation);
        inputParticipant=findViewById(R.id.editTextParticipant);
        inputPhone=findViewById(R.id.editTextPhone);
/// /    progressDialog=new ProgressDialog(this);
////    mAuth=FirebaseAuth.getInstance();
//    mUser=mAuth.getCurrentUser();
        createBtn=findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforAuth();
                String RoomName = inputName.getText().toString();
                String Location = inputLocation.getText().toString();
                String Date = inputDate.getText().toString();
                HashMap<String, String> userMap=new HashMap<>();
                userMap.put("roomName",RoomName);
                userMap.put("Date",Location);
                userMap.put("Time",Date);
//                root.push().setValue(userMap);
              FirebaseDatabase.getInstance().getReference().child(contactId).push().setValue(userMap);
              //  perforAuth();

//            m.put("Location",inputLocation.getText().toString());
//            m.put("Participant",inputParticipant.getText().toString());
//            m.put("Phone",inputPhone.getText().toString());

            }
        });

    }
    private void perforAuth() {
        String RoomName = inputName.getText().toString();
        String Location = inputLocation.getText().toString();
        String Date = inputDate.getText().toString();
        String Time = inputTime.getText().toString();
        String Participant = inputParticipant.getText().toString();
        String Phone = inputPhone.getText().toString();

        if (RoomName.isEmpty()) {
            inputName.setError("Enter Proper Password");
        } else if (Location.isEmpty()) {
            inputLocation.setError("Enter Proper Password");
        } else if (Date.isEmpty()) {
            inputDate.setError("Enter Proper Password");
        } else if (Time.isEmpty()) {
            inputTime.setError("Enter Proper Password");
        } else if (Participant.isEmpty()) {
            inputParticipant.setError("Enter Proper Password");
        } else if (Phone.isEmpty()) {
            inputPhone.setError("Enter Proper Password");
        } else {
            sendUserToNextActivity();
            Toast.makeText(Main3.this,"Registration Successful",Toast.LENGTH_SHORT).show();
//            progressDialog.setMessage("Please Wait While Room is being Created ");
//            progressDialog.setTitle("Room Creation");
//            progressDialog.setCanceledOnTouchOutside(false);
//            progressDialog.show();

//            FirebaseDatabase.addOnCompleteListener(new OnCompleteListener() {
//
//                @Override
//                public void onComplete(@NonNull Task task) {
//                    if (task.isSuccessful()) {
//                        progressDialog.dismiss();
//                        sendUserToNextActivity();
//                        Toast.makeText(MainActivity2.this, "Room Creation Successful", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        progressDialog.dismiss();
//                        Toast.makeText(MainActivity2.this, "Enter Details Correctly" + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
        }
    }


    private void sendUserToNextActivity() {
        Intent intent=new Intent(Main3.this,Main2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



}