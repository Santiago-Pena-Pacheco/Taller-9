public class Bicicleta extends Vehiculo {

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, "MENSUAL", valorMensualidad, 0, 0);
    }

    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException(
            "Las bicicletas no acumulan puntos de fidelidad");
    }
}
