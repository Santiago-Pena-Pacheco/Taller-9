import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));     // Paso 2 (OCP)
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500)); // Paso 2 (OCP)
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DEF98G", "Laura Pardo", 25000, 3));     // Paso 2 (OCP): nuevo modelo de cobro

        GestorParqueadero gestor = new GestorParqueadero();
        ExportadorCSV exportador = new ExportadorCSV();
        NotificadorSMS notificador = new NotificadorSMS();

        String csv = gestor.cerrarMes(vehiculos, exportador, notificador);
        System.out.println(csv);
    }
}
