public class Pokemon {
    private int id;
    private String nombre;
    private String tipo1;
    private String tipo2;
    private int total;
    private int hp;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int generacion;
    private boolean legendario;

    public Pokemon(int id, String nombre, String tipo1, String tipo2, int total, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, int generacion, boolean legendario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.total = total;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.generacion = generacion;
        this.legendario = legendario;
    }
    public Pokemon(int id, String nombre, String tipo1 , int total, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, int generacion, boolean legendario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = null;
        this.total = total;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.generacion = generacion;
        this.legendario = legendario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public boolean isLegendario() {
        return legendario;
    }

    public void setLegendario(boolean legendario) {
        this.legendario = legendario;
    }

    @Override
    public String toString() {
        return String.format("""
            Pokemon nº%s:
            \tNombre: %s Tipo: %s %s
            \t\tGeneración %s Legendario %s
            \t\t\tHP: %s
            \t\t\tAtaque: %s
            \t\t\tDefensa: %s
            \t\t\tAtaque Especial: %s
            \t\t\tDefensa Especial: %s
            \t\t\tVelocidad: %s
            \t\t\tTotal: %s
            """,
                this.id,
                this.nombre,
                this.tipo1,
                this.tipo2,
                this.generacion,
                this.legendario,
                this.hp,
                this.ataque,
                this.defensa,
                this.ataqueEspecial,
                this.defensaEspecial,
                this.velocidad,
                this.total);
    }
}
