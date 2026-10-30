package dif_e_Integracion;

public class SimpsonCompuesto {
    // Calcula la aproximación de Simpson 1/3 compuesto para n par
    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0; // Puntos con coeficiente 4
        double sumaPares = 0.0;   // Puntos con coeficiente 2

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            if (k % 2 == 1) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }
        // Fórmula: h/3 [ f(a) + 4·sumaImpares + 2·sumaPares + f(b) ]
        double sumaTotal = TrapecioCompuesto.funcion(a) + 4 * sumaImpares + 2 * sumaPares + TrapecioCompuesto.funcion(b);
        return (h / 3) * sumaTotal;
    }

    // Bucle que aumenta n hasta cumplir tolerancia
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;
        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        return integralAnterior;
    }
}
