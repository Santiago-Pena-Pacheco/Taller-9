// Paso 2 (OCP): demostración del principio. Nuevo modelo de cobro por día,
// agregado SIN modificar Vehiculo, GestorParqueadero, ExportadorCSV ni NotificadorSMS.
public class VehiculoPorDia extends Vehiculo {
    private double tarifaDia;
    private int dias;

    public VehiculoPorDia(String placa, String propietario, double tarifaDia, int dias) {
        super(placa, propietario);
        this.tarifaDia = tarifaDia;
        this.dias = dias;
    }

    @Override
    public double calcularCobro() { return dias * tarifaDia; }
}
