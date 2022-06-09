import java.util.List;


public class Programa {
    static Biblioteca Library = new Biblioteca();

    public static void main(String[] args) {
        int menu_opcao = 0;

        while (menu_opcao != -1) {

            System.out.println("1 - Cadastro de Usuarios");
            System.out.println("2 - Cadastro de Materiais");
            System.out.println("3 - Emprestimo de Materiais");
            System.out.println("4 - Devolução de Materiais");
            System.out.println("5 - Sair");
            System.out.println("6 - Listar Emprestimos dos Usuarios");
            System.out.println("7 - Listar Materiais da Biblioteca");
            System.out.println("8 - Historico de Emprestimo do Usuario");
            System.out.println("Digite uma opção: ");
            menu_opcao = Integer.parseInt(Console.readLine());

            switch (menu_opcao) {
                case 1 -> {
                    System.out.println("1 - Graduando");
                    System.out.println("2 - Pós-Graduando(Mestrado)");
                    System.out.println("3 - Pós-Graduando(Doutorado)");
                    System.out.println("4 - Professor");
                    System.out.println("5 - Voltar");
                    System.out.println("Digite uma opção: ");
                    menu_opcao = Integer.parseInt(Console.readLine());
                    switch (menu_opcao) {
                        case 1 -> cadastrar_graduando();
                        case 2 -> cadastrar_Pos_graduandoM();
                        case 3 -> cadastrar_Pos_graduandoD();
                        case 4 -> cadastrar_Professor();
                        case 5 -> menu_opcao = 0;
                        default -> System.out.println("Opção Inválida!");
                    }
                }
                case 2 -> {
                    System.out.println("1 - Livro");
                    System.out.println("2 - Revista");
                    System.out.println("3 - CD");
                    System.out.println("4 - DVD");
                    System.out.println("5 - Voltar");
                    System.out.println("Digite uma opção: ");
                    menu_opcao = Integer.parseInt(Console.readLine());
                    switch (menu_opcao) {
                        case 1 -> cadastrar_livro();
                        case 2 -> cadastrar_revista();
                        case 3 -> cadastrar_cd();
                        case 4 -> cadastrar_dvd();
                        case 5 -> menu_opcao = 0;
                        default -> System.out.println("Opção Invalida");
                    }
                }
                case 3 -> reservar_material();
                case 4 -> devoulucao_material();
                case 5 -> menu_opcao = -1;
                case 6 -> print(Library);
                case 7 -> Library.materiais_biblioteca(Library);
                case 8 -> printa_historico(Library);
                default -> System.out.println("Opção Invalida!");
            }
        }
    }

    // FUNCOES DE CADASTRO DE USUARIOS

    public static void cadastrar_graduando() {

        System.out.println("Digite o Nome");
        String Usuario_Nome = Console.readLine();

        System.out.println("Cadastre uma Senha");
        String Usuario_Senha = Console.readLine();

        String Usuario_ID = "D" + Library.getn_Usuarios_cadastrados();

        Usuario_AlunoG Aluno_Graduando = new Usuario_AlunoG();
        Aluno_Graduando.setNome_usuario(Usuario_Nome);
        Aluno_Graduando.setSenha_Usuario(Usuario_Senha);
        Aluno_Graduando.setId_Usuario(Usuario_ID);
        Aluno_Graduando.set_limite_tempo(Aluno_Graduando, Aluno_Graduando.getLimite_tempo());
        Aluno_Graduando.set_quantidade_materiais(Aluno_Graduando, Aluno_Graduando.getLimite_materiais());

        Library.adicionar_Usuarios_cadastrados(Aluno_Graduando);
        System.out.println("USUARIO CADASTRADO COM SUCESSO\nSEU ID É: " + Aluno_Graduando.getId_Usuario());

    }


    public static void cadastrar_Pos_graduandoM() {

        System.out.println("Digite o Nome");
        String Usuario_Nome = Console.readLine();

        System.out.println("Cadastre uma Senha");
        String Usuario_Senha = Console.readLine();

        String Usuario_ID = "C" + Library.getn_Usuarios_cadastrados();

        PG_Mestrado Aluno_Mestrado = new PG_Mestrado();
        Aluno_Mestrado.setNome_usuario(Usuario_Nome);
        Aluno_Mestrado.setSenha_Usuario(Usuario_Senha);
        Aluno_Mestrado.setId_Usuario(Usuario_ID);
        Aluno_Mestrado.set_limite_tempo(Aluno_Mestrado, Aluno_Mestrado.getLimite_tempo());
        Aluno_Mestrado.set_quantidade_materiais(Aluno_Mestrado, Aluno_Mestrado.getLimite_materiais());

        Library.adicionar_Usuarios_cadastrados(Aluno_Mestrado);
        System.out.println("USUARIO CADASTRADO COM SUCESSO\nSEU ID É: " + Aluno_Mestrado.getId_Usuario());

    }


