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

public class SobremesasFragment extends Fragment implements ProdutosListenner {

    private GridView gridviewSobremesas;
    private GridViewAdaptadorProdutos adaptadorsobremesas;
    private GestorProdutos gestorSobremesas;


    public SobremesasFragment() {
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

        gestorSobremesas = GestorProdutos.getInstance(getContext());
        gestorSobremesas.setProdutosListener(this);
        gestorSobremesas.getAllSobremesasAPI(getContext(), ProdutosJsonParse.isConnectionInternet(getContext()));

        refleshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                adaptadorsobremesas.notifyDataSetChanged();
                refleshLayout.setRefreshing(false);
            }
        });


        refleshLayout.post(new Runnable() {
            @Override
            public void run() {
                refleshLayout.setRefreshing(true);

                gestorSobremesas.getAllSobremesasAPI(getContext(), ProdutosJsonParse.isConnectionInternet(getContext()));

            }
        });



        this.gridviewSobremesas = view.findViewById(R.id.gridViewProdutos);


        this.adaptadorsobremesas = new GridViewAdaptadorProdutos(getContext(), GestorProdutos.getInstance(getContext()).getListaSobremesas());

        this.gridviewSobremesas.setAdapter(adaptadorsobremesas);

        this.gridviewSobremesas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
    public void onRefreshListaProdutos(ArrayList<Produtos> listaSobremesas) {
        adaptadorsobremesas=new GridViewAdaptadorProdutos(getContext(), listaSobremesas);
        gridviewSobremesas.setAdapter(adaptadorsobremesas);
        adaptadorsobremesas.notifyDataSetChanged();
    }

}
