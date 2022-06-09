import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Biblioteca {

    private List <Usuario> Usuarios_cadastrados = new ArrayList<>();
    private List <Material> Materiais_cadastrados = new ArrayList<>();


    // FUNCAO QUE PRINTA TODOS OS MATERIAIS E SUAS INFORMACOES, DA BIBLIOTECA
    public void materiais_biblioteca(Biblioteca a){
        for(int i=0 ; i < a.Materiais_cadastrados.size(); i++){

            System.out.println(a.Materiais_cadastrados.get(i).toString());

        }
    }

    //FUNCAO PARA PRINTAR O NOME DO USUARIO
    public void printa_Usuario(int x){
        System.out.print(Usuarios_cadastrados.get(x).getNome_usuario());
    }

    //FUNCAO QUE VERIFICA O LIMITE DE EMPRESTIMO DO USUARIO. RETORNA FALSE CASO O USUARIO TENHA ATINGIDO O LIMITE DE MATERIAIS QUE ELE PODE PEGAR
    public boolean verificar_limite_emprestimo(Biblioteca a, int usuario_id){
        System.out.println("Total de Materiais Reservado -> " + a.Usuarios_cadastrados.get(usuario_id).size_Acervo_Usuario(a.Usuarios_cadastrados.get(usuario_id))+ "\nLimite de Materiais do Usuario -> "+ a.Usuarios_cadastrados.get(usuario_id).getQtd_materiais());
        if(a.Usuarios_cadastrados.get(usuario_id).size_Acervo_Usuario(a.Usuarios_cadastrados.get(usuario_id)) >= a.Usuarios_cadastrados.get(usuario_id).getQtd_materiais()){

            return false;
        }else{
            return true;
        }
    }

    //FUNCAO QUE VERIFICA SE O USUARIO ESTA PEGANDO UM MATERIAL IGUAL AO QUE JA TENHA PEGO. RETORNA FALSE TBM CASO ISSO ACONTECA
    public boolean verificar_material_igual(Biblioteca a, int usuario_id, Material m){
        int verificador = 0;
        for(int i = 0 ; i < a.Usuarios_cadastrados.get(usuario_id).size_Acervo_Usuario(a.Usuarios_cadastrados.get(usuario_id)); i++){
            if(a.Usuarios_cadastrados.get(usuario_id).get_Nome_Acervo(i).equals(m.getMaterial_titulo())) {
                verificador = 1;
                break;
            }
        }
        if(verificador == 0){
            return true;
        }else{
            return false;
        }
    }

    //FUNCAO QUE VERIFICA SE O USUARIO ATRASOU NA DEVOLUCAO DE ALGUM DOS MATERIAIS QUE ELE PEGOU EMPRESTADO. RETORNA FALSE TBM CASO ISSO ACONTECA
    public boolean verificar_pendencias(Biblioteca a, int usuario_id, int material_id){
        int quantidade_pendencias = 0;
        Date dataA = new Date();
        int horaA = Integer.parseInt(new SimpleDateFormat("HHmm").format(dataA));
        System.out.println("Hora -> "+ horaA);
        for(int i = 0 ; i < a.Usuarios_cadastrados.get(usuario_id).size_Acervo_Usuario(a.Usuarios_cadastrados.get(usuario_id)); i++){
            System.out.println("Data de emprestimo -> "+ a.Usuarios_cadastrados.get(usuario_id).get_i_tempoE(i));
            if(horaA - a.Usuarios_cadastrados.get(usuario_id).get_i_tempoE(i) > a.Usuarios_cadastrados.get(usuario_id).getTempo_d()){

                quantidade_pendencias++;
                a.Usuarios_cadastrados.get(usuario_id).setPendencias_materiais(quantidade_pendencias);

            }
        }
        if(quantidade_pendencias > 0){
            return false;
        }else{
            return true;
        }
    }

    //FUNCAO QUE PRINTA O HISTORICO DO USUARIO
    public void print_historico_usuario(Biblioteca a, String nome){
        for(int i = 0; i < a.Usuarios_cadastrados.size(); i++){
            if(nome.equals(a.Usuarios_cadastrados.get(i).getNome_usuario())){
                a.Usuarios_cadastrados.get(i).printa_historico();
            }else if(i == a.Usuarios_cadastrados.size()-1){
                System.out.println("Usuario Nao Encontrado");
            }
        }
    }

    //FUNCAO DE EMPRESTIMO DE MATERIAL, QUE ADICIONA UM MATERIAL NO ACERVO DO USUARIO E O TORNA INDISPONIVEL ATE A DEVOLUCAO DO MESMO
    public void adicionar_acervo_usuario(Biblioteca a, int usuario_id, int material_id, Material m){

        if(verificar_pendencias(a,usuario_id,material_id) && verificar_limite_emprestimo(a,usuario_id) && verificar_material_igual(a,usuario_id,m)) {
            Date data = new Date();
            int hora = Integer.parseInt(new SimpleDateFormat("HHmm").format(data));
            a.Usuarios_cadastrados.get(usuario_id).adicionarAcervo_Usuario(m);
            a.Usuarios_cadastrados.get(usuario_id).adicionarHistorico_Acervo(m);
            a.Materiais_cadastrados.get(material_id).setMaterial_disponivel(false);
            a.Materiais_cadastrados.get(material_id).setUsuario_emp(a.Usuarios_cadastrados.get(usuario_id).getNome_usuario());
            a.Usuarios_cadastrados.get(usuario_id).adicionari_tempoE(hora);
            int horad = hora + a.Usuarios_cadastrados.get(usuario_id).getTempo_d();

            System.out.println("MATERIAL ADICIONADO");
            System.out.println("RECIBO\nNome: "+a.Usuarios_cadastrados.get(usuario_id).getNome_usuario()+"\nMaterial: "+a.Materiais_cadastrados.get(material_id).getMaterial_titulo()+"\nHorario do Emprestimo: "+hora+"\nHorario de Devolução: "+ horad);
        }
        else{
            System.out.println("Voce tem atrasos na devolução de materiais ou muitos materiais pegos\nDevolva o material antes de realizar um novo empréstimo");
        }
    }

    //FUNCAO DE DEVOLUCAO DE MATERIAL, QUE REMOVE UM MATERIAL DO ACERVO DE UM USUARIO E O TORNA DISPONIVEL PARA OUTROS EMPRESTIMOS
    public void remover_acervo_usuario(Biblioteca a, int usuario_id, int material_id){
        Date data = new Date();
        int hora = Integer.parseInt(new SimpleDateFormat("HHmm").format(data));
        a.Usuarios_cadastrados.get(usuario_id).removerAcervo_Usuario(material_id);
        a.Materiais_cadastrados.get(material_id).setMaterial_disponivel(true);
        a.Usuarios_cadastrados.get(usuario_id).removeri_tempo();

    }

    //FUNCAO QUE PRINTA OS MATERIAIS PEGADOS PARA EMPRESTIMO DE UM DETERMINADO USUARIO
    public void print_U(Biblioteca a, int x){

        a.Usuarios_cadastrados.get(x).printa_NomeU(a.Usuarios_cadastrados.get(x));
    }

    public boolean get_Usuarios_cadastrados_senha(Biblioteca a,int x, String s){
        if(a.Usuarios_cadastrados.get(x).getSenha_Usuario().equals(s)){
            return true;
        }else{
            return false;
        }
    }

    public boolean get_Usuarios_cadastrados(Biblioteca a,int x){
        if(a.Usuarios_cadastrados.get(x) != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean material_disponivel(Biblioteca a, int x){
        if(a.Materiais_cadastrados.get(x).isMaterial_disponivel()){
            return true;
        }else{
            return false;
        }
    }

    public boolean get_Material(Biblioteca a, int x){
        if(a.Materiais_cadastrados.get(x) != null){
            return true;
        }else{
            return false;
        }
    }


    public Material getMateriais_cadastrados(int x) {
        return Materiais_cadastrados.get(x);
    }


    public void adicionar_Usuarios_cadastrados(Usuario usuarios_cadastrados){
        Usuarios_cadastrados.add(usuarios_cadastrados);
    }

    public void adicionar_Materiais_cadastrados(Material materiais_cadastrados){
        Materiais_cadastrados.add(materiais_cadastrados);
    }

    public int getn_Usuarios_cadastrados(){
        return Usuarios_cadastrados.size();
    }

    public int getn_Materiais_cadastrados(){
        return Materiais_cadastrados.size();
    }


}
