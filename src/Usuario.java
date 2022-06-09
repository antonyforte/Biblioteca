import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String nome_usuario;
    private String Id_Usuario;
    private String senha_Usuario;
    private List <Material> acervo_Usuario = new ArrayList<>();
    private ArrayList<Integer> i_tempoE = new ArrayList<Integer>();
    private int pendencias_materiais;
    private int tempo_d;
    private int qtd_materiais;
    private List <Material> historico_acervo = new ArrayList<>();

    public int getPendencias_materiais() {
        return pendencias_materiais;
    }

    public void setPendencias_materiais(int pendencias_materiais) {
        this.pendencias_materiais = pendencias_materiais;
    }

    public String get_Nome_Acervo(int x){
        return acervo_Usuario.get(x).getMaterial_titulo();
    }

    public int get_i_tempoE(int x){
        return i_tempoE.get(x);
    }

    public void printa_historico(){
        for(int i = 0; i < historico_acervo.size(); i++){
            int material_finalizado = 0;
            System.out.println(historico_acervo.get(i).getMaterial_titulo());
            System.out.println(historico_acervo.get(i).getClass().getName());
            System.out.println(historico_acervo.get(i).getI_tempoE());
            for(int j = 0; j < acervo_Usuario.size(); j++){
                if(acervo_Usuario.get(j).getMaterial_titulo().equals(historico_acervo.get(i).getMaterial_titulo())){
                    material_finalizado = 1;
                    break;
                }
            }
            if(material_finalizado == 1){
                System.out.println("Emprestimo em Curso");
            }else{
                System.out.println("Emprestimo Finalizado");
            }
        }
    }

    // FUNCAO QUE PRINTA OS MATERIAIS PEGADOS PARA EMPRESTIMO DE UM USUARIO ---> BIBLIOTECA/PRINTU
    public void printa_NomeU(Usuario x){

        System.out.println("Nome: " + getNome_usuario());
        System.out.println("Materiais Pegados para Emprestimo: ");
        for(int i = 0; i < x.size_Acervo_Usuario(x); i++){
            String Vector = x.acervo_Usuario.get(i).getMaterial_titulo();
            System.out.println(Vector);
        }
    }
    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getSenha_Usuario() {
        return senha_Usuario;
    }

    public List <Material> getAcervo_Usuario(){
        return acervo_Usuario;
    }

    public void setSenha_Usuario(String senha_Usuario) {
        this.senha_Usuario = senha_Usuario;
    }


    //FUNCOES ADD DAS LISTAS
    public void adicionarHistorico_Acervo(Material Acervo_Usuario) {historico_acervo.add(Acervo_Usuario);}
    public void adicionarAcervo_Usuario(Material Acervo_Usuario){
        acervo_Usuario.add(Acervo_Usuario);
    }
    public void adicionari_tempoE(int tempo){ i_tempoE.add(0,tempo);}

    public void removeri_tempo(){
        i_tempoE.remove(0);
    }
    public void removerAcervo_Usuario(int Acervo_Usuario){ acervo_Usuario.remove(Acervo_Usuario);}

    public int size_Acervo_Usuario(Usuario x){
        return x.acervo_Usuario.size();
    }

    public void setAcervo_Usuario_Hora(int x, int hora){
        acervo_Usuario.get(x).setI_tempoE(hora);
    }

    public void set_limite_tempo(Usuario x,int y){
        x.tempo_d = y;
    }

    public void set_quantidade_materiais(Usuario x, int y){
        x.qtd_materiais = y;
    }

    public int getQtd_materiais(){
        return qtd_materiais;
    }

    public int getTempo_d() {
        return tempo_d;
    }
}
