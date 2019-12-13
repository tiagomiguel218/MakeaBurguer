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
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorPromocao;
import amsi.dei.estg.ipleiria.layout.modelo.GestorPromocao;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesPromocao;

public class PromocoesFragment extends Fragment {



    public PromocoesFragment() {
        // Required empty public constructor
    }
    private GridView gridviewPromocao;
    private GridViewAdaptadorPromocao adaptadorPromocao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_promocoes, container, false);



        this.gridviewPromocao=view.findViewById(R.id.gridViewPromocoes);


        this.adaptadorPromocao=new GridViewAdaptadorPromocao(getContext(), GestorPromocao.getInstance().getListaPromocao());

        this.gridviewPromocao.setAdapter(adaptadorPromocao);

        this.gridviewPromocao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalhes(position);
            }
        });

        return view;
    }
    private void mostraDetalhes(int position) {
        Intent intentDetalhe=new Intent(getContext(), DetalhesPromocao.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }
}