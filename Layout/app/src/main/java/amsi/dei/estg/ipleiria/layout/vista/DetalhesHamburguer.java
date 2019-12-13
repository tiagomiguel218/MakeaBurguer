package amsi.dei.estg.ipleiria.layout.vista;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.snackbar.Snackbar;

import amsi.dei.estg.ipleiria.layout.R;

import amsi.dei.estg.ipleiria.layout.data.FavoriteContract;
import amsi.dei.estg.ipleiria.layout.data.FavoriteDBHelper;
import amsi.dei.estg.ipleiria.layout.modelo.GestorHamburguer;
import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class DetalhesHamburguer extends AppCompatActivity {

    private TextView etNomeDetalhe, etPrecoDetalhe;
    private ImageView ivImagemDetalhe;
    private FavoriteDBHelper favoriteDBHelper;
    private SQLiteDatabase pdb;
    private Produtos favorite;
    private final AppCompatActivity activity = DetalhesHamburguer.this;
    Produtos produtos;
    String nome;
    int preco, imagem, produto_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);


        FavoriteDBHelper dbHelper = new FavoriteDBHelper(this);
        pdb = dbHelper.getWritableDatabase();

        Button btAdicionar = findViewById(R.id.bttAdicionarPedidoDetalhes);

        this.ivImagemDetalhe = findViewById(R.id.ivImagemDetalhe);
        this.etNomeDetalhe = findViewById(R.id.etNomeDetalhe);
        this.etPrecoDetalhe = findViewById(R.id.etPrecoDetalhe);

        int indice = getIntent().getIntExtra("indice", -1);

        Produtos produto = GestorProdutos.getInstance().getProdutos(indice);


        this.ivImagemDetalhe.setImageResource(produto.getImagem());
        this.etNomeDetalhe.setText(produto.getNome());
        this.etPrecoDetalhe.setText(produto.getPreco() + "");


        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdicionarPedido();
            }
        });

        //favorito

      /*  SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        MaterialFavoriteButton materialFavoriteButton = findViewById(R.id.favorite_button);
        materialFavoriteButton.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                if (favorite) {
                    SharedPreferences.Editor editor = getSharedPreferences("amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos", MODE_PRIVATE).edit();
                    editor.putBoolean("Favorite Added", true);
                    editor.commit();
                    saveFavorite();
                    Snackbar.make(buttonView, "Added to Favorite", Snackbar.LENGTH_SHORT).show();
                } else {
                    int produtos_id = getIntent().getExtras().getInt("id");
                    favoriteDBHelper = new FavoriteDBHelper(DetalhesHamburguer.this);
                    favoriteDBHelper.deleteFavorite(produtos_id);
                    SharedPreferences.Editor editor = getSharedPreferences("amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos", MODE_PRIVATE).edit();
                    editor.putBoolean("Favorite Removed", true);
                    editor.commit();
                    Snackbar.make(buttonView, "Removed from Favorite", Snackbar.LENGTH_SHORT).show();

                }
            }
        });
    }*/
        /*Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("movies")) {

            produtos = getIntent().getParcelableExtra("produtos");

            nome = produtos.getNome();
            preco = produtos.getPreco();
            imagem = produtos.getImagem();
            produto_id = produtos.getId();
        } else {
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
        }*/

      /*  MaterialFavoriteButton materialFavoriteButton = findViewById(R.id.favorite_button);
        if (exists(nome)) {
            materialFavoriteButton.setFavorite(true);
            materialFavoriteButton.setOnFavoriteChangeListener(
                    new MaterialFavoriteButton.OnFavoriteChangeListener() {
                        @Override
                        public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                            if (favorite) {
                                saveFavorite();
                                Snackbar.make(buttonView, "Added to Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            } else {
                                favoriteDBHelper = new FavoriteDBHelper(DetalhesHamburguer.this);
                                favoriteDBHelper.deleteFavorite(produto_id);
                                Snackbar.make(buttonView, "Removed from Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            materialFavoriteButton.setOnFavoriteChangeListener(
                    new MaterialFavoriteButton.OnFavoriteChangeListener() {
                        @Override
                        public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                            if (favorite) {
                                saveFavorite();
                                Snackbar.make(buttonView, "Added to Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            } else {
                                int movie_id = getIntent().getExtras().getInt("id");
                                favoriteDBHelper = new FavoriteDBHelper(DetalhesHamburguer.this);
                                favoriteDBHelper.deleteFavorite(movie_id);
                                Snackbar.make(buttonView, "Removed from Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private boolean exists(String nome) {

        String[] projection = {
                FavoriteContract.FavoriteEntry._ID,
                FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID,
                FavoriteContract.FavoriteEntry.COLUMN_NAME,
                FavoriteContract.FavoriteEntry.COLUMN_PRICE,
                FavoriteContract.FavoriteEntry.COLUMN_IMAGE,

        };
        String selection = FavoriteContract.FavoriteEntry.COLUMN_NAME + " =?";
        String[] selectionArgs = {nome};
        String limit = "1";

        Cursor cursor = pdb.query(FavoriteContract.FavoriteEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }*/
    }

     /*   public void saveFavorite () {
            favoriteDBHelper = new FavoriteDBHelper(activity);
            favorite = new Produtos();


            favorite.setId(produto_id);
            favorite.setNome(nome);
            favorite.setPreco(preco);
            favorite.setImagem(imagem);

            favoriteDBHelper.addFavorite(favorite);
        }
*/
    private void AdicionarPedido() {
        Toast.makeText(this, "O produto foi adicionado!", Toast.LENGTH_SHORT).show();

    }

}




