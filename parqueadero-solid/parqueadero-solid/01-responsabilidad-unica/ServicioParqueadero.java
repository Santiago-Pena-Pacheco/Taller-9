public interface ServicioParqueadero {
    void registrarMinutos(int minutos);
    double calcularSeguro();
    void solicitarLavados(int cantidad);
}
