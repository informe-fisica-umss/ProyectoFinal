# Datos:
Apellidos: Rivero Chappy
Nombre: Miguel Angel
Codigo sis: 202412494
Grupo: 1

# Informe: Unittest con JUnit para Análisis de Física

## 1. Teoría de Unittest (JUnit)

### ¿Qué es Unittest?
Unittest es una metodología de pruebas de software donde se verifican unidades individuales de código (métodos, funciones) para asegurar que funcionan correctamente. En Java, esto se implementa con *JUnit*.

### ¿Por qué usar Unittest?
- *Detección temprana de errores* en cálculos científicos
- *Verificación automática* de resultados esperados
- *Documentación ejecutable* del comportamiento del código
- *Facilita refactorización* sin romper funcionalidad existente
- *Validación de métodos* matemáticos y físicos

### ¿Cuándo usar Unittest?
-  Al implementar nuevos cálculos físicos
-  Después de modificar algoritmos existentes
-  Para verificar fórmulas matemáticas complejas
-  En análisis de datos experimentales
-  Antes de realizar entregas o informes

## 2. Código de Ejemplo

### Clase principal: CalculosFisica.java

public class CalculosFisica {
    
    public static double calcularVelocidad(double distancia, double tiempo) {
        if (tiempo <= 0) {
            throw new IllegalArgumentException("El tiempo debe ser mayor a cero");
        }
        return distancia / tiempo;
    }
    
    public static double calcularTiempoCaidaLibre(double altura, double gravedad) {
        if (altura < 0 || gravedad <= 0) {
            throw new IllegalArgumentException("Altura y gravedad deben ser positivas");
        }
        return Math.sqrt(2 * altura / gravedad);
    }
    
    public static double calcularEnergiaCinetica(double masa, double velocidad) {
        if (masa < 0) {
            throw new IllegalArgumentException("La masa no puede ser negativa");
        }
        return 0.5 * masa * Math.pow(velocidad, 2);
    }
    
    public static double calcularPromedio(double[] mediciones) {
        if (mediciones == null || mediciones.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        
        double suma = 0;
        for (double valor : mediciones) {
            suma += valor;
        }
        return suma / mediciones.length;
    }
    
    public static double calcularDesviacionEstandar(double[] mediciones) {
        if (mediciones == null || mediciones.length < 2) {
            throw new IllegalArgumentException("Se necesitan al menos 2 mediciones");
        }
        
        double promedio = calcularPromedio(mediciones);
        double sumaDiferencias = 0;
        
        for (double valor : mediciones) {
            sumaDiferencias += Math.pow(valor - promedio, 2);
        }
        
        return Math.sqrt(sumaDiferencias / (mediciones.length - 1));
    }
}

### Clase de prueba

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculosFisica {
    
    @Test
    @DisplayName("Cálculo correcto de velocidad promedio")
    void testCalcularVelocidad() {
        // Datos de prueba
        double distancia = 100.0;  
        double tiempo = 20.0;      
        
        double resultado = CalculosFisica.calcularVelocidad(distancia, tiempo);
        
        assertEquals(5.0, resultado, 0.001, "La velocidad debería ser 5 m/s");
    }
    
    @Test
    @DisplayName("Cálculo de tiempo en caída libre")
    void testCalcularTiempoCaidaLibre() {
        double altura = 19.6;  
        double gravedad = 9.8;  
        
        double resultado = CalculosFisica.calcularTiempoCaidaLibre(altura, gravedad);
        
        assertEquals(2.0, resultado, 0.1, "El tiempo de caída debería ser 2 segundos");
    }
    
    @Test
    @DisplayName("Cálculo de energía cinética")
    void testCalcularEnergiaCinetica() {
        double masa = 2.0;     // kg
        double velocidad = 3.0; // m/s
        
        double resultado = CalculosFisica.calcularEnergiaCinetica(masa, velocidad);
        
        assertEquals(9.0, resultado, 0.001, "La energía cinética debería ser 9 julios");
    }
    
    @Test
    @DisplayName("Cálculo de promedio de mediciones")
    void testCalcularPromedio() {
        double[] mediciones = {5.1, 5.2, 5.3, 5.0, 5.4};
        
        double resultado = CalculosFisica.calcularPromedio(mediciones);
        
        assertEquals(5.2, resultado, 0.001, "El promedio debería ser 5.2");
    }
    
    @Test
    @DisplayName("Cálculo de desviación estándar")
    void testCalcularDesviacionEstandar() {
        double[] mediciones = {5.1, 5.2, 5.3, 5.0, 5.4};
        
        double resultado = CalculosFisica.calcularDesviacionEstandar(mediciones);
        
        // Valor aproximado de desviación estándar
        assertEquals(0.158, resultado, 0.01, "La desviación estándar debería ser aproximadamente 0.158");
    }
    
    @Test
    @DisplayName("Verificar excepción con tiempo cero")
    void testTiempoCeroLanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculosFisica.calcularVelocidad(100.0, 0.0);
        });
        
        assertTrue(exception.getMessage().contains("mayor a cero"));
    }
    
    @Test
    @DisplayName("Verificar excepción con masa negativa")
    void testMasaNegativaLanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculosFisica.calcularEnergiaCinetica(-2.0, 3.0);
        });
        
        assertTrue(exception.getMessage().contains("no puede ser negativa"));
    }
}

## Como usar el codigo
### Configuracion con maven

Agregar en el pom.xml:

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
Ejecucion de prueba

# Ejecutar todas las pruebas
mvn test

# Ejecutar solo pruebas específicas
mvn test -Dtest=TestCalculosFisica

# Ver reporte detallado
mvn test -Dmaven.test.failure.ignore=false

## Resultados 
 
Valor medio de tiempo:

double[] tiempos = {5.1, 5.2, 5.3, 5.0, 5.4};
double valorMedio = CalculosFisica.calcularPromedio(tiempos);
// Resultado: valorMedio = 5.2

Desviacion estandar de tiempo:

double desviacion = CalculosFisica.calcularDesviacionEstandar(tiempos);
// Resultado: desviacion ≈ 0.158

Valor final reportado:

t = (5.2 ± 0.1) [s]

## Observaciones extras

Ventajas encontradas:

· Verificación automática de cálculos complejos
· Detección inmediata de errores en fórmulas
· Confianza en resultados numéricos
· Documentación viva de los métodos implementados

Dificultades:

· Configuración inicial de Maven y JUnit requiere atención
· Definición de tolerancias apropiadas para comparaciones decimales
· Manejo de casos límite (valores negativos, cero, etc.)

## Recomendaciones:

1. Escribir pruebas primero (metodología TDD)
2. Probar con datos reales del laboratorio
3. Incluir pruebas de valores límite
4. Ejecutar pruebas antes de cada commit
5. Usar nombres descriptivos en los métodos de prueba