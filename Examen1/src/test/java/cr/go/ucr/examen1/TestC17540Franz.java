package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Franz Sivaja Sanchez - C17540
 */
public class TestC17540Franz {

    /**
     * Prueba para el método `calcular` utilizando particionamiento equivalente.
     * Casos válidos e inválidos.
     */
    @Test
    public void testCalcular_ValidRange1() {
        Double montoVentaMensual = 1000.0; // Clase válida
        Double expected = 1000.0 * 0.03; // 3% de comisión
        Double result = ComisionVenta.getCurrentInstance().calcular(montoVentaMensual);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcular_ValidRange2() {
        Double montoVentaMensual = 3000.0; // Clase válida
        Double expected = 3000.0 * 0.07; // 7% de comisión
        Double result = ComisionVenta.getCurrentInstance().calcular(montoVentaMensual);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcular_InvalidNegativeValue() {
        Double montoVentaMensual = -10.0; // Clase inválida
        Double expected = -1.0; // Retorno esperado
        Double result = ComisionVenta.getCurrentInstance().calcular(montoVentaMensual);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcular_InvalidExceedsMaxValue() {
        Double montoVentaMensual = 150000.0; // Clase inválida
        Double expected = -1.0; // Retorno esperado
        Double result = ComisionVenta.getCurrentInstance().calcular(montoVentaMensual);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcular_ValidRange3() {
        Double montoVentaMensual = 10000.0; // Clase válida
        Double expected = 10000.0 * 0.12; // 12% de comisión
        Double result = ComisionVenta.getCurrentInstance().calcular(montoVentaMensual);
        assertEquals(expected, result);
    }

    /**
     * Prueba para el método `getCurrentInstance` para verificar que devuelve la misma instancia.
     */
    @Test
    public void testGetCurrentInstance() {
        ComisionVenta instance1 = ComisionVenta.getCurrentInstance();
        ComisionVenta instance2 = ComisionVenta.getCurrentInstance();
        assertSame(instance1, instance2); // Verifica que es la misma instancia (singleton)
    }

    /**
     * Prueba para el método `calcular` con cobertura total de caminos (caja blanca).
     */
    @Test
    public void testCalcular_FullCoverage() {
        // Clase válida (primer rango)
        Double montoVentaMensual1 = 1000.0;
        Double expected1 = 1000.0 * 0.03;
        assertEquals(expected1, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual1));

        // Clase válida (segundo rango)
        Double montoVentaMensual2 = 3000.0;
        Double expected2 = 3000.0 * 0.07;
        assertEquals(expected2, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual2));

        // Clase válida (tercer rango)
        Double montoVentaMensual3 = 10000.0;
        Double expected3 = 10000.0 * 0.12;
        assertEquals(expected3, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual3));

        // Clase válida (cuarto rango)
        Double montoVentaMensual4 = 20000.0;
        Double expected4 = 20000.0 * 0.15;
        assertEquals(expected4, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual4));

        // Clase inválida (valor negativo)
        Double montoVentaMensual5 = -100.0;
        assertEquals(-1.0, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual5));

        // Clase inválida (valor mayor al rango máximo)
        Double montoVentaMensual6 = 150000.0;
        assertEquals(-1.0, ComisionVenta.getCurrentInstance().calcular(montoVentaMensual6));
    }
}
