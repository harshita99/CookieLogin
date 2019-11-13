package com.innovation.forbes.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button submit;
    private EditText phno;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phno=findViewById(R.id.phno);
        pass=findViewById(R.id.pass);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    private void toast(String m){
        Toast.makeText(MainActivity.this,m,Toast.LENGTH_SHORT).show();
    }

    private boolean verify(){
        if (phno.getText().toString().isEmpty()){
            toast("enter phone number");
            return false;
        }
        else if(phno.getText().toString().length()!=10 ){
            toast("Enter a 10 digit number");
            return false;
        }
        else if(pass.getText().toString().isEmpty() ){
            toast("enter password");
            return false;
        }
        else if(pass.getText().toString().length()<6){
            toast("enter a password containing atleast 6 characters");
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void onClick(View view){
        if (view==submit){
            if (verify()){
                toast("Login Successful");
                Intent intent=new Intent(MainActivity.this,ImageActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

}
