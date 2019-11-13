package com.innovation.forbes.loginactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView container;
    private EditText url;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        container=findViewById(R.id.container);
        url=findViewById(R.id.url);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    public boolean verify(){
        if (url.getText().toString().isEmpty()){
            Toast.makeText(ImageActivity.this,"Enter URL",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!url.getText().toString().contains("http")){
            Toast.makeText(ImageActivity.this,"Enter valid URL",Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void onClick(View view){
        if (view==submit){
            if (verify()) {
                Toast.makeText(ImageActivity.this,"loading",Toast.LENGTH_SHORT).show();
                Picasso.get().load(url.getText().toString()).into(container);
            }
        }
    }
}
