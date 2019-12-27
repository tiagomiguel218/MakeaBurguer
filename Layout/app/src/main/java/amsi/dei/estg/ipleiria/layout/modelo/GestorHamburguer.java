package amsi.dei.estg.ipleiria.layout.modelo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import amsi.dei.estg.ipleiria.layout.data.HamburgerBDHelp;
import amsi.dei.estg.ipleiria.layout.listenners.HamburgerListenner;
import amsi.dei.estg.ipleiria.layout.utils.HamburgerJsonParse;

public class GestorHamburguer implements HamburgerListenner {


    private static GestorHamburguer INSTANCIA = null;

    private HamburgerListenner hamburgerListenner;

    private static RequestQueue volleyQueque=null;
    private ArrayList<Hamburger> gridViewHamburger;
    private HamburgerBDHelp bd;
    private String TokenAPI="AMSI-TOKEM";
    private String mURLAPIHamburger="http://192.168.1.101:8080/hamburger";

    public static synchronized GestorHamburguer getInstance(Context contexto){
        if(INSTANCIA == null){
            INSTANCIA = new GestorHamburguer(contexto);

            volleyQueque= Volley.newRequestQueue(contexto);
        }

        return INSTANCIA;
    }

    private GestorHamburguer(Context contexto){
        this.gridViewHamburger = new ArrayList<Hamburger>();
        this.bd=new HamburgerBDHelp(contexto);
        this.gridViewHamburger =bd.getAllHamburger();
    }

    public ArrayList<Hamburger> getListaHamburguer(){
        return this.gridViewHamburger;
    }

    public Hamburger getHamburger(long id){
        for (Hamburger hamburguer : this.gridViewHamburger)
            if (hamburguer.getId() == id)
                return hamburguer;
        return null;
    }


    //metodos de acesso a api

    public void getAllHamburgerAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewHamburger =bd.getAllHamburger();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIHamburger,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewHamburger = HamburgerJsonParse.parseJsonHamburger(response, context);
                            //registar tambem na base de dados local

                            if(hamburgerListenner!=null)
                                hamburgerListenner.onRefreshListaHamburger(gridViewHamburger);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("ERRO GET ALL LIVROS: " + error.getMessage());
                        }
                    }

            );
            volleyQueque.add(request);
        }
    }

    @Override
    public void onRefreshListaHamburger(ArrayList<Hamburger> listaHamburger) {

    }

    public void setHamburgerListener(HamburgerListenner hamburgerListenner){
        this.hamburgerListenner=hamburgerListenner;
    }
}