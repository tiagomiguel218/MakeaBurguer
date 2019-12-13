package amsi.dei.estg.ipleiria.layout.modelo;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;

public class GestorHamburguer {
    private static GestorHamburguer INSTANCIA = null;

    private ArrayList<Produtos> gridViewHamburguer;

    public static synchronized GestorHamburguer getInstance(){
        if(INSTANCIA == null){
            INSTANCIA = new GestorHamburguer();
        }

        return INSTANCIA;
    }

    private GestorHamburguer(){
        this.gridViewHamburguer = new ArrayList<Produtos>();
        gerarHamburguer();
    }

    private void gerarHamburguer() {
        this.gridViewHamburguer.add(new Produtos(1, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(2, "Hamburguer Duplo Carne", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(3, "Hamburguer Duplo Completo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(4, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(5, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(6, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(7, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(8, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(9, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(10, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(11, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(12, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(13, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));

    }

    public ArrayList<Produtos> getListaHamburguer(){
        return this.gridViewHamburguer;
    }

    public Produtos getProdutos(int indice){
        if(indice >= 0 && indice < this.gridViewHamburguer.size()){
            return this.gridViewHamburguer.get(indice);
        }
        return null;
    }
}