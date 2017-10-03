package com.abhimanyusharma.appshowcasetutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class Main2Activity extends AppCompatActivity {

    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button4 = (Button) findViewById(R.id.b4);

        Target target4 = new ViewTarget(R.id.b4, this);

        new ShowcaseView.Builder(this)
                .setTarget(target4)
                .setContentTitle("Button 4")
                .setContentText("Tap here to goto resume folder")
                //.hideOnTouchOutside()//this will hide the tutorial on touch outsuide
                .build();

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

}
