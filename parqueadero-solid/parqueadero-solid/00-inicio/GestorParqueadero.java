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

    public String exportarCSV(List<Vehiculo> vehiculos) {
        StringBuilder sb = new StringBuilder("placa;propietario;cobro\n");
        for (Vehiculo v : vehiculos) {
            sb.append(v.getPlaca()).append(";")
              .append(v.getPropietario()).append(";")
              .append(calcularCobro(v)).append("\n");
        }
        return sb.toString();
    }

    public void enviarRecibo(Vehiculo v, double cobro) {
        System.out.println("SMS a " + v.getPropietario() + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $" + String.format("%,.0f", cobro));
    }
}
