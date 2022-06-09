public class Livro extends Material{

    private String livro_editora;
    private String livro_autor;
    private int livro_edicao;
    private int livro_ano;

    public String getLivro_editora() {
        return livro_editora;
    }

    public void setLivro_editora(String livro_editora) {
        this.livro_editora = livro_editora;
    }

    public String getLivro_autor() {
        return livro_autor;
    }

    public void setLivro_autor(String livro_autor) {
        this.livro_autor = livro_autor;
    }

    public int getLivro_edicao() {
        return livro_edicao;
    }

    public void setLivro_edicao(int livro_edicao) {
        this.livro_edicao = livro_edicao;
    }

    public int getLivro_ano() {
        return livro_ano;
    }

    public void setLivro_ano(int livro_ano) {
        this.livro_ano = livro_ano;
    }

    @Override
    public String toString() {
        String A = super.toString();
        return "Tipo: Livro" + " Autor: " + livro_autor + " Editora: " + livro_editora + "Edição: " + livro_edicao + " Ano de Publicação: " + livro_ano;
    }
}