    public static void cadastrar_Pos_graduandoD() {

        System.out.println("Digite o Nome");
        String Usuario_Nome = Console.readLine();

        System.out.println("Cadastre uma Senha");
        String Usuario_Senha = Console.readLine();

        String Usuario_ID = "B" + Library.getn_Usuarios_cadastrados();

        PG_Doutorado Aluno_Doutorado = new PG_Doutorado();
        Aluno_Doutorado.setNome_usuario(Usuario_Nome);
        Aluno_Doutorado.setSenha_Usuario(Usuario_Senha);
        Aluno_Doutorado.setId_Usuario(Usuario_ID);
        Aluno_Doutorado.set_limite_tempo(Aluno_Doutorado, Aluno_Doutorado.getLimite_tempo());
        Aluno_Doutorado.set_quantidade_materiais(Aluno_Doutorado, Aluno_Doutorado.getLimite_materiais());

        Library.adicionar_Usuarios_cadastrados(Aluno_Doutorado);
        System.out.println("USUARIO CADASTRADO COM SUCESSO\nSEU ID É: " + Aluno_Doutorado.getId_Usuario());

    }


    public static void cadastrar_Professor() {

        System.out.println("Digite o Nome");
        String Usuario_Nome = Console.readLine();

        System.out.println("Cadastre uma Senha");
        String Usuario_Senha = Console.readLine();

        String Usuario_ID = "A" + Library.getn_Usuarios_cadastrados();

        Usuario_Professor professor = new Usuario_Professor();
        professor.setNome_usuario(Usuario_Nome);
        professor.setSenha_Usuario(Usuario_Senha);
        professor.setId_Usuario(Usuario_ID);
        professor.set_limite_tempo(professor, professor.getLimite_tempo());
        professor.set_quantidade_materiais(professor, professor.getLimite_materiais());

        Library.adicionar_Usuarios_cadastrados(professor);
        System.out.println("USUARIO CADASTRADO COM SUCESSO\nSEU ID É: " + professor.getId_Usuario());

    }

    //FUNCOES DE CADASTRO DE MATERIAIS
    public static void cadastrar_livro() {

        System.out.println("Digite o título do Livro");
        String Material_Titulo = Console.readLine();

        int Material_ID = Library.getn_Materiais_cadastrados();

        System.out.println("Digite o Nome da Editora do Livro");
        String Material_Editora = Console.readLine();

        System.out.println("Digite o autor do Livro");
        String Material_Autor = Console.readLine();

        System.out.println("Digite a Edição do Livro");
        int Material_Edicao = Integer.parseInt(Console.readLine());

        System.out.println("Digite o ano de Publicação do Livro");
        int Material_anop = Integer.parseInt(Console.readLine());

        Livro livro = new Livro();
        livro.setMaterial_titulo(Material_Titulo);
        livro.setMaterial_id(Material_ID);
        livro.setLivro_editora(Material_Editora);
        livro.setLivro_autor(Material_Autor);
        livro.setLivro_edicao(Material_Edicao);
        livro.setLivro_ano(Material_anop);
        livro.setMaterial_disponivel(true);

        Library.adicionar_Materiais_cadastrados(livro);
        System.out.println("Material Cadastrado Com Sucesso");

    }

    public static void cadastrar_revista() {

        System.out.println("Digite o título da Revista");
        String Material_Titulo = Console.readLine();

        int Material_ID = Library.getn_Materiais_cadastrados();

        System.out.println("Digite a Edição da Revista");
        int Material_Edicao = Integer.parseInt(Console.readLine());

        System.out.println("Digite o mês de Publicação da Revista");
        int Material_mesp = Integer.parseInt(Console.readLine());

        System.out.println("Digite o ano de Publicação da Revista");
        int Material_anop = Integer.parseInt(Console.readLine());

        Revista revista = new Revista();
        revista.setMaterial_titulo(Material_Titulo);
        revista.setMaterial_id(Material_ID);
        revista.setRevista_edicao(Material_Edicao);
        revista.setRevista_ano_pb(Material_anop);
        revista.setRevista_mes_pb(Material_mesp);
        revista.setMaterial_disponivel(true);

        Library.adicionar_Materiais_cadastrados(revista);
        System.out.println("Material Cadastrado Com Sucesso");

    }


    public static void cadastrar_cd() {

        System.out.println("Digite o título do CD");
        String Material_Titulo = Console.readLine();

        int Material_ID = Library.getn_Materiais_cadastrados();

        System.out.println("Digite o autor do CD");
        String Material_Autor = Console.readLine();

        System.out.println("Digite a faixa do CD");
        int Material_faixa = Integer.parseInt(Console.readLine());

        System.out.println("Digite o ano de Publicação do CD");
        int Material_anop = Integer.parseInt(Console.readLine());

        CD cd = new CD();
        cd.setMaterial_titulo(Material_Titulo);
        cd.setMaterial_id(Material_ID);
        cd.setCD_autor(Material_Autor);
        cd.setCD_faixa(Material_faixa);
        cd.setCd_ano_pb(Material_anop);
        cd.setMaterial_disponivel(true);

        Library.adicionar_Materiais_cadastrados(cd);
        System.out.println("Material Cadastrado Com Sucesso");

    }


