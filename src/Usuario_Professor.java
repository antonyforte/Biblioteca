public class Usuario_Professor extends Usuario{

    int limite_materiais = 5;
    int limite_tempo = 4;

    public int getLimite_materiais() {
        return limite_materiais;
    }

    public void setLimite_materiais(int limite_materiais) {
        this.limite_materiais = limite_materiais;
    }

    public int getLimite_tempo() {
        return limite_tempo;
    }

    public void setLimite_tempo(int limite_tempo) {
        this.limite_tempo = limite_tempo;
    }
}
