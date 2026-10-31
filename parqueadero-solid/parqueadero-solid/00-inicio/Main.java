import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("KLM321", "Camila Rojas", "MENSUAL", 180000, 0, 0));
        vehiculos.add(new Vehiculo("XYZ45F", "Andrés Mora", "MINUTOS", 0, 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));

        GestorParqueadero gestor = new GestorParqueadero();
        for (Vehiculo v : vehiculos) {
            double cobro = gestor.calcularCobro(v);
            gestor.guardar(v, cobro);
            gestor.enviarRecibo(v, cobro);
        }
        System.out.println(gestor.exportarCSV(vehiculos));
    }
}
