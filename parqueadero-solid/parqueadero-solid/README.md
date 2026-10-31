# Taller 9: Principios SOLID paso a paso

Universidad Libre · Facultad de Ingeniería · Programación 1 · Docente: Andrés Castaño

Proyecto **ParqueaderoSOLID**: cobro mensual de un parqueadero con mensualistas, vehículos por minutos, bicicletas y casilleros para cascos. Cada carpeta es una versión ejecutable del proyecto; se parte de `00-inicio` (que viola los cinco principios a propósito) y en cada paso se copia la carpeta anterior y se aplica un principio. Las líneas modificadas llevan un comentario que empieza con `// Paso`.

Para compilar y ejecutar cualquier carpeta:

```bash
cd 01-responsabilidad-unica
javac *.java && java Main
```

## Resumen de cambios

| Carpeta | Principio | Problema que tenía | Qué cambió |
|---|---|---|---|
| `00-inicio` | — | Viola los cinco principios | Punto de partida. |
| `01-responsabilidad-unica` | **S**: responsabilidad única | `GestorParqueadero` calculaba, guardaba, exportaba CSV y enviaba SMS | Nuevas clases `ExportadorCSV` y `NotificadorSMS`. El gestor conserva el cálculo y coordina con `cerrarMes(...)`. |
| `02-abierto-cerrado` | **O**: abierto/cerrado | `switch` sobre `tipo` en el gestor: cada modelo de cobro nuevo obligaba a editarlo | `Vehiculo` pasa a ser abstracta con `calcularCobro()`. Subclases `VehiculoMensual` y `VehiculoPorMinutos`. El gestor ya no tiene `switch`. Se demuestra con `VehiculoPorDia`, que no modifica ninguna clase del dominio (solo se agrega una línea en `Main` para usarla). |
| `03-sustitucion-liskov` | **L**: sustitución de Liskov | `Bicicleta` heredaba `calcularPuntos()` y lanzaba `UnsupportedOperationException` | `calcularPuntos()` sale de `Vehiculo` y pasa a la interfaz `Fidelizable`, que solo implementa `VehiculoMensual`. `Bicicleta` extiende `Vehiculo` directamente, sin prometer puntos. |
| `04-segregacion-interfaces` | **I**: segregación de interfaces | `ServicioParqueadero` obligaba a `Casillero` a escribir métodos vacíos | Se elimina `ServicioParqueadero` y se divide en `Cronometrable`, `Asegurable` y `Lavable`. `Vehiculo` implementa las tres; `Casillero` solo `Cronometrable`. |
| `05-inversion-dependencias` | **D**: inversión de dependencias | `GestorParqueadero` hacía `new RepositorioMySQL()` | Nueva interfaz `RepositorioCobros`, implementada por `RepositorioMySQL` y por el nuevo `RepositorioEnMemoria`. El gestor la recibe por constructor, y `Main` prueba sin base de datos. |

## Comportamiento verificado

En cada paso el cobro de los tres vehículos originales se mantiene igual (KLM321 → 180.000, XYZ45F → 120.000, BIC-07 → 40.000). Desde el paso 2 también se cobra `DEF98G` (por día, 3 × 25.000 = 75.000).
