public class CD extends Material{

    private String CD_autor;
    private int CD_faixa;
    private int Cd_ano_pb;

    public String getCD_autor() {
        return CD_autor;
    }

    public void setCD_autor(String CD_autor) {
        this.CD_autor = CD_autor;
    }

    public int getCD_faixa() {
        return CD_faixa;
    }

    public void setCD_faixa(int CD_faixa) {
        this.CD_faixa = CD_faixa;
    }

    public int getCd_ano_pb() {
        return Cd_ano_pb;
    }

    public void setCd_ano_pb(int cd_ano_pb) {
        Cd_ano_pb = cd_ano_pb;
    }

    @Override
    public String toString() {
        String A = super.toString();
        return "Tipo: CD" + " Autor: " + CD_autor + " Faixa: " + CD_faixa + " Ano de Publicação: " + Cd_ano_pb;
    }
}
