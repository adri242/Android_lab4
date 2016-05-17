package com.example.lain.lab4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivity(View v) {
        Intent act2 = new Intent(this, SecondActivity.class);
        startActivity(act2);
    }

    public void makePhoneCall(View v) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        startActivity(call);
    }

    public void startWebPage(View v) {
        String web = "http://www.agh.edu.pl";
        Intent webpage = new Intent(Intent.ACTION_VIEW);
        webpage.setData(Uri.parse(web));
        startActivity(webpage);
    }

    public void openContacts(View v) {
        Intent contact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivity(contact);
    }

    public void passData(View v) {
        Intent act2 = new Intent(this, SecondActivity.class);
        act2.putExtra("myData", "myValue");
        startActivity(act2);
    }

    public void startForActivityData(View v) {
        Intent act2 = new Intent(this, SecondActivity.class);
        startActivityForResult(act2, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String data2 = data.getStringExtra("myText");
                Context context = getApplicationContext();
                Toast.makeText(context, data2, Toast.LENGTH_SHORT).show();
            }
        }
    }
}