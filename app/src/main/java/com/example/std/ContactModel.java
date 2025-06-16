package com.example.std;

public class ContactModel {
    int img;
    String name,id;

    public ContactModel(int img,String name,String id){
        this.name=name;
        this.img=img;
        this.id=id;
    }
   
    public String getName() {
        return name;
    }
}
