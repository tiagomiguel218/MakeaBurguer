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
import amsi.dei.estg.ipleiria.layout.modelo.Promocao;

public class GridViewAdaptadorPromocao extends BaseAdapter {
    private ArrayList<Promocao> listaPromocao;
    private Context contexto;
    private LayoutInflater inflater;


    public GridViewAdaptadorPromocao(Context context, ArrayList<Promocao> promocao) {
        this.contexto = context;
        this.listaPromocao = promocao;
    }

    @Override
    public int getCount() {
        return this.listaPromocao.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaPromocao.get(position);
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
            convertView = inflater.inflate(R.layout.item_grid_promocao, null);
        ViewHolderListaPromocao holder = (ViewHolderListaPromocao) convertView.getTag();
        if (holder == null) {
            holder = new ViewHolderListaPromocao(convertView);
            convertView.setTag(holder);
        }
        holder.update(listaPromocao.get(position));
        return convertView;
    }

    private class ViewHolderListaPromocao {
        private TextView tvNome, tvPreco;
        private ImageView ivImagem;

        public ViewHolderListaPromocao(View view) {
            this.tvNome = view.findViewById(R.id.tvNome);
            this.tvPreco = view.findViewById(R.id.tvPreco);
            this.ivImagem = view.findViewById(R.id.ivImagem);
        }

        public void update(Promocao promocao) {
            this.tvNome.setText(promocao.getNome());
            this.tvPreco.setText(promocao.getPreco() + "");
            this.ivImagem.setImageResource(promocao.getImagem());
        }
    }
}
