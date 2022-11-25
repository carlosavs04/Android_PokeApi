package com.example.pokmon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pokmon.Adaptadores.PokemonAdaptador;
import com.example.pokmon.Modelos.Pokemon;
import com.example.pokmon.Modelos.Results;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<Pokemon> p;
    List<Results> r;
    PokemonAdaptador adPokemon;
    RecyclerView recycler;
    private RequestQueue nQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nQueue = SingletonRequest.getInstance(MainActivity.this).getRequestQueue();

        p = new ArrayList<>();
        r = new ArrayList<>();

        getPokemon();
    }

    private void getPokemon() {
        String url="https://pokeapi.co/api/v2/pokemon/?limit=1126&offset=0";

        final JsonObjectRequest pedirPokemon = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("respuesta", response.toString());

                recycler = (RecyclerView) findViewById(R.id.recycler);
                recycler.setHasFixedSize(true);
                LinearLayoutManager linearManager = new LinearLayoutManager(getApplicationContext());
                recycler.setLayoutManager(linearManager);

                final Gson gson = new Gson();
                final Pokemon pokemon = gson.fromJson(response.toString(), Pokemon.class);
                adPokemon = new PokemonAdaptador(pokemon.getResults());
                recycler.setAdapter(adPokemon);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("errorPeticion", error.toString());
            }
        });

        nQueue.add(pedirPokemon);
    }

    @Override
    public void onClick(View view) {

    }
}