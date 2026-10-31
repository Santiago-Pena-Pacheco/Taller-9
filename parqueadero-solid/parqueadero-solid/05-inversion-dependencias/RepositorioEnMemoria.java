import java.util.ArrayList;
import java.util.List;

// Paso 5 (DIP): implementación para probar sin base de datos.
public class RepositorioEnMemoria implements RepositorioCobros {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void insertar(String placa, double cobro) {
        registros.add(placa + " -> " + cobro);
    }

    public List<String> getRegistros() { return registros; }
}
