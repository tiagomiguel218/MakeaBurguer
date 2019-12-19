package amsi.dei.estg.ipleiria.layout.listenners;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public interface HamburgerListenner {
    public void onRefreshListaHamburger(ArrayList<Produtos> listaHamburger);
    public void onUpdateListaHamburger(Produtos hamburger, int operacao);
}
