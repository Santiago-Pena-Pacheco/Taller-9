public abstract class Vehiculo implements ServicioParqueadero {
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

    // Paso 3 (LSP): calcularPuntos() salió de la clase base; no todo Vehiculo acumula puntos.

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return 0; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
