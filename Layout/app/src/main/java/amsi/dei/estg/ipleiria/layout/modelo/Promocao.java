package amsi.dei.estg.ipleiria.layout.modelo;

public class Promocao {
    private long id;
    private String nome;
    private int preco;
    private int imagem;

    public Promocao(long id, String nome, int preco, int imagem) {
        this.id=id;
        this.setNome(nome);
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public long getId() {
        return id;
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


    @Override
    public String toString() {
        return  this.imagem  + this.nome + this.preco+"" ;
    }
}

