package com.example.std;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerContactAdapterMain2 extends RecyclerView.Adapter<RecyclerContactAdapterMain2.ViewHolder> {
    Context context;

    ArrayList<ContactModel> arrContacts;
    public int position;

    Listener lis;

    RecyclerContactAdapterMain2(Context context, ArrayList<ContactModel> arrContacts, Listener lis){
        this.context=context;
        this.arrContacts=arrContacts;
        this.lis = lis;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view, lis);
//        AppCompatActivity ac = new AppCompatActivity();
//        int num = R.layout.contact_row;
//        ac.setContentView(num);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
//        holder.btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent iNext;
//                iNext = new Intent(RecyclerContactAdapter.this, MainActivity2.class);
//                startActivity(iNext);
//                finish();
//            }
//        });
//        holder.txtNumber.setText(arrContacts.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgContact;
        Button btn2;
        Button btn3;
        Listener lis;

//        public void createRoom(View v){
//            System.out.println("IN");
//        }
        public ViewHolder(@NonNull View itemView, Listener lis) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
//            txtNumber=itemView.findViewById(R.id.txtNumber);
            imgContact=itemView.findViewById(R.id.imgContact);
            btn2 = itemView.findViewById(R.id.button2);
            this.lis = lis;
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Main3 onCreateClick");
                    int position=getAdapterPosition();
                    ContactModel contact=arrContacts.get(position);
                    String name=this.toString();

                    //lis.id = contact.id;
                    lis.onCreateClick(contact.id);
                }
            });
            btn3 = itemView.findViewById(R.id.button3);

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    ContactModel contact=arrContacts.get(position);
                    lis.onJoinClick(contact.id);
                }
            });

        }


    }
    public interface Listener{
        void onCreateClick(String id);
        //void onCreateClick();
        void onJoinClick(String id);
    }

}
