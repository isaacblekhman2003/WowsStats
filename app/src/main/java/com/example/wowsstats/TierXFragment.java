package com.example.wowsstats;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TierXFragment extends Fragment {

    private ShipAdapter shipArrayAdapter;
    private Gson gson;
    private Ship[] ships;
    private List<Ship> shipList;
    private ListView shipView;

    public static final String EXTRA_SHIP = "ship";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tier_x, container, false);

        gson = new Gson();
        InputStream jsonFileInputStream = getResources().openRawResource(R.raw.shipsx);
        String json = readTextFile(jsonFileInputStream);


        ships = gson.fromJson(json, Ship[].class);

        shipList = Arrays.asList(ships);

        shipArrayAdapter = new ShipAdapter(shipList);
        wirewidgets(rootView);

        shipView.setAdapter(shipArrayAdapter);

        setListeners();

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_shipdd_sort:
                List<Ship> sort;
                sort = new ArrayList<>();
                for (int i = 0; i < ships.length; i++) {
                    if (ships[i].getType().equals("Destroyer")) {
                        sort.add(ships[i]);
                    }
                }

                shipArrayAdapter = new ShipAdapter(sort);
                shipView.setAdapter(shipArrayAdapter);
                shipArrayAdapter.notifyDataSetChanged();

                return true;
            case R.id.action_shipca_sort: {

                    List<Ship> sortca;
                    sortca = new ArrayList<>();
                    for (int i = 0; i < ships.length; i++) {
                        if (ships[i].getType().equals("Cruiser")) {
                            sortca.add(ships[i]);
                        }
                    }

                    shipArrayAdapter = new ShipAdapter(sortca);
                    shipView.setAdapter(shipArrayAdapter);
                    shipArrayAdapter.notifyDataSetChanged();


                return true;
            }
            case R.id.action_shipbb_sort: {

                List<Ship> sortbb;
                sortbb = new ArrayList<>();
                for (int i = 0; i < ships.length; i++) {
                    if (ships[i].getType().equals("Battleship")) {
                        sortbb.add(ships[i]);
                    }
                }

                shipArrayAdapter = new ShipAdapter(sortbb);
                shipView.setAdapter(shipArrayAdapter);
                shipArrayAdapter.notifyDataSetChanged();


            }

            default:
                return super.onOptionsItemSelected(item);}



    }

    private void wirewidgets(View rootView) {
        shipView = rootView.findViewById(R.id.ListView_tXfrag_shipList);

    }

    public String readTextFile(InputStream jsonFileInputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = jsonFileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            jsonFileInputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }


    private class ShipAdapter extends ArrayAdapter<Ship> {
        private ImageView imageView;
        private TextView shipName;


        private List<Ship> shipList;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_ship, parent, false);
            }
            imageView = convertView.findViewById(R.id.imageView_itemship_shipimage);
            shipName = convertView.findViewById(R.id.textView_itemship_name);


            int resourceImage = getResources().getIdentifier(shipList.get(position).getName().toLowerCase(), "drawable", getActivity().getPackageName());
            imageView.setImageDrawable(getActivity().getResources().getDrawable(resourceImage));

            shipName.setText(shipList.get(position).getName() + "");

            return convertView;


        }


        public ShipAdapter(List<Ship> heroList) {
            super(getActivity(), -1, heroList);
            this.shipList = heroList;


        }
    }


    public void setListeners()
    {
        shipView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {

                Ship ship = shipList.get(position);

                Intent targetIntent = new Intent(getContext(), DetailActivity.class);

                targetIntent.putExtra(EXTRA_SHIP, ship);


                startActivity(targetIntent);

            }
        });
    }


}
