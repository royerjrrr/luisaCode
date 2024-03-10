package reto1;


import reto1.SchoolGradingSystem;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        Scanner lea = new Scanner(System.in);
        lea.useLocale(Locale.US);
        // Leer el número de estudiantes
        System.out.print("Ingrese el número de estudiantes: ");
        int numEstudiantes = lea.nextInt();
        lea.nextLine(); // Consumir la nueva línea después del entero
        
        // Instanciar el sistema de calificación
        SchoolGradingSystem schoolGradingSystem = new SchoolGradingSystem();
        
        // Leer los datos de cada estudiante
        for (int i = 0; i < numEstudiantes; i++) {
            try {
                //System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
                String input = lea.nextLine();
                String[] data = input.split(" ");

                String nombre = data[0];
                String genero = data[1];
                String materia = data[2];
                double nota;
                nota = Double.parseDouble(data[3]);
                // Almacenar los datos en el sistema de calificación
                schoolGradingSystem.loadData(nombre, genero, materia, nota);
            } catch (NumberFormatException e) {
                System.out.println("Error: La nota debe ser un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Obtener resultados

        double porcentajeAprobacion = schoolGradingSystem.stat1();

        int examenesRegulares = (int) schoolGradingSystem.stat2();

        //No delvuele nada
        String mejorEstudianteBiologia = schoolGradingSystem.stat4();
        //ARREGLAR LOGICA
        //String mejorMateriaFem = schoolGradingSystem.stat3();

        // Mostrar resultados
        System.out.println("Porcentaje de aprobación: " + porcentajeAprobacion + "%");
        System.out.println("Número de exámenes regulares: " + examenesRegulares);
        //System.out.println("Mejor materia con promedio femenino: " + mejorMateriaFem);
        System.out.println("Estudiante con mejor desempeño en Biología: " + mejorEstudianteBiologia);
        



    }
}