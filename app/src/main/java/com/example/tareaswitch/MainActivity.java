package com.example.tareaswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SwitchCompat sB = findViewById(R.id.switch1);   //Usando switch se me congelaba y dejaba de responder
        ImageView myImageView = findViewById(R.id.imageView2);

        //sB.setTextOn("Visible");      No hubo manera de que esto funcionase como en
        //sB.setTextOff("Invisible");   el button del anterior ejercicio

        sB.setChecked(true);
        sB.setText("Visible");

        sB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b){
                if (b){
                    sB.setText("Visible");
                    myImageView.setVisibility(View.VISIBLE);
                }else{
                    sB.setText("Invisible");
                    myImageView.setVisibility(View.GONE);
                }
            }
        });
    }
}