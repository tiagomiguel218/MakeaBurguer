package amsi.dei.estg.ipleiria.layout.modelo;


    public class Produtos {
        private int id;
        private String nome;
        private int preco;
        private int imagem;


    public Produtos(int id, String nome, int preco, int imagem) {
        this.id=id;
        this.setNome(nome);
        this.setPreco(preco);
        this.setImagem(imagem);
    }

    public Produtos(){

    }

    public int getId() {
        return id;
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
        return  this.imagem  + this.nome + this.preco+"";
    }

}