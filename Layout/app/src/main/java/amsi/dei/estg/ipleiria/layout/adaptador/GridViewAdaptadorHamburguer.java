package amsi.dei.estg.ipleiria.layout.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.Hamburger;

public class GridViewAdaptadorHamburguer extends BaseAdapter {

    private ArrayList<Hamburger> listaHamburger;

    private Context contexto;
    private LayoutInflater inflater;


    public GridViewAdaptadorHamburguer(Context context, ArrayList<Hamburger> hamburger) {
        this.contexto = context;
        this.listaHamburger = hamburger;


    }

    @Override
    public int getCount() {
        return this.listaHamburger.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaHamburger.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) this.contexto.getSystemService(this.contexto.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_grid_hamburguer, null);
        ViewHolderLista holder = (ViewHolderLista) convertView.getTag();
        if (holder == null) {
            holder = new ViewHolderLista(convertView);
            convertView.setTag(holder);
        }
        //holder.update(listaHamburger.get(position));
        return convertView;
    }

    private class ViewHolderLista {
        private TextView tvNome, tvPreco;
        private ImageView ivImagem;

        public ViewHolderLista(View view) {
            this.tvNome = view.findViewById(R.id.tvNome);
            this.tvPreco = view.findViewById(R.id.tvPreco);
            this.ivImagem = view.findViewById(R.id.ivImagem);
        }


    }
}