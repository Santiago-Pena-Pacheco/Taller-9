// Paso 2 (OCP): ahora extiende VehiculoMensual (ya no pasa "MENSUAL" ni ceros al constructor).
public class Bicicleta extends VehiculoMensual {

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, valorMensualidad); // Paso 2 (OCP)
    }

    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException(
            "Las bicicletas no acumulan puntos de fidelidad");
    }
}
