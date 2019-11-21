package amsi.dei.estg.ipleiria.layout.modelo;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;

public class GestorProdutos {
    private static GestorProdutos INSTANCIA = null;

    private ArrayList<Produtos> gridViewProdutos;

    public static synchronized GestorProdutos getInstance(){
        if(INSTANCIA == null){
            INSTANCIA = new GestorProdutos();
        }

        return INSTANCIA;
    }

    private GestorProdutos(){
        this.gridViewProdutos = new ArrayList<Produtos>();
        gerarFakeData();
    }

    private void gerarFakeData() {
        this.gridViewProdutos.add(new Produtos(1, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(2, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(3, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(4, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(5, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(6, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(7, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(8, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(9, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(10, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(11, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(12, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(13, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(14, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(15, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(16, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(17, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(18, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(19, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(20, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(21, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(22, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(23, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(24, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(25, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(26, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(27, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(28, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(29, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(30, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(31, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(32, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(33, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(34, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(35, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(36, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(37, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(38, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(39, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(40, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(41, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewProdutos.add(new Produtos(42, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
    }

    public ArrayList<Produtos> getListaProdutos(){
        return this.gridViewProdutos;
    }

    public Produtos getProdutos(int indice){
        if(indice >= 0 && indice < this.gridViewProdutos.size()){
            return this.gridViewProdutos.get(indice);
        }
        return null;
    }
}