import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();

    public double calcularCobro(Vehiculo v) {
        switch (v.getTipo()) {
            case "MENSUAL": return v.getValorMensualidad();
            case "MINUTOS": return v.getMinutos() * v.getTarifaMinuto();
            default: throw new IllegalArgumentException("Tipo desconocido: " + v.getTipo());
        }
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }

    // Paso 1 (SRP): el gestor solo coordina; exportar y notificar se delegan a sus clases.
    public String cerrarMes(List<Vehiculo> vehiculos, ExportadorCSV exportador, NotificadorSMS notificador) {
        for (Vehiculo v : vehiculos) {
            double cobro = calcularCobro(v);
            guardar(v, cobro);
            notificador.enviarRecibo(v, cobro);
        }
        return exportador.exportar(vehiculos, this);
    }
    // Paso 1 (SRP): se eliminaron exportarCSV() y enviarRecibo() de esta clase.
}
