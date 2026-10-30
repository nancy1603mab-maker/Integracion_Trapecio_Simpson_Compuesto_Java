
package dif_e_Integracion;

public class TrapecioCompuesto {
    // Define la función que vamos a integrar: f(x)=x²
    public static double funcion(double x) {
        return x * x;
    }

    // Calcula el ancho h de cada subintervalo
    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    // Cálculo de la integral por regla del trapecio compuesto
    public static double trapecioCompuesto(double a, double b, int n) {
        double h = calcularH(a, b, n);
        // Suma empieza con los valores en los extremos a y b
        double suma = funcion(a) + funcion(b);
        // Recorre los puntos internos
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            suma += 2 * funcion(xk); // Puntos internos llevan coeficiente 2
        }
        return (h / 2) * suma;
    }

    // Repite aumentando n hasta cumplir la tolerancia de error
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnt = trapecioCompuesto(a, b, n);
        double error = 999.0; // Valor inicial grande
        while (error > tolerancia) {
            n *= 2; // Duplica los subintervalos
            double integralNueva = trapecioCompuesto(a, b, n);
            error = Math.abs(integralNueva - integralAnt);
            integralAnt = integralNueva;
        }
        return integralAnt;
    }
}
