package amsi.dei.estg.ipleiria.layout.vista;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.modelo.GestorProdutos;
import amsi.dei.estg.ipleiria.layout.modelo.Hamburger;
import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class DetalhesProdutos extends AppCompatActivity {

    private TextView etNomeDetalhe, etPrecoDetalhe;
    private ImageView ivImagemDetalhe;
    //private FavoriteDBHelper favoriteDBHelper;
    private SQLiteDatabase pdb;
    private Hamburger favorite;
    private final AppCompatActivity activity = DetalhesProdutos.this;
    Hamburger hamburger;

    String nome, imagem;
    int produto_id;
    double preco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);


       //FavoriteDBHelper dbHelper = new FavoriteDBHelper(this);
        //pdb = dbHelper.getWritableDatabase();

        Button btAdicionar = findViewById(R.id.bttAdicionarPedidoDetalhes);

        this.ivImagemDetalhe = findViewById(R.id.ivImagemDetalhe);
        this.etNomeDetalhe = findViewById(R.id.etNomeDetalhe);
        this.etPrecoDetalhe = findViewById(R.id.etPrecoDetalhe);

        int indice = getIntent().getIntExtra("indice", -1);

        Produtos bebidas = GestorProdutos.getInstance(this).getBebidas(indice);
        Produtos complementos = GestorProdutos.getInstance(this).getComplementos(indice);
        Produtos sobremesas = GestorProdutos.getInstance(this).getSobremesas(indice);


      //  this.ivImagemDetalhe.setImageResource(bebidas.getImagem());
        this.etNomeDetalhe.setText(bebidas.getNome());
        this.etPrecoDetalhe.setText(new StringBuilder("€").append((bebidas.getPreco() + "")));



       // this.ivImagemDetalhe.setImageResource(complementos.getImagem());
        this.etNomeDetalhe.setText(complementos.getNome());
        this.etPrecoDetalhe.setText(new StringBuilder("€").append((complementos.getPreco() + "")));


      //  this.ivImagemDetalhe.setImageResource(sobremesas.getImagem());
        this.etNomeDetalhe.setText(sobremesas.getNome());
        this.etPrecoDetalhe.setText(new StringBuilder("€").append((sobremesas.getPreco() + "")));



        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdicionarPedido();
            }
        });

        //favorito

       /* SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
                            int produtos_id=getIntent().getExtras().getInt("id");
                            favoriteDBHelper= new FavoriteDBHelper(DetalhesProdutos.this);
                            favoriteDBHelper.deleteFavorite(produtos_id);
                            SharedPreferences.Editor editor = getSharedPreferences("amsi.dei.estg.ipleiria.layout.vista.DetalhesProdutos", MODE_PRIVATE).edit();
                            editor.putBoolean("Favorite Removed", true);
                            editor.commit();
                            Snackbar.make(buttonView, "Removed from Favorite", Snackbar.LENGTH_SHORT).show();

                        }
                    }
                });
*/

      /*  Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("movies")) {

            hamburger = getIntent().getParcelableExtra("hamburger");

            nome = hamburger.getNome();
            preco = hamburger.getPreco();
            imagem = hamburger.getImagem();
            produto_id = hamburger.getId();
        } else {
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
        }*/

        /*MaterialFavoriteButton materialFavoriteButton = (MaterialFavoriteButton) findViewById(R.id.favorite_button);
        if (Exists(nome)) {
            materialFavoriteButton.setFavorite(true);
            materialFavoriteButton.setOnFavoriteChangeListener(
                    new MaterialFavoriteButton.OnFavoriteChangeListener() {
                        @Override
                        public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                            if (favorite == true) {
                                saveFavorite();
                                Snackbar.make(buttonView, "Added to Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            } else {
                                favoriteDBHelper = new FavoriteDBHelper(DetalhesProdutos.this);
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
                            if (favorite == true) {
                                saveFavorite();
                                Snackbar.make(buttonView, "Added to Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            } else {
                                int movie_id = getIntent().getExtras().getInt("id");
                                favoriteDBHelper = new FavoriteDBHelper(DetalhesProdutos.this);
                                favoriteDBHelper.deleteFavorite(movie_id);
                                Snackbar.make(buttonView, "Removed from Favorite",
                                        Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

        private boolean Exists(String nome){

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
        }



        public void saveFavorite(){
            favoriteDBHelper = new FavoriteDBHelper(activity);
            favorite = new Hamburger();


            favorite.setId(produto_id);
            favorite.setNome(nome);
            favorite.setPreco(preco);
            favorite.setImagem(imagem);

            favoriteDBHelper.addFavorite(favorite);
        }
*/
    }
        private void AdicionarPedido () {
            Toast.makeText(this, "O produto foi adicionado!", Toast.LENGTH_SHORT).show();

            //adicionar no shopping cart

        }


      /*  toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_not_favorito));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isFavourite = readState();

                if (isFavourite = false) {
                    saveState(isFavourite);
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorito));

                }else{
                isFavourite = true;
                saveState(isFavourite);
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_not_favorito));
            }}
        });
    }


private boolean readState(){
    SharedPreferences aSharedPreferences = this.getSharedPreferences("Favourite", Context.MODE_PRIVATE);
    return aSharedPreferences.getBoolean("State", true);
}

    private void saveState(boolean isFavourite){
        SharedPreferences aSharedPreferences = this.getSharedPreferences("Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferencesEdit = aSharedPreferences.edit();
        aSharedPreferencesEdit.putBoolean("State", isFavourite);
        aSharedPreferencesEdit.apply();

    }*/


    }