    public static void cadastrar_dvd() {

        System.out.println("Digite o título do DVD");
        String Material_Titulo = Console.readLine();

        int Material_ID = Library.getn_Materiais_cadastrados();

        System.out.println("Digite o autor do DVD");
        String Material_Autor = Console.readLine();

        System.out.println("Digite o ano de Publicação do DVD");
        int Material_anop = Integer.parseInt(Console.readLine());

        System.out.println("Digite a região do DVD");
        String Material_regiao = Console.readLine();


        DvD dvd = new DvD();
        dvd.setMaterial_titulo(Material_Titulo);
        dvd.setMaterial_id(Material_ID);
        dvd.setDvD_autor(Material_Autor);
        dvd.setDvD_ano_pb(Material_anop);
        dvd.setMaterial_disponivel(true);
        dvd.setDvD_regiao(Material_regiao);

        Library.adicionar_Materiais_cadastrados(dvd);
        System.out.println("Material Cadastrado Com Sucesso");

    }

    // FUNÇÃO AUXIALIAR, PARA VERIFICAR TODOS OS EMPRESTIMOS REALIZADOS
    public static void print(Biblioteca a) {
        for (int i = 0; i < a.getn_Usuarios_cadastrados(); i++) {

            a.print_U(a, i);
        }

    }

    //FUNCAO DE EMPRESTIMO, QUE RESERVA UM MATERIAL PARA UM USUARIO
    public static void reservar_material() {

        System.out.println("Tela De Login");

        while (true) {
            System.out.println("Digite o ID do usuario: ");
            String Log_id = Console.readLine();

            int Log_id2 = Integer.parseInt(Log_id.substring(1));

            if (Library.get_Usuarios_cadastrados(Library, Log_id2)) {

                while (true) {
                    System.out.print("USUARIO ***");
                    Library.printa_Usuario(Log_id2);
                    System.out.println("***");
                    System.out.println("Digite a senha");
                    String Log_senha = Console.readLine();

                    if (Library.get_Usuarios_cadastrados_senha(Library, Log_id2, Log_senha)) {

                        System.out.println("MENU DE EMPRESTIMO");

                        System.out.println("Digite o ID do material a ser Reservado");
                        int Id_material = Integer.parseInt(Console.readLine());

                        if (Library.get_Material(Library, Id_material) && Library.material_disponivel(Library, Id_material)) {

                            Material x;
                            x = Library.getMateriais_cadastrados(Id_material);
                            Library.adicionar_acervo_usuario(Library, Log_id2, Id_material, x);

                            break;
                        } else {
                            System.out.println("Material Não Encontrado");

                        }

                    } else {
                        System.out.println("Senha Invalida! Tente Novamente apertando qualquer numero ou 0 para sair");
                        int command = Integer.parseInt(Console.readLine());
                        if (command == 0) {
                            break;
                        } else {
                            continue;
                        }
                    }

                }
                break;
            }
        }
    }

    //FUNCAO QUE REMOVE DO ACERVO DE UM USUARIO, UM MATERIAL EMPRESTADO(FUNCAO DE DEVOLUCAO DE MATERIAL)
    public static void devoulucao_material() {

        System.out.println("Tela De Login");

        while (true) {
            System.out.println("Digite o ID do usuario: ");
            String Log_id = Console.readLine();

            int Log_id2 = Integer.parseInt(Log_id.substring(1));

            if (Library.get_Usuarios_cadastrados(Library, Log_id2)) {

                while (true) {

                    System.out.print("USUARIO ***");
                    Library.print_U(Library, Log_id2);
                    System.out.println("***");

                    System.out.println("Digite a senha");
                    String Log_senha = Console.readLine();

                    if (Library.get_Usuarios_cadastrados_senha(Library, Log_id2, Log_senha)) {

                        System.out.println("MENU DE DEVOLUÇÃO");

                        while (true) {
                            System.out.println("Digite o ID do material a ser devolvido");
                            int id_material = Integer.parseInt(Console.readLine());
                            if (Library.get_Material(Library, id_material)) {
                                Library.remover_acervo_usuario(Library, Log_id2, id_material);
                                break;

                            } else {
                                System.out.println("Material Não Encontrado");
                                continue;
                            }
                        }
                        break;
                    } else {
                        System.out.println("Senha Invalida! Tente Novamente apertando qualquer numero ou 0 para sair");
                        int command = Integer.parseInt(Console.readLine());
                        if (command == 0) {
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                break;
            }
        }
    }

    //FUNCAO QUE PRINTA O HISTORICO DE EMPRESTIMO DO USUARIO
    public static void printa_historico(Biblioteca a){
        System.out.println("Digite o nome do Usuario: ");
        String A = Console.readLine();
        a.print_historico_usuario(a,A);
    }
}