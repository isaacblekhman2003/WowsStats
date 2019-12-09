package com.example.wowsstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TierIXFragment extends Fragment {

    private ArrayAdapter<Ship> shipArrayAdapter;
    private Gson gson;
    private Ship[] ships;
    private List<Ship> shipList;
    private ListView shipView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tier_ix,container,false);

        gson = new Gson();
        InputStream jsonFileInputStream   = getResources().openRawResource(R.raw.shipix);
        String json = readTextFile(jsonFileInputStream);


        ships =  gson.fromJson(json, Ship[].class);

        shipList = Arrays.asList(ships);

        shipArrayAdapter = new ShipAdapter(shipList);
        wirewidgets(rootView);

        shipView.setAdapter(shipArrayAdapter);






        return rootView;
    }

    private void wirewidgets(View rootView) {
        shipView = rootView.findViewById(R.id.listView_tix_shiplist);

    }

    public String readTextFile (InputStream jsonFileInputStream) {
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



    public class ShipAdapter extends ArrayAdapter<Ship>{
        private ImageView imageView;
        private  TextView shipName;


        private List<Ship> shipList;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_ship,parent,false);
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
            this.shipList=heroList;



        }
    }}