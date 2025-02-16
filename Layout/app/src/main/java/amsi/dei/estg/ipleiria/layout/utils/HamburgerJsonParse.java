package amsi.dei.estg.ipleiria.layout.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.layout.modelo.Hamburger;

public class HamburgerJsonParse {

    public static ArrayList<Hamburger> parseJsonHamburger(JSONArray resposta, Context contexto){
        ArrayList<Hamburger> lista= new ArrayList<Hamburger>();
        try {
            for(int i =0; i<resposta.length(); i++){

                JSONObject hamburgerapi = (JSONObject)resposta.get(i);

                Hamburger livro=new Hamburger(hamburgerapi.getInt("id"),
                        hamburgerapi.getString("nome"),
                        hamburgerapi.getDouble("preco"),
                        hamburgerapi.getString("imagem"));

                lista.add(livro);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(contexto, "ERRO:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return lista;

    }

    public static Hamburger parserJsonHamburger(JSONObject resposta, Context contexto){
        Hamburger hamburger = null;
        try {
            hamburger =new Hamburger(resposta.getInt("id"),
                    resposta.getString("nome"),
                    resposta.getDouble("preco"),
                    resposta.getString("imagem"));
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
