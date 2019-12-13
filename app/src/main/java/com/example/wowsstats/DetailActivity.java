package com.example.wowsstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
{
    private ImageView image;
    private TextView nation;
    private TextView name;
    private TextView tier;
    private TextView type;
    private TextView hp;
    private TextView gun;
    private TextView speed;
    private TextView concealment;
    private TextView torpedo;
    private String link;
    public static final String EXTRA_URL = "url";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        wireWidgets();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent lastIntent = getIntent();

        Ship ship = lastIntent.getParcelableExtra("ship");

        int resourceImage = getResources().getIdentifier(ship.getName().toLowerCase(), "drawable", getPackageName());
        image.setImageDrawable(getResources().getDrawable(resourceImage));

        nation.setText(ship.getNation());
        tier.setText(ship.getTier());
        type.setText(ship.getType());
        hp.setText("Hp: " + ship.getHp());
        gun.setText("Guns: " + ship.getGun());
        speed.setText("Speed: " +ship.getSpeed());
        concealment.setText("Concealment: " + ship.getConcealment());
        torpedo.setText("Torpedo: " + ship.getTorpedo());
        link = ship.getUrl();
        setlisteners();




    }

    private void setlisteners() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent targetIntent = new Intent(getApplicationContext(), WebActivity.class);

                targetIntent.putExtra(EXTRA_URL, link);

                startActivity(targetIntent);



            }
        });
    {



        }
    }


    public void wireWidgets()
    {
        image = findViewById(R.id.imageView_image_detail);
        nation = findViewById(R.id.textView_name_detail);
        tier = findViewById(R.id.textView_tier_detail);
        type = findViewById(R.id.textView_type_detail);
        hp = findViewById(R.id.textView_hp_detail);
        gun = findViewById(R.id.textView_gun_detail);
        speed = findViewById(R.id.textView_speed_detail);
        concealment = findViewById(R.id.textView_concealment_detail);
        torpedo = findViewById(R.id.textView_torpedo_detail);


    }
}
