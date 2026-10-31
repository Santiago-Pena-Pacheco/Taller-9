public class Vehiculo implements ServicioParqueadero {
    protected String placa;
    protected String propietario;
    protected String tipo;              // "MENSUAL" o "MINUTOS"
    protected double valorMensualidad;
    protected double tarifaMinuto;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario, String tipo,
                    double valorMensualidad, double tarifaMinuto, int minutos) {
        this.placa = placa;
        this.propietario = propietario;
        this.tipo = tipo;
        this.valorMensualidad = valorMensualidad;
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    public String getPlaca()            { return placa; }
    public String getPropietario()      { return propietario; }
    public String getTipo()             { return tipo; }
    public double getValorMensualidad() { return valorMensualidad; }
    public double getTarifaMinuto()     { return tarifaMinuto; }
    public int getMinutos()             { return minutos; }

    // Puntos del programa de fidelidad: 1 punto por cada $10.000 de mensualidad.
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return valorMensualidad * 0.02; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
