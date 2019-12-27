package amsi.dei.estg.ipleiria.layout.modelo;


public class Hamburger {
    private long id;
    private String nome;
    private double preco;
    private String imagem;

    public Hamburger(long id, String nome, double preco, String imagem){
        this.setNome(nome);
        this.id = id;
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public Hamburger(int id, String nome, double preco, String imagem){
        this.id=id;
        this.setNome(nome);
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public long getId() {
        return id;
    }

public Hamburger(){

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