public class Material {
    private int Material_id;
    private String Material_titulo;
    private boolean Material_disponivel;
    private int i_tempoE;
    private String Usuario_emp;


    public boolean isMaterial_disponivel() {
        return Material_disponivel;
    }

    public void setMaterial_disponivel(boolean material_disponivel) {
        Material_disponivel = material_disponivel;
    }

    public int getI_tempoE() {
        return i_tempoE;
    }

    public void setI_tempoE(int i_tempoE) {
        this.i_tempoE = i_tempoE;
    }

    public int getMaterial_id() {
        return Material_id;
    }

    public void setMaterial_id(int material_id) {
        Material_id = material_id;
    }

    public String getMaterial_titulo() {
        return Material_titulo;
    }

    public void setMaterial_titulo(String material_titulo) {
        Material_titulo = material_titulo;
    }


    public void setUsuario_emp(String usuario_emp) {
        Usuario_emp = usuario_emp;
    }

    @Override
    public String toString() {
        if(Material_disponivel == false){
            System.out.println("Reservado por "+Usuario_emp);
        }
        return "Nome: " + Material_titulo + " " + "Material ID: " + Material_id + " " + "Disponivel: " + Material_disponivel;

    }
}
