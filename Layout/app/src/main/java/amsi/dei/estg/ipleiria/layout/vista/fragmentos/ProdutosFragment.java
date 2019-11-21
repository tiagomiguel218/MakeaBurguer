package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;


import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptador;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;
import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos;

public class ProdutosFragment extends Fragment {

    private GridView gridviewProdutos;
    private GridViewAdaptador adaptador;

    public ProdutosFragment
            () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        this.gridviewProdutos=view.findViewById(R.id.gridViewProdutos);

        //ArrayAdapter<Livro> adaptador=new ArrayAdapter<Livro>(getContext(), android.R.layout.simple_list_item_1, SingletonGestorLivros.getInstance().getListaLivros());

        this.adaptador=new GridViewAdaptador(getContext(), GestorProdutos.getInstance().getListaProdutos());

        this.gridviewProdutos.setAdapter(adaptador);

        this.gridviewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalhes(position);
            }
        });
        return view;
    }

    private void mostraDetalhes(int position) {
        Intent intentDetalhe=new Intent(getContext(), DetalhesProdutos.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }
}