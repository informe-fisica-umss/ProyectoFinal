# Datos
Apellidos: Rivero Chappy
Nombre: Miguel Angel
Codigo sis: 202412494
Grupo: 1
# 1. Objetivo

Explicar y simular, con un pequeño programa en Java, el movimiento parabólico (lanzamiento de un proyectil sin resistencia del aire) y mostrar resultados numéricos (posición y velocidad) paso a paso. Además se muestra cómo ejecutar el programa en VSCode y un ejemplo básico de CI.yml para automatizar la compilación.

# Breve teoría

El movimiento parabólico se puede descomponer en dos movimientos independientes:

Movimiento horizontal uniforme (aceleración horizontal = 0):

Movimiento vertical con aceleración constante (gravedad):

Donde:

 = velocidad inicial,

 = ángulo de lanzamiento (en radianes),

 ≈ 9.81 m/s² (aceleración de la gravedad hacia abajo),

 = tiempo.


El tiempo de vuelo hasta que el proyectil vuelve a la altura inicial (y = 0) sin elevación inicial es: 

El alcance horizontal (distancia recorrida en x) es:

# Pequeño programa en Java (simulación)

Guarda este archivo como Proyectil.java dentro de una carpeta src (o en el root si prefieres).

// Proyectil.java
public class Proyectil {
    // gravedad en m/s^2
    static final double g = 9.81;

    public static void main(String[] args) {
        // Parámetros iniciales (puedes cambiarlos)
        double v0 = 30.0;          // velocidad inicial en m/s
        double thetaDeg = 45.0;    // ángulo en grados
        double dt = 0.1;           // paso temporal en segundos

        double theta = Math.toRadians(thetaDeg);
        double v0x = v0 * Math.cos(theta);
        double v0y = v0 * Math.sin(theta);

        // Tiempo total aproximado de vuelo
        double tVuelo = 2 * v0y / g;

        System.out.printf("Simulación de proyectil: v0=%.2f m/s, θ=%.1f°\n", v0, thetaDeg);
        System.out.printf("Tiempo de vuelo estimado: %.3f s\n", tVuelo);
        System.out.println("t (s)   x (m)    y (m)    vx (m/s)  vy (m/s)");

        for (double t = 0.0; t <= tVuelo + 1e-9; t += dt) {
            double x = v0x * t;
            double y = v0y * t - 0.5 * g * t * t;
            double vx = v0x;
            double vy = v0y - g * t;
            if (y < 0) y = 0; // no mostrar y negativa bajo el suelo

            System.out.printf("%.2f   %7.3f   %7.3f   %7.3f   %7.3f\n", t, x, y, vx, vy);
            if (y == 0 && t > 0.0) break; // termina cuando vuelve al suelo
        }

        // Alcance teórico:
        double alcance = (v0 * v0 * Math.sin(2 * theta)) / g;
        System.out.printf("Alcance teórico: %.3f m\n", alcance);
    }
}
# Explicación del código (línea por línea — resumen)

g: constante de gravedad.

Parámetros v0, thetaDeg, dt: velocidad inicial, ángulo en grados y paso temporal para la simulación.

Conversión theta = Math.toRadians(thetaDeg) para usar cos y sin en radianes.

v0x, v0y: componentes iniciales de la velocidad.

tVuelo: tiempo total estimado de vuelo usando .

Bucle for desde t = 0 hasta tVuelo con paso dt:

Calcula posición x(t) y y(t).

Calcula velocidades en los ejes: vx (constante) y vy (cambia por gravedad).

Si y < 0, se ajusta a 0 para no mostrar valores negativos que representen estar "bajo el suelo".

Se imprime una línea con t, x, y, vx, vy.

Si el proyectil regresó al suelo (y == 0 y t>0), rompe el bucle.


Al final se imprime el alcance teórico usando la fórmula .

# 5. Cómo ejecutar en VSCode (pasos)

1. Abre VSCode en la carpeta del proyecto (donde esté Proyectil.java).


2. Asegúrate de tener instalado Java JDK (11+ recomendado) y la extensión Extension Pack for Java o al menos Language Support for Java.


3. Estructura mínima:

Proyectil.java (en la raíz)
o

src/Proyectil.java (si usas una estructura con paquete, ajustar compilación).



4. Compilar desde una terminal integrada:

javac Proyectil.java



5. Ejecutar:

java Proyectil


6. Si usas src y paquetes, compilar con javac src/Proyectil.java y ejecutar java -cp src Proyectil.


7. Alternativa: crea una configuración de Run en .vscode/launch.json usando el asistente de la extensión Java para ejecutar fácilmente con F5.

# 6. Ejemplo de salida esperada (captura aproximada)

Al ejecutar con v0 = 30 m/s y θ = 45° y dt = 0.1 verás algo así:

Simulación de proyectil: v0=30.00 m/s, θ=45.0°
Tiempo de vuelo estimado: 4.328 s
t (s)   x (m)    y (m)    vx (m/s)  vy (m/s)
0.00     0.000   0.000   21.213   21.213
0.10     2.121   1.962   21.213   20.232
0.20     4.243   3.804   21.213   19.251
...
4.30    91.923   0.000   21.213   -20.970
Alcance teórico: 91.923 m
