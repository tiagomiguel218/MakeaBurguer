package amsi.dei.estg.ipleiria.layout.vista.fragmentos;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorHamburguer;
import amsi.dei.estg.ipleiria.layout.listenners.HamburgerListenner;
import amsi.dei.estg.ipleiria.layout.modelo.GestorHamburguer;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;
import amsi.dei.estg.ipleiria.layout.utils.HamburgerJsonParse;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesHamburguer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HamburguerFragment extends Fragment implements HamburgerListenner {

    private GridView gridviewHamburguer;
    private GridViewAdaptadorHamburguer adaptadorhamburguer;
    private GestorHamburguer gestorHamburger;


    public HamburguerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hamburguer, container, false);

        final SwipeRefreshLayout refleshLayout;

        refleshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        refleshLayout.setColorSchemeResources(R.color.color1, R.color.color2, R.color.color3);

        gestorHamburger = GestorHamburguer.getInstance(getContext());
        gestorHamburger.setHamburgerListener(this);
        gestorHamburger.getAllHamburgerAPI(getContext(), HamburgerJsonParse.isConnectionInternet(getContext()));

        refleshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                adaptadorhamburguer.notifyDataSetChanged();
                refleshLayout.setRefreshing(false);
            }
        });


            refleshLayout.post(new Runnable() {
                @Override
                public void run() {
                    refleshLayout.setRefreshing(true);

                    gestorHamburger.getAllHamburgerAPI(getContext(), HamburgerJsonParse.isConnectionInternet(getContext()));

                }
            });



            this.gridviewHamburguer = view.findViewById(R.id.gridViewHamburguer);


            this.adaptadorhamburguer = new GridViewAdaptadorHamburguer(getContext(), GestorHamburguer.getInstance(getContext()).getListaHamburguer());

            this.gridviewHamburguer.setAdapter(adaptadorhamburguer);

            this.gridviewHamburguer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mostraDetalheHamburger(position);
                }
            });
            return view;
        }




    private void mostraDetalheHamburger(int position) {
        Intent intentDetalhe=new Intent(getContext(), DetalhesHamburguer.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }


    @Override
    public void onRefreshListaHamburger(ArrayList<Produtos> listaHamburger) {
        adaptadorhamburguer=new GridViewAdaptadorHamburguer(getContext(), listaHamburger);
        gridviewHamburguer.setAdapter(adaptadorhamburguer);
        adaptadorhamburguer.notifyDataSetChanged();
    }

    @Override
    public void onUpdateListaHamburger(Produtos hamburger, int operacao) {

    }
}

