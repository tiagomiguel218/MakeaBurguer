package amsi.dei.estg.ipleiria.layout.modelo;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;

public class GestorPromocao {
    private static GestorPromocao INSTANCIA = null;

    private ArrayList<Promocao> gridViewpromocao;

    public static synchronized GestorPromocao getInstance(){
        if(INSTANCIA == null){
            INSTANCIA = new GestorPromocao();
        }

        return INSTANCIA;
    }

    private GestorPromocao(){
        this.gridViewpromocao = new ArrayList<Promocao>();
        gerarPromocao();
    }

    private void gerarPromocao() {
        this.gridViewpromocao.add(new Promocao(1, "batatas fritas", 10, R.mipmap.burger));
        this.gridViewpromocao.add(new Promocao(2, "batatas doces fritas", 10, R.mipmap.burger2));
        this.gridViewpromocao.add(new Promocao(3, "bolas de queijo", 10, R.mipmap.burger2));
        this.gridViewpromocao.add(new Promocao(4, "batatas de queijo", 10, R.mipmap.burger));
        this.gridViewpromocao.add(new Promocao(5, "batatats", 10, R.mipmap.burger));
        this.gridViewpromocao.add(new Promocao(6, "batataxws", 10, R.mipmap.burger2));

    }

    public ArrayList<Promocao> getListaPromocao(){
        return this.gridViewpromocao;
    }

    public Promocao getPromocao(int indice){
        if(indice >= 0 && indice < this.gridViewpromocao.size()){
            return this.gridViewpromocao.get(indice);
        }
        return null;
    }
}
