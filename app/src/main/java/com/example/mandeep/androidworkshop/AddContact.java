package com.example.mandeep.androidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {

    DatabaseReference root;
    EditText name, numb;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addconatct);

        // get database reference
        root = FirebaseDatabase.getInstance().getReference();

        name = (EditText) findViewById(R.id.name);
        numb = (EditText) findViewById(R.id.number);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact temp = new Contact();

                temp.setName(name.getText().toString());
                temp.setPh(numb.getText().toString());

                root.push().setValue(temp);

                Toast.makeText(getApplicationContext(),"contact added",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
