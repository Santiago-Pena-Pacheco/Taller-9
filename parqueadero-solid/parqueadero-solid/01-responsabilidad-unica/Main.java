import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("KLM321", "Camila Rojas", "MENSUAL", 180000, 0, 0));
        vehiculos.add(new Vehiculo("XYZ45F", "Andrés Mora", "MINUTOS", 0, 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));

        GestorParqueadero gestor = new GestorParqueadero();
        ExportadorCSV exportador = new ExportadorCSV();       // Paso 1 (SRP)
        NotificadorSMS notificador = new NotificadorSMS();    // Paso 1 (SRP)

        String csv = gestor.cerrarMes(vehiculos, exportador, notificador); // Paso 1 (SRP)
        System.out.println(csv);                                           // Paso 1 (SRP)
    }
}
