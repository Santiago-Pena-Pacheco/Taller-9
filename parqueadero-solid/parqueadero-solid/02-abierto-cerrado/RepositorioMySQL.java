// Simula una conexión a MySQL: imprime la sentencia en lugar de ejecutarla.
public class RepositorioMySQL {

    public RepositorioMySQL() {
        System.out.println("[MySQL] Conectando a jdbc:mysql://servidor/parqueadero ...");
    }

    public void insertar(String placa, double cobro) {
        System.out.println("[MySQL] INSERT INTO cobros VALUES ('" + placa + "', " + cobro + ")");
    }
}
