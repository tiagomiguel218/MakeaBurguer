package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorProdutos;
import amsi.dei.estg.ipleiria.layout.modelo.Hamburger;

public class FavoritoFragment extends Fragment {

    private GridView gridViewFavoritos;
    //private static FavoriteDBHelper favoriteDBHelper;
    private static ArrayList<Hamburger> hamburgerList;
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

        hamburgerList = new ArrayList<>();
       // adaptadorProdutos = new GridViewAdaptadorProdutos(getContext(), hamburgerList);

        //adaptadorProdutos.notifyDataSetChanged();
       // favoriteDBHelper = new FavoriteDBHelper(getContext());

     //   getAllFavorite();


        return view;
    }


  /*  private void getAllFavorite(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params){
                hamburgerList.clear();
                hamburgerList.addAll(favoriteDBHelper.getAllFavorite());
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