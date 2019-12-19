package amsi.dei.estg.ipleiria.layout.modelo;


public class Produtos {
    private long id;
    private String nome;
    private int preco;
    private int imagem;

    public Produtos(long id, String nome, int preco, int imagem){
        this.setNome(nome);
        this.id = id;
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public Produtos(int id, String nome, int preco, int imagem){
        this.id=id;
        this.setNome(nome);
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public long getId() {
        return id;
    }

public Produtos(){

}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String toString(){
        return this.nome + ", " + this.preco + ", " + this.imagem;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

}