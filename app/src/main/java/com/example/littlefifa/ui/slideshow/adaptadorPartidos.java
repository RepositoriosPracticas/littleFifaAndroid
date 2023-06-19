package com.example.littlefifa.ui.slideshow;

import static java.security.AccessController.getContext;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.littlefifa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class adaptadorPartidos{
    ListView lista;
    ArrayAdapter adaptador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public adaptadorPartidos() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Top20.
     */
    // TODO: Rename and change types and number of parameters
    public static adaptadorPartidos newInstance(String param1, String param2) {
        return null;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jornada_layout, container, false);
        Log.e("Pablo", "Estoy en el top 20");


        if(partidos!=null){
                Log.e("Pablo","Voy al adaptador:   \n");
                adaptador = new adaptadorPartidos(getContext(),partidos);
                lista.setAdapter(adaptador);
            }
        return rootView;
    }
}
