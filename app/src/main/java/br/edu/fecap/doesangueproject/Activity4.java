package br.edu.fecap.doesangueproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4); // Certifique-se de que o layout correto está sendo usado

        ImageView buttonBack = findViewById(R.id.button_back4);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}