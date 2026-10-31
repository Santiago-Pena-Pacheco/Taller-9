import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();

    // Paso 2 (OCP): sin switch; el gestor no cambia al agregar nuevos tipos de vehículo.
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
