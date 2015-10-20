package com.example.noelpaulino.myapplication;

import android.os.Bundle;
import android.app.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Noel Paulino on 10/20/2015.
 */
public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKNO = "drinkNo";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inumin);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());



    }

}
