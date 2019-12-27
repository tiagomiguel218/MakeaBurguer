package amsi.dei.estg.ipleiria.layout.vista.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.adaptador.GridViewAdaptadorProdutos;
import amsi.dei.estg.ipleiria.layout.listenners.ProdutosListenner;
import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;
import amsi.dei.estg.ipleiria.layout.utils.ProdutosJsonParse;
import amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos;

public class ComplementosFragment extends Fragment implements ProdutosListenner {


    private GridView gridviewComplementos;
    private GridViewAdaptadorProdutos adaptadorcomplementos;
    private GestorProdutos gestorComplementos;


    public ComplementosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        final SwipeRefreshLayout refleshLayout;

        refleshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        refleshLayout.setColorSchemeResources(R.color.color1, R.color.color2, R.color.color3);

        gestorComplementos = GestorProdutos.getInstance(getContext());
        gestorComplementos.setProdutosListener(this);
        gestorComplementos.getAllComplementosAPI(getContext(), ProdutosJsonParse.isConnectionInternet(getContext()));

        refleshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                adaptadorcomplementos.notifyDataSetChanged();
                refleshLayout.setRefreshing(false);
            }
        });


        refleshLayout.post(new Runnable() {
            @Override
            public void run() {
                refleshLayout.setRefreshing(true);

                gestorComplementos.getAllComplementosAPI(getContext(), ProdutosJsonParse.isConnectionInternet(getContext()));

            }
        });



        this.gridviewComplementos = view.findViewById(R.id.gridViewProdutos);


        this.adaptadorcomplementos = new GridViewAdaptadorProdutos(getContext(), GestorProdutos.getInstance(getContext()).getListaComplementos());

        this.gridviewComplementos.setAdapter(adaptadorcomplementos);

        this.gridviewComplementos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostraDetalheProdutos(position);
            }
        });
        return view;
    }




    private void mostraDetalheProdutos(int position) {
        Intent intentDetalhe=new Intent(getContext(), DetalhesProdutos.class);
        intentDetalhe.putExtra("indice", position);
        startActivity(intentDetalhe);
    }


    @Override
    public void onRefreshListaProdutos(ArrayList<Produtos> listaComplementos) {
        adaptadorcomplementos=new GridViewAdaptadorProdutos(getContext(), listaComplementos);
        gridviewComplementos.setAdapter(adaptadorcomplementos);
        adaptadorcomplementos.notifyDataSetChanged();
    }

}
