// Paso 2 (OCP): subclase nueva para el cobro mensual (antes case "MENSUAL").
public class VehiculoMensual extends Vehiculo {
    protected double valorMensualidad;

    public VehiculoMensual(String placa, String propietario, double valorMensualidad) {
        super(placa, propietario);
        this.valorMensualidad = valorMensualidad;
    }

    @Override
    public double calcularCobro() { return valorMensualidad; }

    // Puntos del programa de fidelidad: 1 punto por cada $10.000 de mensualidad.
    @Override
    public int calcularPuntos() { return (int) (valorMensualidad / 10000); }

    @Override
    public double calcularSeguro() { return valorMensualidad * 0.02; }
}
