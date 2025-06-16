package com.example.std;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MySignupApp extends AppCompatActivity {
    ///EditText Username;
     EditText inputEmail;
     EditText inputPassword;
     EditText inputConfirmPassword;
     Button btnRegister;
     String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
     ProgressDialog progressDialog;
     FirebaseAuth mAuth;
     FirebaseUser mUser;

    private DatabaseReference rootDatabaseref;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_signup_app);
        /// Username=findViewById(R.id.username);
        inputEmail = findViewById(R.id.inputEmaiL);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister=findViewById(R.id.btnRegister);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();
        ///rootDatabaseref= FirebaseDatabase.getInstance().getReference().child("mydata");

        ///EditText Username = (EditText) findViewById(R.id.username);

//        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);
//
//        regbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
////                ///String username1 = Username.getText().toString();
////                String row1=Username.getText().toString();
////                rootDatabaseref.setValue(Username);
//////                String row2=email.getText().toString();
//////                rootDatabaseref.se tValue(email);
//////                String row3=password.getText().toString();
//////                rootDatabaseref.setValue(password);
//////                String row4=repassword.getText().toString();
//////                rootDatabaseref.setValue(repassword);
////            ///    Toast.makeText(MySignupApp.this,"Username is"+username1,Toast.LENGTH_SHORT).show();
////                Intent i = new Intent(MySignupApp.this, Main.class);
////                startActivity(i);
////            }
////        })
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    perforAuth();
                }
            });


    }

                private void perforAuth() {
                    String email=inputEmail.getText().toString();
                    String password=inputPassword.getText().toString();
                    String confirmPassword=inputConfirmPassword.getText().toString();

                    if (!email.matches(emailPattern))
                    {
                        inputEmail.setError("Enter Correct Email");
                    } else if (password.isEmpty() || password.length()<6)
                    {
                        inputPassword.setError("Enter Proper Password");
                    } else if (!password.equals(confirmPassword))
                    {
                        inputConfirmPassword.setError("Password Not match Both fields");
                    }else
                    {
                        progressDialog.setMessage("Please Wait While Registration");
                        progressDialog.setTitle("Registration");
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();
                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    progressDialog.dismiss();
                                    sendUserToNextActivity();
                                    Toast.makeText(MySignupApp.this,"Registration Successful",Toast.LENGTH_SHORT).show();

                                }else
                                {
                                    progressDialog.dismiss();
                                    Toast.makeText(MySignupApp.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(MySignupApp.this,Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}