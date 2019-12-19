package amsi.dei.estg.ipleiria.layout.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.modelo.Produtos;

public class HamburgerJsonParse {

    public static ArrayList<Produtos> parseJsonHamburger(JSONArray resposta, Context contexto){
        ArrayList<Produtos> lista= new ArrayList<Produtos>();
        try {
            for(int i =0; i<resposta.length(); i++){

                JSONObject hamburgerapi = (JSONObject)resposta.get(i);

                Produtos livro=new Produtos(hamburgerapi.getInt("id"),
                        hamburgerapi.getString("Nome"),
                        hamburgerapi.getInt("Preco"),
                        hamburgerapi.getInt("Imagem"));

                lista.add(livro);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(contexto, "ERRO:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return lista;

    }

    public static Produtos parserJsonHamburger(JSONObject resposta, Context contexto){
        Produtos hamburger = null;
        try {
            hamburger =new Produtos(resposta.getInt("id"),
                    resposta.getString("Nome"),
                    resposta.getInt("Preco"),
                    resposta.getInt("Imagem"));
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(contexto, "ERRO:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return hamburger;
    }
    //1.5.3 para limpar os dados da tabela
    public static boolean isConnectionInternet(Context contexto){
        ConnectivityManager cm= (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= cm.getActiveNetworkInfo();

        return networkInfo != null&&networkInfo.isConnected();
    }
}
