// Simula una conexión a MySQL: imprime la sentencia en lugar de ejecutarla.
public class RepositorioMySQL implements RepositorioCobros { // Paso 5 (DIP)

    public RepositorioMySQL() {
        System.out.println("[MySQL] Conectando a jdbc:mysql://servidor/parqueadero ...");
    }

    @Override // Paso 5 (DIP)
    public void insertar(String placa, double cobro) {
        System.out.println("[MySQL] INSERT INTO cobros VALUES ('" + placa + "', " + cobro + ")");
    }
}
