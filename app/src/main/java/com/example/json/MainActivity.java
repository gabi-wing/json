package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create gson object
        Gson gson = new Gson();

        Address address = new Address("Germany", "Berlin");

        ArrayList<FamilyMember> family = new ArrayList<>();
        family.add(new FamilyMember("wife", 30));
        family.add(new FamilyMember("son", 12));


        //turn employee object into string using gson
        Employee employee = new Employee("John", 30, "john@gmail.com", address, family);
        String json = gson.toJson(employee);
        //turn string back into object
        Employee employee2 = gson.fromJson(json, Employee.class);

        //address list to string
        String json2 = gson.toJson(family);

        //turn string back into array list
        Type familyType = new TypeToken<ArrayList<FamilyMember>>(){}.getType();
        ArrayList<FamilyMember> family2 = gson.fromJson(json2,familyType);
    }
}