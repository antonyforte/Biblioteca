public class Revista extends Material{

    private int revista_edicao;
    private int revista_mes_pb;
    private int revista_ano_pb;

    public int getRevista_edicao() {
        return revista_edicao;
    }

    public void setRevista_edicao(int revista_edicao) {
        this.revista_edicao = revista_edicao;
    }

    public int getRevista_mes_pb() {
        return revista_mes_pb;
    }

    public void setRevista_mes_pb(int revista_mes_pb) {
        this.revista_mes_pb = revista_mes_pb;
    }

    public int getRevista_ano_pb() {
        return revista_ano_pb;
    }

    public void setRevista_ano_pb(int revista_ano_pb) {
        this.revista_ano_pb = revista_ano_pb;
    }

    @Override
    public String toString() {
        String A = super.toString();
        return "Tipo: Revista" + " Edição: " + revista_edicao + " Mês de Publicação: " + revista_mes_pb + " Ano de Publicação: " + revista_ano_pb;
    }
}
