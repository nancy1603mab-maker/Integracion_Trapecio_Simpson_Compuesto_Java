// Importa las clases del paquete
import dif_e_Integracion.TrapecioCompuesto;
import dif_e_Integracion.SimpsonCompuesto;

public class MainCompuesto {
    public static void main(String[] args) {
        double a = 0;       // Límite inferior de integración
        double b = 2;       // Límite superior
        double tol = 0.0001;// Tolerancia de error

        // Ejecuta el método del trapecio compuesto
        double resTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tol);
        // Ejecuta Simpson 1/3 compuesto
        double resSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tol);

        System.out.println("Resultado Trapecio Compuesto: " + resTrapecio);
        System.out.println("Resultado Simpson 1/3 Compuesto: " + resSimpson);
        System.out.println("Valor exacto (8/3): " + 8.0 / 3.0);
    }
}