package com.cmps121.ucscdining;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class nutritionActivity extends AppCompatActivity {

    String URL = "";

    String menu,serving,cal,cal_fat,total_fat,sat_fat,sat_fat_percent, tran_fat, chol, chol_percent
            ,sodium,sodium_percent, total_car,total_car_percent,fiber,fiber_percent,sugar,protein,vit_a,vit_b12,vit_c
            ,iron,ingredient, allergen;
    private final String TAG = "TAG";


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        // pull extra
        // Take DH link and set that = URL
        // Use URL for next bit of code with "connect"
        Intent i = getIntent();
        int x = 0;
        int DH = i.getIntExtra("DH", x);

        // HardCode   URL for now
        URL = "http://nutrition.sa.ucsc.edu/label.asp?locationNum=40&locationName=Colleges+Nine+%26+Ten+Dining+Hall&dtdate=05%2F16%2F2018&RecNumAndPort=700071%2A4";



        //AsyncTask Required to do HTML parsing
        new AsyncTask<Void, Void, ArrayList<String>>() {

            @Override
            protected ArrayList<String> doInBackground(Void... voids) {

                ArrayList<String> aList = new ArrayList<String>();
                String title = "";

                // Gets HTML from dining hall website and adds relevant information to an array list.
                try {

                    Document page = Jsoup.connect(URL).get();
                    Elements fonts = page.select("font");


                    menu = page.select("div").get(0).text();
                    serving = fonts.get(2).text();
                    cal = fonts.get(3).text();//page.select("b").get(1).text();
                    cal_fat = fonts.get(4).text();
                    total_fat = fonts.get(11).text();
                    sat_fat = fonts.get(18).text();
                    sat_fat_percent = fonts.get(57).text().substring(1);
                    tran_fat = fonts.get(26).text();
                    chol = fonts.get(32).text();
                    chol_percent = fonts.get(61).text().substring(1);
                    sodium = fonts.get(39).text();
                    sodium_percent = fonts.get(40).text() + "%";
                    total_car = fonts.get(14).text();
                    total_car_percent = fonts.get(15).text() + "%";
                    fiber = fonts.get(22).text();
                    fiber_percent = fonts.get(23).text() + "%";
                    sugar = fonts.get(29).text();
                    protein = fonts.get(36).text();
                    vit_a = fonts.get(67).text().substring(1);
                    vit_b12 = fonts.get(71).text().substring(1);
                    vit_c = fonts.get(69).text().substring(1);
                    iron = fonts.get(63).text().substring(1);
                    ingredient = page.select("span").get(1).text();
                    allergen = page.select("span").get(3).text();


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return aList;
            }



            @Override
            protected void onPostExecute(ArrayList result) {

//                ListView list = findViewById(R.id.menuItems);
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Nutrition2Activity.this, android.R.layout.simple_list_item_1, result);
//                list.setAdapter(adapter);
                TextView text = (TextView) findViewById(R.id.textView);
                TextView text2 = (TextView) findViewById(R.id.textView2);
                TextView text3 = (TextView) findViewById(R.id.textView3);
                TextView text4 = (TextView) findViewById(R.id.textView4);
                TextView text5 = (TextView) findViewById(R.id.textView5);
                TextView text6 = (TextView) findViewById(R.id.textView6);
                TextView text7 = (TextView) findViewById(R.id.textView7);
                TextView text8 = (TextView) findViewById(R.id.textView8);
                TextView text9 = (TextView) findViewById(R.id.textView9);
                TextView text10 = (TextView) findViewById(R.id.textView10);
                TextView text11 = (TextView) findViewById(R.id.textView11);
                TextView text12 = (TextView) findViewById(R.id.textView12);
                TextView text13 = (TextView) findViewById(R.id.textView13);
                TextView text14 = (TextView) findViewById(R.id.textView14);
                TextView text15 = (TextView) findViewById(R.id.textView15);
                TextView text16 = (TextView) findViewById(R.id.textView16);
                TextView text17 = (TextView) findViewById(R.id.textView17);
                TextView text18 = (TextView) findViewById(R.id.textView18);
                TextView text19 = (TextView) findViewById(R.id.textView19);
                TextView text20 = (TextView) findViewById(R.id.textView20);
                TextView text21 = (TextView) findViewById(R.id.textView21);
                TextView text22 = (TextView) findViewById(R.id.textView22);
                TextView text23 = (TextView) findViewById(R.id.textView23);
                TextView text24 = (TextView) findViewById(R.id.textView24);
                TextView text25 = (TextView) findViewById(R.id.textView25);
                TextView text26 = (TextView) findViewById(R.id.textView26);
                TextView text27 = (TextView) findViewById(R.id.textView27);
                TextView text28 = (TextView) findViewById(R.id.textView28);
                TextView text32 = (TextView) findViewById(R.id.textView32);
                TextView text34 = (TextView) findViewById(R.id.textView34);

//                text.setText(menu);
//                text7.setText(cal + "\t\t\t\t" + cal_fat);
//                text8.setText("Total Fat " + total_fat);
//                text9.setText("\tSaturated Fat " + sat_fat + "\t\t\t\t" + sat_fat_percent);
//                text10.setText("\tTrans Fat" + tran_fat);
//                text11.setText("Cholestoral " + chol + "\t\t\t\t\t" + chol_percent);
//                text12.setText("Sodium " + sodium + "\t\t\t\t\t\t" + sodium_percent);
//                text13.setText("Total Carb. " + total_car + "\t\t\t\t\t\t\t" + total_car_percent);
//                text14.setText("\tDietary Fiber " + fiber + "\t\t\t\t\t" + fiber_percent);
//                text15.setText("\tSugar" + sugar);
//                text16.setText("Protein" + protein);
//                text17.setText("Vitamin A-IU " + vit_a);
//                text18.setText("Vitamin B12 " + vit_b12);
//                text19.setText("Iron " + iron);
//                text20.setText("Vitamin B12 " + vit_b12);
//                text21.setText("INGREDIENTS: "+ ingredient);
//                text22.setText("ALLEGENS: " + allergen);
                text.setText(menu);
                text7.setText("Serving Size " + serving + " ea");
                text3.setText("Calories " + cal);
                text4.setText(cal_fat);
                text8.setText("Total Fat " + total_fat);
                text10.setText("     Saturated Fat " + sat_fat);
                text11.setText(sat_fat_percent);
                text12.setText("Cholesterol " + chol);
                text13.setText(chol_percent);
                text14.setText("     Trans Fat " + tran_fat);
                text15.setText("Sodium " + sodium);
                text16.setText(sodium_percent);
                text17.setText("Total Carbohydrate " + total_car);
                text18.setText(total_car_percent);
                text19.setText("     Dietary Fiber " + fiber);
                text20.setText(fiber_percent);
                text21.setText("     Sugars " + sugar);
                text22.setText("Protien " + protein);
                text23.setText("Vitamin A-IU " + vit_a);
                text24.setText("Vitamin B12 " + vit_b12);
                text25.setText("Vitamin C " + vit_c);
                text26.setText("Iron " + iron);
                text27.setText("Sodium " + sodium);
                text28.setText("Dietaty Fiber " + fiber_percent);
                text32.setText(ingredient);
                text34.setText(allergen);
//                menu,serving,cal,cal_fat,total_fat,sat_fat,sat_fat_percent, tran_fat, chol, chol_percent
//                        ,sodium,sodium_percent, total_car,total_car_percent,fiber,fiber_percent,sugar,protein,vit_a,vit_b12,vit_c
//                        ,iron,ingredient, allergen;

            }
        }.execute();
    }
}