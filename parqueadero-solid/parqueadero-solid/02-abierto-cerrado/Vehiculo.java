// Paso 2 (OCP): Vehiculo ahora es abstracta; se quitaron tipo, valorMensualidad y tarifaMinuto.
public abstract class Vehiculo implements ServicioParqueadero {
    protected String placa;
    protected String propietario;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario) { // Paso 2 (OCP)
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getPlaca()       { return placa; }
    public String getPropietario() { return propietario; }

    // Paso 2 (OCP): cada modelo de cobro implementa su propia regla; no hay switch.
    public abstract double calcularCobro();

    // Puntos del programa de fidelidad: solo los vehículos mensuales los acumulan.
    public int calcularPuntos() { // Paso 2 (OCP): por defecto 0, igual que antes para los no mensuales
        return 0;
    }

    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return 0; } // Paso 2 (OCP): lo redefine VehiculoMensual
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }
}
