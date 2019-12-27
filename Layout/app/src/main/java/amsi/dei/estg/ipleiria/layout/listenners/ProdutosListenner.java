package amsi.dei.estg.ipleiria.layout.listenners;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public interface ProdutosListenner {
    public void onRefreshListaProdutos(ArrayList<Produtos> listaProdutos);
  //  public void onUpdateListaProdutos(Produtos produtos, int operacao);
}
