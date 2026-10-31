// Paso 2 (OCP): subclase nueva para el cobro por minutos (antes case "MINUTOS").
public class VehiculoPorMinutos extends Vehiculo {
    private double tarifaMinuto;

    public VehiculoPorMinutos(String placa, String propietario, double tarifaMinuto, int minutos) {
        super(placa, propietario);
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    @Override
    public double calcularCobro() { return minutos * tarifaMinuto; }
}
