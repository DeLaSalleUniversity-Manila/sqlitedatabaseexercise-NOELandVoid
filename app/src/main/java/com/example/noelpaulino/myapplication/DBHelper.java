package com.example.noelpaulino.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.*;
/**
 * Created by Noel Paulino on 10/20/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "moonbucks";
    private static final int DB_VERSION = 2;

    DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

   public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
       updateMyDatabase(db, oldVersion, newVersion);
   }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion<1){
            db.execSQL("CREATE ALCOHOL ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER); ");
            insertDrink(db, "Pina Colada", "Rum, coconut cream, and pineapple juice with ice", R.drawable.pinacolada);//ADD IMAGES
            insertDrink(db, "Bacardi", "Rum, lemon juice, and sugar", R.drawable.bacardi);//ADD IMAGES
            insertDrink(db, "Mojito", "White rum, sugar, lime juice, sparkling water, and mint", R.drawable.mojito);//ADD IMAGES
            insertDrink(db, "Daiquiri", "Rum, citrus juice, sugar", R.drawable.daiquiri);//ADD IMAGES
            insertDrink(db, "Don Julio", "Originated in Mexico. 80 proof", R.drawable.donjulio);//ADD IMAGES

        }
        insertDrink(db, "Jose Cuervo", "World's best selling tequila. 70-80 proof", R.drawable.josecuervo);//ADD IMAGES
        insertDrink(db, "Patron", "Also originated in Mexico. 80 proof", R.drawable.patron);//ADD IMAGES
        insertDrink(db, "Danzka", "Produced in Denmark. Made from Danish wheat", R.drawable.danzka);//ADD IMAGES
        insertDrink(db, "Grey Goose", "Produced in France. Made from wheat produced in Picardy, France", R.drawable.greygoose);//ADD IMAGES
        insertDrink(db, "Absolut", "Produced in Sweden. Made from winter wheat", R.drawable.absolut);//ADD IMAGES
        if (oldVersion<2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }


}
