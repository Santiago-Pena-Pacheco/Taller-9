// Paso 5 (DIP): abstracción de la que depende el gestor. Los detalles (MySQL, memoria) la implementan.
public interface RepositorioCobros {
    void insertar(String placa, double cobro);
}
