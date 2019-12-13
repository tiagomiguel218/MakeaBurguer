package amsi.dei.estg.ipleiria.layout.modelo;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;

public class GestorProdutos {
    private static GestorProdutos INSTANCIA = null;

    private ArrayList<Produtos> gridViewprodutos;

    public static synchronized GestorProdutos getInstance(){
        if(INSTANCIA == null){
            INSTANCIA = new GestorProdutos();
        }

        return INSTANCIA;
    }

    private GestorProdutos(){
        this.gridViewprodutos = new ArrayList<Produtos>();
        gerarPromocao();
    }

    private void gerarPromocao() {
        this.gridViewprodutos.add(new Produtos(1, "batatas fritas", 10, R.mipmap.burger));
        this.gridViewprodutos.add(new Produtos(2, "batatas doces fritas", 10, R.mipmap.burger2));
        this.gridViewprodutos.add(new Produtos(3, "bolas de queijo", 10, R.mipmap.burger2));
        this.gridViewprodutos.add(new Produtos(4, "batatas de queijo", 10, R.mipmap.burger));
        this.gridViewprodutos.add(new Produtos(5, "batatats", 10, R.mipmap.burger));
        this.gridViewprodutos.add(new Produtos(6, "batataxws", 10, R.mipmap.burger2));

    }

    public ArrayList<Produtos> getListaProdutos(){
        return this.gridViewprodutos;
    }

    public Produtos getProdutos(int indice){
        if(indice >= 0 && indice < this.gridViewprodutos.size()){
            return this.gridViewprodutos.get(indice);
        }
        return null;
    }
}
