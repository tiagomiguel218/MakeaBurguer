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
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class AdaptadorFavoritos extends BaseAdapter {

    private ArrayList<Produtos> listaHamburguer;

    private Context contexto;
    private LayoutInflater inflater;


    public AdaptadorFavoritos(Context context, ArrayList<Produtos> hamburguer) {
        this.contexto = context;
        this.listaHamburguer = hamburguer;
    }

    @Override
    public int getCount() {
        return listaHamburguer.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaHamburguer.get(position);
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
        holder.update(listaHamburguer.get(position));
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

        public void update(Produtos hamburguer) {
            this.tvNome.setText(hamburguer.getNome());
            this.tvPreco.setText(hamburguer.getPreco() + "");
            this.ivImagem.setImageResource(hamburguer.getImagem());
        }
    }
}

