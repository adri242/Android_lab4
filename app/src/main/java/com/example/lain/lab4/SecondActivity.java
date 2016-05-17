package com.example.lain.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void returnData(View v){
        Intent intent = getIntent();
        String data = intent.getStringExtra("myData");
        Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
    }

    /*public void closeActivity(View v){
        Intent returnIntent = new Intent();
        String retValue = "My data from Second Activity";
        returnIntent.putExtra("myResult",retValue);
        setResult(RESULT_OK,returnIntent);
        finish();
    }*/

    public void closeActivity(View v){
        Intent returnText = new Intent();
        EditText returningText;
        returningText = (EditText) findViewById(R.id.editText);
        String Text = returningText.getText().toString();
        returnText.putExtra("myText",Text);
        setResult(RESULT_OK,returnText);
        finish();
    }

}
