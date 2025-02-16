package amsi.dei.estg.ipleiria.layout.modelo;

public class Produtos {
    private long id;
    private String nome;
    private double preco;
    private String imagem;
    private int categoria;


    public Produtos(long id, String nome, double preco, String imagem, int categoria){
        this.setNome(nome);
        this.id = id;
        this.setPreco(preco);
        this.setImagem(imagem);
        this.setCategoria(categoria);
    }

    public Produtos(int id, String nome, double preco, String imagem, int categoria){
        this.id=id;
        this.setNome(nome);
        this.setPreco(preco);
        this.setImagem(imagem);
        this.setCategoria(categoria);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


   public int getCategoria(){return categoria;}

   public void setCategoria(int categoria){this.categoria=categoria;}



    public String toString(){
        return this.nome + ", " + this.preco + ", " + this.imagem;
    }







}
