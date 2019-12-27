package amsi.dei.estg.ipleiria.layout.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


import amsi.dei.estg.ipleiria.layout.modelo.Produtos;






public class ProdutosBDHelp extends SQLiteOpenHelper {

    private final static String NAMEBD = "ProdutosBD";
    private final static int VERSAO = 1;

    private final SQLiteDatabase bd;


    public ProdutosBDHelp(Context context) {
        super(context, NAMEBD, null, VERSAO);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//criamos as tabelas

        db.execSQL(" CREATE TABLE IF NOT EXISTS Produtos " +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Nome TEXT NOT NULL, " +
                " Preco DOUBLE NOT NULL, " +
                " Imagem TEXT NOT NULL, " +
                " Categoria INTEGER NOT NULL); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Produtos");
        onCreate(db);
    }
    //operaçoes crud sobre a bd

 /*   public Produtos inserirProdutosBD(Produtos produtos) {
        ContentValues dados = new ContentValues();
        dados.put("Nome", produtos.getNome());
        dados.put("Preco", produtos.getPreco());
        dados.put("Imagem", produtos.getImagem());

        long id = this.bd.insert("Produtos", null, dados);
        if (id > -1) {
            produtos.setId((int) id);
            return produtos;
        }
        return null;
    }

    public boolean atualizarProdutosBD(int id, Produtos dadosProdutos) {
        ContentValues dados = new ContentValues();
        dados.put("Nome", dadosProdutos.getNome());
        dados.put("Preco", dadosProdutos.getPreco());
        dados.put("Imagem", dadosProdutos.getImagem());
        dados.put("Categoria", dadosProdutos.getCategoria());

        return this.bd.update("Produtos", dados, "id=?", new String[]{"" + id})==1;
    }



    public boolean deleteProdutosBD(int id){
        return this.bd.delete("Produtos", "id=?", new String[]{""+id})==1;
    }
*/

   /* public ArrayList<Produtos> getAllProdutos(){
        ArrayList<Produtos> lista = new ArrayList<Produtos>();
        Cursor cursor = this.bd.query("Produtos", new String[]{"id", "Nome", "Preco", "Imagem", "Categoria"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            Produtos produtos= new Produtos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getString(3),
                    cursor.getInt(4));
            lista.add(produtos);
        }
        return lista;

    }
*/

    public ArrayList<Produtos> getAllBebidas(){
        ArrayList<Produtos> lista = new ArrayList<Produtos>();

        Cursor cursor = this.bd.query("Produtos", new String[]{"id", "Nome", "Preco", "Imagem", "Categoria"},

               "where Categoria = 7", null , null,null , "ASC");

        while(cursor.moveToNext()){
            Produtos produtos= new Produtos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getString(3),
                    cursor.getInt(4));
            lista.add(produtos);
        }
        return lista;

    }

    public ArrayList<Produtos> getAllSobremesas(){
        ArrayList<Produtos> lista = new ArrayList<Produtos>();

        Cursor cursor = this.bd.query("Produtos", new String[]{"id", "Nome", "Preco", "Imagem", "Categoria"},

                "where Categoria = 8", null , null,null , "ASC");

        while(cursor.moveToNext()){
            Produtos produtos= new Produtos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getString(3),
                    cursor.getInt(4));
            lista.add(produtos);
        }
        return lista;

    }

    public ArrayList<Produtos> getAllComplementos(){
        ArrayList<Produtos> lista = new ArrayList<Produtos>();

        Cursor cursor = this.bd.query("Produtos", new String[]{"id", "Nome", "Preco", "Imagem", "Categoria"},

                "where Categoria = 9", null , null,null , "ASC");

        while(cursor.moveToNext()){
            Produtos produtos= new Produtos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getString(3),
                    cursor.getInt(4));
            lista.add(produtos);
        }
        return lista;

    }
}
