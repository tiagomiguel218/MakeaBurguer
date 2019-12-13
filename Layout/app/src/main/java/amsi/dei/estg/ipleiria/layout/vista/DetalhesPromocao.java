package amsi.dei.estg.ipleiria.layout.vista;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.GestorPromocao;
import amsi.dei.estg.ipleiria.layout.modelo.Promocao;

public class DetalhesPromocao extends AppCompatActivity {

    private TextView etNomeDetalhe, etPrecoDetalhe;
    private ImageView ivImagemDetalhe;
    private ImageButton imgFavoritos;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);

        Button btAdicionar = findViewById(R.id.bttAdicionarPedidoDetalhes);
        this.ivImagemDetalhe = findViewById(R.id.ivImagemDetalhe);
        this.etNomeDetalhe = findViewById(R.id.etNomeDetalhe);
        this.etPrecoDetalhe = findViewById(R.id.etPrecoDetalhe);

        int indice = getIntent().getIntExtra("indice", -1);

        Promocao promocao = GestorPromocao.getInstance().getPromocao(indice);


        this.ivImagemDetalhe.setImageResource(promocao.getImagem());
        this.etNomeDetalhe.setText(promocao.getNome());
        this.etPrecoDetalhe.setText(promocao.getPreco() + "");


        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdicionarPedido();
            }
        });

    }




    private void AdicionarPedido() {
        Toast.makeText(this, "O produto foi adicionado!", Toast.LENGTH_SHORT).show();

    }


}

