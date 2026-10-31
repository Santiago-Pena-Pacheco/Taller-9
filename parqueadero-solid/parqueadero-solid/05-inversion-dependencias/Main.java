import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DEF98G", "Laura Pardo", 25000, 3));

        ExportadorCSV exportador = new ExportadorCSV();
        NotificadorSMS notificador = new NotificadorSMS();

        // Paso 5 (DIP): producción, con la "base de datos" MySQL inyectada.
        GestorParqueadero gestor = new GestorParqueadero(new RepositorioMySQL()); // Paso 5 (DIP)
        String csv = gestor.cerrarMes(vehiculos, exportador, notificador);
        System.out.println(csv);

        for (Vehiculo v : vehiculos) {
            if (v instanceof Fidelizable) {
                Fidelizable f = (Fidelizable) v;
                System.out.println("Puntos de " + v.getPlaca() + ": " + f.calcularPuntos());
            }
        }

        Casillero casillero = new Casillero("CAS-01", "Camila Rojas", 20);
        Cronometrable c = casillero;
        c.registrarMinutos(90);
        System.out.println("Alquiler casillero CAS-01: $" + String.format("%,.0f", casillero.valorAlquiler()));

        // Paso 5 (DIP): prueba sin base de datos, con el repositorio en memoria.
        System.out.println("\n--- Prueba sin base de datos ---");                          // Paso 5 (DIP)
        RepositorioEnMemoria memoria = new RepositorioEnMemoria();                          // Paso 5 (DIP)
        GestorParqueadero gestorDePrueba = new GestorParqueadero(memoria);                  // Paso 5 (DIP)
        gestorDePrueba.cerrarMes(vehiculos, exportador, notificador);                       // Paso 5 (DIP)
        System.out.println("Registros guardados en memoria: " + memoria.getRegistros());   // Paso 5 (DIP)
    }
}
