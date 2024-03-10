package reto1;

import java.util.*;

public class SchoolGradingSystem extends GradingSystem{

 // Constructor
    public SchoolGradingSystem() {
        
    }

    // Implementación del método para determinar la materia con el mejor desempeño promedio para el género femenino
    @Override
    public String stat3() {
        Map<String, Double> promedioMateriasFemenino = new HashMap<>();
        Map<String, Integer> contadorMateriasFemenino = new HashMap<>();
        
        Map<String, Integer> materias = this.getMaterias();
        
        // Si el mapa de materias es nulo, inicializarlo
        if(materias == null) {
            materias = new HashMap<>();
        }
        
        for (Map.Entry<String, Integer> entry : materias.entrySet()) {
                String materia = entry.getKey();
                promedioMateriasFemenino.put(materia, 0.0);
                contadorMateriasFemenino.put(materia, 0);
            }
        
        //Calcular la suma de las notas y el contador de cada materia para el género femenino
        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            String[] clave = entry.getKey().split(" ");
            String genero = clave[1];
            String materia = clave[2];
            Double nota = entry.getValue();

            if (genero.equals("1")) { // Si es género femenino
                promedioMateriasFemenino.put(materia, promedioMateriasFemenino.get(materia) + nota);
                contadorMateriasFemenino.put(materia, contadorMateriasFemenino.get(materia) + 1);
            }
        }

        // Calcular el promedio por materia para el género femenino
        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            String materia = entry.getKey();
            if (contadorMateriasFemenino.get(materia) != 0) {
                promedioMateriasFemenino.put(materia, promedioMateriasFemenino.get(materia) / contadorMateriasFemenino.get(materia));
            }
        }

        /// Encontrar la materia con el mejor promedio para el género femenino
        String mejorMateria = "";
        double mejorPromedio = 0.0;
        for (Map.Entry<String, Double> entry : promedioMateriasFemenino.entrySet()) {
            if (entry.getValue() > mejorPromedio) {
                mejorMateria = entry.getKey();
                mejorPromedio = entry.getValue();
            }
        }

        return mejorMateria;
    }

    // Implementación del método para encontrar al estudiante con el mejor desempeño en la materia de Biología
    @Override
    public String stat4() {
        String mejorEstudiante = "";
        double mejorNota = 0.0;

        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            String[] clave = entry.getKey().split(" ");
            String estudiante = clave[0];
            String materia = clave[2];
            Double nota = entry.getValue();

            if (materia.equalsIgnoreCase("1") && nota > mejorNota) { // Si es la materia de Biología y la nota es mejor
                mejorEstudiante = estudiante;
                mejorNota = nota;
            }
        }

        return mejorEstudiante;
    }
    
    // Método para cargar los datos de un estudiante
    public void loadData(String nombre, String genero, String materia, double nota) {
        // Formar la clave combinada de nombre + materia
        String key = nombre + " " + genero + " " + materia;
        // Almacenar la nota en el mapa de notas
        notas.put(key, nota);
    }
}