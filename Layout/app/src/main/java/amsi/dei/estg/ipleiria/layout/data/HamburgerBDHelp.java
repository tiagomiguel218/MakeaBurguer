package amsi.dei.estg.ipleiria.layout.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class HamburgerBDHelp extends SQLiteOpenHelper {

    private final static String NAMEBD = "HamburgerBD";
    private final static int VERSAO = 1;

    private final SQLiteDatabase bd;


    public HamburgerBDHelp(Context context) {
        super(context, NAMEBD, null, VERSAO);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//criamos as tabelas

        db.execSQL(" CREATE TABLE IF NOT EXISTS Hamburger " +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Nome TEXT NOT NULL, " +
                " Preco INTEGER NOT NULL, " +
                " Imagem INTEGER NOT NULL); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Hamburguer");
        onCreate(db);
    }
    //operaçoes crud sobre a bd

    public Produtos inserirHamburgerBD(Produtos hamburger) {
        ContentValues dados = new ContentValues();
        dados.put("Nome", hamburger.getNome());
        dados.put("Preco", hamburger.getPreco());
        dados.put("Imagem", hamburger.getImagem());

        long id = this.bd.insert("Hamburger", null, dados);
        if (id > -1) {
            hamburger.setId((int) id);
            return hamburger;
        }
        return null;
    }

    public boolean atualizarHamburgerBD(int id, Produtos dadosHamburger) {
        ContentValues dados = new ContentValues();
        dados.put("Nome", dadosHamburger.getNome());
        dados.put("Preco", dadosHamburger.getPreco());
        dados.put("Imagem", dadosHamburger.getImagem());

        return this.bd.update("Hamburger", dados, "id=?", new String[]{"" + id})==1;
    }
    public boolean deleteHamburgerBD(int id){
        return this.bd.delete("Hamburger", "id=?", new String[]{""+id})==1;
    }

    public ArrayList<Produtos> getAllHamburger(){
        ArrayList<Produtos> lista = new ArrayList<Produtos>();
        Cursor cursor = this.bd.query("Hamburger", new String[]{"id", "Nome", "Preco", "Imagem"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            Produtos hamburger= new Produtos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3));
            lista.add(hamburger);
        }
        return lista;

    }
}
