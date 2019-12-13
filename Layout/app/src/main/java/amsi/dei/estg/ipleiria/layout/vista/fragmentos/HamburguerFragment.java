package amsi.dei.estg.ipleiria.layout.vista.fragmentos;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.navigation.NavigationView;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorHamburguer;
import amsi.dei.estg.ipleiria.layout.modelo.GestorHamburguer;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesHamburguer;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos;

/**
 * A simple {@link Fragment} subclass.
 */
public class HamburguerFragment extends Fragment {

    private GridView gridviewHamburguer;
    private GridViewAdaptadorHamburguer adaptadorhamburguer;

    public HamburguerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hamburguer, container, false);


        this.gridviewHamburguer = view.findViewById(R.id.gridViewHamburguer);

        this.adaptadorhamburguer = new GridViewAdaptadorHamburguer(getContext(), GestorHamburguer.getInstance().getListaHamburguer());

        this.gridviewHamburguer.setAdapter(adaptadorhamburguer);

        this.gridviewHamburguer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalhes(position);
            }
        });


        return view;
    }

    private void mostraDetalhes(int position) {
        Intent intentDetalhe = new Intent(getContext(), DetalhesHamburguer.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }
}

