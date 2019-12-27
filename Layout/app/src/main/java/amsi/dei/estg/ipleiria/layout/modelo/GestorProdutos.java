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

import amsi.dei.estg.ipleiria.layout.data.ProdutosBDHelp;
import amsi.dei.estg.ipleiria.layout.listenners.ProdutosListenner;
import amsi.dei.estg.ipleiria.layout.utils.ProdutosJsonParse;


public class GestorProdutos implements ProdutosListenner{



    private static GestorProdutos INSTANCIA = null;


    private ProdutosListenner produtosListenner;

    private static RequestQueue volleyQueque=null;
    private ArrayList<Produtos> gridViewProdutos;


    private ArrayList<Produtos> gridViewBebidas;
    private ArrayList<Produtos> gridViewSobremesas;
    private ArrayList<Produtos> gridViewComplementos;


    private ProdutosBDHelp bd;
    private String TokenAPI="AMSI-TOKEM";
    private String mURLAPIProdutos="http://192.168.1.101:8080/produtos";


    public static synchronized GestorProdutos getInstance(Context contexto){
        if(INSTANCIA == null){
            INSTANCIA = new GestorProdutos(contexto);

            volleyQueque= Volley.newRequestQueue(contexto);
        }

        return INSTANCIA;
    }


    private GestorProdutos(Context contexto){
        this.gridViewProdutos = new ArrayList<Produtos>();
        this.bd=new ProdutosBDHelp(contexto);

        //this.gridViewProdutos =bd.getAllProdutos();
        this.gridViewBebidas =bd.getAllBebidas();
        this.gridViewSobremesas =bd.getAllSobremesas();
        this.gridViewComplementos =bd.getAllComplementos();
    }

    public ArrayList<Produtos> getListaProdutos(){
        return this.gridViewProdutos;
    }

    public ArrayList<Produtos> getListaBebidas(){
        return this.gridViewBebidas;
    }

    public ArrayList<Produtos> getListaComplementos(){
        return this.gridViewComplementos;
    }

    public ArrayList<Produtos> getListaSobremesas(){
        return this.gridViewSobremesas;
    }


  /* public Produtos getProdutos(long id){
        for (Produtos produtos : this.gridViewProdutos)
            if (produtos.getId() == id)
                return produtos;
        return null;
    }*/

    public Produtos getBebidas(int categoria){
        for (Produtos bebidas :this.gridViewBebidas)
            if(bebidas.getCategoria()== 7)
                return bebidas;
            return null;
    }

    public Produtos getSobremesas(int categoria){
        for (Produtos sobremesas :this.gridViewSobremesas)
            if(sobremesas.getCategoria() == 8)
                return sobremesas;
        return null;
    }

    public Produtos getComplementos(int categoria){
        for (Produtos complemento :this.gridViewComplementos)
            if(complemento.getCategoria() == 9)
                return complemento;
        return null;
    }



    //metodos de acesso a api


    /*public void getAllProdutosAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewProdutos =bd.getAllProdutos();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIProdutos,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewProdutos = ProdutosJsonParse.parseJsonProdutos(response, context);
                            //registar tambem na base de dados local

                            if(produtosListenner!=null)
                                produtosListenner.onRefreshListaProdutos(gridViewProdutos);
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
    }*/

    public void getAllBebidasAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewBebidas =bd.getAllBebidas();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIProdutos,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewBebidas = ProdutosJsonParse.parseJsonProdutos(response, context);
                            //registar tambem na base de dados local

                            if(produtosListenner!=null)
                                produtosListenner.onRefreshListaProdutos(gridViewBebidas);
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

    public void getAllComplementosAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewComplementos =bd.getAllComplementos();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIProdutos,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewComplementos = ProdutosJsonParse.parseJsonProdutos(response, context);
                            //registar tambem na base de dados local

                            if(produtosListenner!=null)
                                produtosListenner.onRefreshListaProdutos(gridViewComplementos);
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

    public void getAllSobremesasAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewSobremesas =bd.getAllSobremesas();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIProdutos,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewSobremesas = ProdutosJsonParse.parseJsonProdutos(response, context);
                            //registar tambem na base de dados local

                            if(produtosListenner!=null)
                                produtosListenner.onRefreshListaProdutos(gridViewSobremesas);
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
    public void onRefreshListaProdutos(ArrayList<Produtos> listaProdutos) {

    }



    public void setProdutosListener(ProdutosListenner produtosListenner){
        this.produtosListenner=produtosListenner;
    }
}
