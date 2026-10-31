import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DEF98G", "Laura Pardo", 25000, 3));

        GestorParqueadero gestor = new GestorParqueadero();
        ExportadorCSV exportador = new ExportadorCSV();
        NotificadorSMS notificador = new NotificadorSMS();

        String csv = gestor.cerrarMes(vehiculos, exportador, notificador);
        System.out.println(csv);

        // Paso 3 (LSP): se recorren todos los vehículos sin que ninguno lance excepción;
        // los puntos se piden solo a quienes cumplen el contrato Fidelizable.
        for (Vehiculo v : vehiculos) {                       // Paso 3 (LSP)
            if (v instanceof Fidelizable) {                  // Paso 3 (LSP)
                Fidelizable f = (Fidelizable) v;             // Paso 3 (LSP)
                System.out.println("Puntos de " + v.getPlaca() + ": " + f.calcularPuntos()); // Paso 3 (LSP)
            }
        }
    }
}
