// Paso 4 (ISP): reemplaza ServicioParqueadero por tres interfaces pequeñas.
public abstract class Vehiculo implements Cronometrable, Asegurable, Lavable {
    protected String placa;
    protected String propietario;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario) {
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getPlaca()       { return placa; }
    public String getPropietario() { return propietario; }

    public abstract double calcularCobro();

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return 0; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
