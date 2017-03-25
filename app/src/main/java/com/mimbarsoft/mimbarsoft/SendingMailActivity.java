package com.mimbarsoft.mimbarsoft;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendingMailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_mail);
    }
    public void sendMail(View view){
        EditText editTextSubject = (EditText) findViewById(R.id.mail_subject);
        EditText editTextMessage = (EditText) findViewById(R.id.message);

        String subject = editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        // mail recipant have to pass as an array
        String[] recipent = {"contact@mimbarsoft.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,recipent);
        Intent chooseIntent = intent.createChooser(intent,"Choose a service");
        startActivity(chooseIntent);
    }
}
