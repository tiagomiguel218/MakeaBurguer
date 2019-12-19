package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorProdutos;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class FavoritoFragment extends Fragment {

    private GridView gridViewFavoritos;
    //private static FavoriteDBHelper favoriteDBHelper;
    private static ArrayList<Produtos> produtosList;
    private GridViewAdaptadorProdutos adaptadorProdutos;



    public FavoritoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        //favoriteDBHelper=new FavoriteDBHelper(getContext());


        gridViewFavoritos = (GridView) view.findViewById(R.id.GridViewFavoritos);

        produtosList = new ArrayList<>();
        adaptadorProdutos = new GridViewAdaptadorProdutos(getContext(), produtosList);

        adaptadorProdutos.notifyDataSetChanged();
       // favoriteDBHelper = new FavoriteDBHelper(getContext());

     //   getAllFavorite();


        return view;
    }


  /*  private void getAllFavorite(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params){
                produtosList.clear();
                produtosList.addAll(favoriteDBHelper.getAllFavorite());
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                adaptadorProdutos.notifyDataSetChanged();
            }
        }.execute();
    }
    */





}