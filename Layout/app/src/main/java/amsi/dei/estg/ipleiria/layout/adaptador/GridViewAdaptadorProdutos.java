package amsi.dei.estg.ipleiria.layout.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class GridViewAdaptadorProdutos extends BaseAdapter {

    private List<Produtos> listaProdutos;

    private Context contexto;
    private LayoutInflater inflater;


    public GridViewAdaptadorProdutos(Context context, ArrayList<Produtos> produtos ){
        this.contexto=context;
        this.listaProdutos=produtos;


    }

    @Override
    public int getCount() {
        return this.listaProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater ==null)
            inflater=(LayoutInflater) this.contexto.getSystemService(this.contexto.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
            convertView = inflater.inflate(R.layout.item_grid_produtos, null);
        ViewHolderLista holder=(ViewHolderLista) convertView.getTag();
        if(holder==null){
            holder=new ViewHolderLista(convertView);
            convertView.setTag(holder);
        }
        holder.update(listaProdutos.get(position));
        return convertView;
    }

    private class ViewHolderLista{
        private TextView tvNome, tvPreco;
        private ImageView ivImagem;

        public ViewHolderLista(View view){
            this.tvNome=view.findViewById(R.id.tvNome);
            this.tvPreco=view.findViewById(R.id.tvPreco);
            this.ivImagem=view.findViewById(R.id.ivImagem);
        }

        public void update(Produtos produtos){
            this.tvNome.setText(produtos.getNome());
            this.tvPreco.setText(produtos.getPreco()+"");
            this.ivImagem.setImageResource(produtos.getImagem());
        }
    }
}