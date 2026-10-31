// Paso 1 (SRP): clase nueva. Su única razón de cambio es el mensaje/canal de notificación.
public class NotificadorSMS {

    public void enviarRecibo(Vehiculo v, double cobro) {
        System.out.println(
            "SMS a " + v.getPropietario()
            + " | Placa " + v.getPlaca()
            + ": su cobro de este mes es $"
            + String.format("%,.0f", cobro)
        );
    }
}
