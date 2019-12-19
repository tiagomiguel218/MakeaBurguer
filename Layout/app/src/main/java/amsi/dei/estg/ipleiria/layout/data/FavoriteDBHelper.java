package amsi.dei.estg.ipleiria.layout.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

//public class FavoriteDBHelper extends SQLiteOpenHelper {

   /* private static final String DABASE_NAME = "favorite.db";

    private static final int DATABASE_VERSION = 1;

    public static final String LOGTAG = "FAVORITE";


    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;

    public FavoriteDBHelper(Context context) {
        super(context, DABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() {
        Log.i(LOGTAG, "Database Opened");
        db = dbhandler.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }

/*


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        final String SQL_CREATE_FAVORITE_TABLE="CREATE TABLE " + FavoriteContract.FavoriteEntry.TABLE_NAME + "(" +
                FavoriteContract.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID + " INTEGER, " +
                FavoriteContract.FavoriteEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteEntry.COLUMN_PRICE + " INTEGER, " +
                FavoriteContract.FavoriteEntry.COLUMN_IMAGE + " INTEGER " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME);
        onCreate(db);
    }

    public void addFavorite(Produtos produt){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID, produt.getId());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_NAME, produt.getNome());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_PRICE, produt.getPreco());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_IMAGE, produt.getImagem());

        db.insert(FavoriteContract.FavoriteEntry.TABLE_NAME, null, values);
        db.close();

    }

    public void deleteFavorite(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(FavoriteContract.FavoriteEntry.TABLE_NAME, FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID + "=" + id, null);
    }

    public List<Produtos> getAllFavorite(){
        String[] columns={
                FavoriteContract.FavoriteEntry._ID,
                FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID,
                FavoriteContract.FavoriteEntry.COLUMN_NAME,
                FavoriteContract.FavoriteEntry.COLUMN_PRICE,
                FavoriteContract.FavoriteEntry.COLUMN_IMAGE,

        };
        String sortOrder=
                FavoriteContract.FavoriteEntry._ID + " ASC ";
        List<Produtos> favoriteList = new ArrayList<>();

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(FavoriteContract.FavoriteEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if(cursor.moveToFirst()){
            do{
                Produtos produtos = new Produtos();
                produtos.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_PRODUCTID))));
                produtos.setNome(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_NAME)));
                produtos.setPreco(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_PRICE))));
                produtos.setImagem(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_IMAGE))));

                favoriteList.add(produtos);
            }while(cursor.moveToNext());
        }cursor.close();
        db.close();

        return favoriteList;

    }
}*/

