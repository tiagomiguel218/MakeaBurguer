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

import amsi.dei.estg.ipleiria.layout.R;
import amsi.dei.estg.ipleiria.layout.data.HamburgerBDHelp;
import amsi.dei.estg.ipleiria.layout.listenners.HamburgerListenner;
import amsi.dei.estg.ipleiria.layout.utils.HamburgerJsonParse;

public class GestorHamburguer implements HamburgerListenner {



    private static GestorHamburguer INSTANCIA = null;

    public final static int ADICIONAR=1;
    public final static int ALTERAR=2;
    public final static int REMOVER =3;

    private HamburgerListenner hamburgerListenner;

    private static RequestQueue volleyQueque=null;
    private ArrayList<Produtos> gridViewHamburguer;
    private HamburgerBDHelp bd;
    private String TokenAPI="AMSI-TOKEM";
    private String mURLAPIHamburger="http://localhost:8080/hamburger";

    public static synchronized GestorHamburguer getInstance(Context contexto){
        if(INSTANCIA == null){
            INSTANCIA = new GestorHamburguer(contexto);

            volleyQueque= Volley.newRequestQueue(contexto);
        }

        return INSTANCIA;
    }

    private GestorHamburguer(Context contexto){
        this.gridViewHamburguer = new ArrayList<Produtos>();
        this.bd=new HamburgerBDHelp(contexto);
        this.gridViewHamburguer=bd.getAllHamburger();
    }

   /* private void gerarHamburguer() {
        this.gridViewHamburguer.add(new Produtos(1, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(2, "Hamburguer Duplo Carne", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(3, "Hamburguer Duplo Completo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(4, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(5, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(6, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(7, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(8, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(9, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(10, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(11, "Hamburguer Duplo Queijo", 10, R.mipmap.burger2));
        this.gridViewHamburguer.add(new Produtos(12, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));
        this.gridViewHamburguer.add(new Produtos(13, "Hamburguer Duplo Queijo", 10, R.mipmap.burger));

    }*/

    public ArrayList<Produtos> getListaHamburguer(){
        return this.gridViewHamburguer;
    }

    public Produtos getHamburger(long id){
        for (Produtos l : this.gridViewHamburguer)
            if (l.getId() == id)
                return l;
        return null;
    }


    public void adicionarHamburger(Produtos livro) {
        Produtos livroinserido = this.bd.inserirHamburgerBD(livro);
        if (livroinserido != null)
            this.gridViewHamburguer.add(livroinserido);
    }

    public void removerHamburger(long id) {
        if (bd.deleteHamburgerBD((int) id)) {
            Produtos livroaux = getHamburger(id);
            this.gridViewHamburguer.remove(livroaux);
        }
    }

    public void editarHamburger(long id, Produtos novosdados) {

        if (bd.atualizarHamburgerBD((int) id, novosdados)) {

            Produtos update = this.getHamburger(id);

            update.setNome(novosdados.getNome());
            update.setPreco(novosdados.getPreco());
            update.setImagem(novosdados.getImagem());
        }
    }

    //metodos de acesso a api

    public void adicionarHamburgerAPI(final Produtos hamburger, final Context contexto) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                mURLAPIHamburger,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("RESPOSTA POST ADD: " + response);
                        hamburgerListenner.onUpdateListaHamburger(hamburger, ADICIONAR);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("ERRO POT ADD: " + error.getMessage());
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("token", TokenAPI);
                params.put("nome", hamburger.getNome());
                params.put("preco", "" + hamburger.getPreco());
                params.put("imagem","" + hamburger.getImagem());

                return params;
            }
        };
        volleyQueque.add(request);
    }

    public void atulizarHamburgerAPI(final Produtos hamburger, final int id, final Context contexto) {
        StringRequest request = new StringRequest(
                Request.Method.PUT,
                mURLAPIHamburger + "/" + id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("RESPOSTA POST ADD: " + response);

                        hamburger.setId(id);
                       hamburgerListenner.onUpdateListaHamburger(hamburger, ALTERAR);

                        //atualizar a base de dados

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("ERRO POT ADD: " + error.getMessage());
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("token", TokenAPI);
                params.put("nome", hamburger.getNome());
                params.put("preco", "" + hamburger.getPreco());
                params.put("imagem", "" + hamburger.getImagem());

                return params;
            }
        };
        volleyQueque.add(request);
    }

    public void removerHamburgerAPI (final Produtos livro, Context contexto){
        StringRequest requ=new StringRequest(
                Request.Method.DELETE,
                mURLAPIHamburger + "/" + livro.getId(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("RESPOSTA REMOVER ->" + response);
                        hamburgerListenner.onUpdateListaHamburger(livro, REMOVER);


                        //atualizar a BD
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        System.out.println("RESPOSTA REMOVER->" + error.getMessage());
                    }
                }
        );
        volleyQueque.add(requ);

    }


    public void getAllHamburgerAPI(final Context context, final boolean isConnected){
        if(!isConnected){
            gridViewHamburguer=bd.getAllHamburger();
        }
        else{
            JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    mURLAPIHamburger,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            gridViewHamburguer = HamburgerJsonParse.parseJsonHamburger(response, context);
                            //registar tambem na base de dados local

                            if(hamburgerListenner!=null)
                                hamburgerListenner.onRefreshListaHamburger(gridViewHamburguer);
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
    public void onRefreshListaHamburger(ArrayList<Produtos> listaHamburger) {

    }

    @Override
    public void onUpdateListaHamburger(Produtos hamburger, int operacao) {
        switch (operacao){
            case ADICIONAR:
                adicionarHamburger(hamburger);
                break;
            case ALTERAR:
                editarHamburger(hamburger.getId(), hamburger);
                break;
            case REMOVER:
                removerHamburger(hamburger.getId());
                break;


        }
    }

    public void setHamburgerListener(HamburgerListenner hamburgerListenner){
        this.hamburgerListenner=hamburgerListenner;
    }
}