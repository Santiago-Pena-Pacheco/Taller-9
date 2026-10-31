// Paso 3 (LSP): Bicicleta extiende Vehiculo (no VehiculoMensual) y NO es Fidelizable,
// así que ya no hereda una promesa de puntos que no puede cumplir ni lanza excepciones.
public class Bicicleta extends Vehiculo { // Paso 3 (LSP)
    private double valorMensualidad;      // Paso 3 (LSP)

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario);
        this.valorMensualidad = valorMensualidad; // Paso 3 (LSP)
    }

    @Override
    public double calcularCobro() { return valorMensualidad; } // Paso 3 (LSP)

    @Override
    public double calcularSeguro() { return valorMensualidad * 0.02; } // Paso 3 (LSP): mismo seguro que antes
}
