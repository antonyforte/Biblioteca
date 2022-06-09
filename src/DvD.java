public class DvD extends Material{

    private String DvD_autor;
    private int DvD_ano_pb;
    private String DvD_regiao;

    public String getDvD_autor() {
        return DvD_autor;
    }

    public void setDvD_autor(String dvD_autor) {
        DvD_autor = dvD_autor;
    }

    public int getDvD_ano_pb() {
        return DvD_ano_pb;
    }

    public void setDvD_ano_pb(int dvD_ano_pb) {
        DvD_ano_pb = dvD_ano_pb;
    }

    public String getDvD_regiao() {
        return DvD_regiao;
    }

    public void setDvD_regiao(String dvD_regiao) {
        DvD_regiao = dvD_regiao;
    }

    @Override
    public String toString() {
        String A = super.toString();
        return "Tipo: DVD" + " Autor: " + DvD_autor + " Região: " + DvD_regiao + " Ano de Publicação: " + DvD_ano_pb;
    }
}
