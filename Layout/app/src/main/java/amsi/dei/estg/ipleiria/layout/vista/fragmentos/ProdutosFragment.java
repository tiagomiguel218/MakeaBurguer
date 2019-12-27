package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import amsi.dei.estg.ipleiria.layout.R;

import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;

import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorProdutos;

import amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos;

public class ProdutosFragment extends Fragment {

    private GridViewAdaptadorProdutos adaptadorprodutos;
    private GridView gridviewProdutos;


    public ProdutosFragment
            () {
        // Required empty public constructor
    }
    //produtos nao precisa de fragmento
    //é preciso fazer os fragmentos das bebidas, acompanhamentos e sobremesas


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_produtos, container, false);



        this.gridviewProdutos = view.findViewById(R.id.gridViewProdutos);

        //GridView primeiro hamburguer

        //adaptadorprodutos = new GridViewAdaptadorProdutos(getContext(), GestorProdutos.getInstance().getListaProdutos());
        this.gridviewProdutos.setAdapter(adaptadorprodutos);
        this.gridviewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalhes(position);
            }
        });



        return view;
    }


    private void mostraDetalhes(int position) {
        Intent intentDetalhe = new Intent(getContext(), DetalhesProdutos.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }

}
