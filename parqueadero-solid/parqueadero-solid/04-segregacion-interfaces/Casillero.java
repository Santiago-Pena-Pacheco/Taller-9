// Casillero para guardar cascos y maletas. Se cobra por minuto de uso.
// Paso 4 (ISP): solo implementa la capacidad que realmente tiene; ya no hay métodos vacíos.
public class Casillero implements Cronometrable { // Paso 4 (ISP)
    private String codigo;
    private String usuario;
    private double tarifaMinuto;
    private int minutos;

    public Casillero(String codigo, String usuario, double tarifaMinuto) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.tarifaMinuto = tarifaMinuto;
    }

    public void registrarMinutos(int minutos) { this.minutos += minutos; }

    // Paso 4 (ISP): se eliminaron calcularSeguro() y solicitarLavados() (eran métodos de relleno).

    public double valorAlquiler() { return minutos * tarifaMinuto; }
}
