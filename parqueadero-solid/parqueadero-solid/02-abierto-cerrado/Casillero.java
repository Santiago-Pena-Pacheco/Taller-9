// Casillero para guardar cascos y maletas. Se cobra por minuto de uso.
public class Casillero implements ServicioParqueadero {
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

    public double calcularSeguro() {
        return 0;   // un casillero no tiene póliza de seguro
    }

    public void solicitarLavados(int cantidad) {
        // a un casillero no se le hace lavado
    }

    public double valorAlquiler() { return minutos * tarifaMinuto; }
}
