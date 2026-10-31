import java.util.List;

public class GestorParqueadero {
    private final RepositorioCobros repositorio; // Paso 5 (DIP): depende de la interfaz, no de MySQL

    public GestorParqueadero(RepositorioCobros repositorio) { // Paso 5 (DIP): inyección por constructor
        this.repositorio = repositorio;
    }

    public double calcularCobro(Vehiculo v) {
        return v.calcularCobro();
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    public String cerrarMes(List<Vehiculo> vehiculos, ExportadorCSV exportador, NotificadorSMS notificador) {
        for (Vehiculo v : vehiculos) {
            double cobro = calcularCobro(v);
            guardar(v, cobro);
            notificador.enviarRecibo(v, cobro);
        }
        return exportador.exportar(vehiculos, this);
    }
}
