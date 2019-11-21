package amsi.dei.estg.ipleiria.layout.vista;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;
import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;

public class DetalhesProdutos extends AppCompatActivity {

    private TextView etNomeDetalhe, etPrecoDetalhe;
    private ImageView ivImagemDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);

        this.ivImagemDetalhe=findViewById(R.id.ivImagemDetalhe);
        this.etNomeDetalhe = findViewById(R.id.etNomeDetalhe);
        this.etPrecoDetalhe = findViewById(R.id.etPrecoDetalhe);
        int indice = getIntent().getIntExtra("indice", -1);
        Produtos produto = GestorProdutos.getInstance().getProdutos(indice);

        this.ivImagemDetalhe.setImageResource(produto.getImagem());
        this.etNomeDetalhe.setText(produto.getNome());
        this.etPrecoDetalhe.setText(produto.getPreco()+"");
    }
}