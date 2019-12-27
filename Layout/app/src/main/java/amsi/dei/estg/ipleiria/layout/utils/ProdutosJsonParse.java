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

public class ProdutosJsonParse {
    public static ArrayList<Produtos> parseJsonProdutos(JSONArray resposta, Context contexto){
        ArrayList<Produtos> lista= new ArrayList<Produtos>();
        try {

            for(int i =0; i<resposta.length(); i++){

                JSONObject produtosapi = (JSONObject)resposta.get(i);

                Produtos produtos=new Produtos(produtosapi.getInt("id"),
                        produtosapi.getString("Nome"),
                        produtosapi.getInt("Preco"),
                        produtosapi.getInt("Imagem"),
                        produtosapi.getInt("Categoria"));

                lista.add(produtos);
            }
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(contexto, "ERRO:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return lista;

    }

    public static Produtos parserJsonProdutos(JSONObject resposta, Context contexto){
        Produtos produtos = null;
        try {
            produtos =new Produtos(resposta.getInt("id"),
                    resposta.getString("Nome"),
                    resposta.getInt("Preco"),
                    resposta.getInt("Imagem"),
                    resposta.getInt("Categoria"));
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(contexto, "ERRO:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return produtos;
    }
    //1.5.3 para limpar os dados da tabela


    public static boolean isConnectionInternet(Context contexto){
        ConnectivityManager cm= (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= cm.getActiveNetworkInfo();

        return networkInfo != null&&networkInfo.isConnected();
    }
}
