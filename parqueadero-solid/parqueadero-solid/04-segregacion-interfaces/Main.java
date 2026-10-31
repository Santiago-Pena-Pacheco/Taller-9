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

        for (Vehiculo v : vehiculos) {
            if (v instanceof Fidelizable) {
                Fidelizable f = (Fidelizable) v;
                System.out.println("Puntos de " + v.getPlaca() + ": " + f.calcularPuntos());
            }
        }

        // Paso 4 (ISP): el casillero se usa solo como Cronometrable; no necesita seguro ni lavado.
        Casillero casillero = new Casillero("CAS-01", "Camila Rojas", 20); // Paso 4 (ISP)
        Cronometrable c = casillero;                                       // Paso 4 (ISP)
        c.registrarMinutos(90);                                            // Paso 4 (ISP)
        System.out.println("Alquiler casillero CAS-01: $" + String.format("%,.0f", casillero.valorAlquiler())); // Paso 4 (ISP)
    }
}
