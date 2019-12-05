package com.example.wowsstats;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TierXFragment extends Fragment {

    private ArrayAdapter<Ship> shipArrayAdapter;
    private Gson gson;
    private Ship[] ships;
    private List<Ship> shiplist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tier_x,container,false);
        gson = new Gson();
        InputStream jsonFileInputStream   = getResources().openRawResource(R.raw.shipsX);
        String json = readTextFile(jsonFileInputStream);

        ships =  gson.fromJson(json, Ship[].class);

        shiplist = Arrays.asList(ships);

        shipArrayAdapter = new HeroAdapter(heroList);
        wirewidgets();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        heroview.setAdapter(heroesArrayAdapter);




















        return rootView;
    }
}
