package reto1;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public abstract class GradingSystem {
    
    // Mapas para identificar nombres, materias y géneros
    protected Map<String, Double> notas = new HashMap<>();
    protected Map<String, Integer> nombres = new HashMap<>();
    protected Map<String, Integer> materias = new HashMap<>();
    protected Map<String, Integer> generos = new HashMap<>();

    public GradingSystem() {
        // Inicialización de los mapas con los identificadores correspondientes
        nombres.put("armando", 1);
        nombres.put("nicolas", 2);
        nombres.put("daniel", 3);
        nombres.put("maria", 4);
        nombres.put("marcela", 5);
        nombres.put("alexandra", 6);

        materias.put("biologia", 1);
        materias.put("geografia", 2);
        materias.put("matematicas", 3);

        generos.put("m", 0);
        generos.put("f", 1);
    }
    
    public Map<String, Integer> getMaterias() {
        return materias;
    }

    // Métodos para obtener los identificadores
    public int obtenerIdNombre(String nombre) {
        return nombres.getOrDefault(nombre, -1);
    }

    public int obtenerIdMateria(String materia) {
        return materias.getOrDefault(materia, -1);
    }

    public int obtenerIdGenero(String genero) {
        return generos.getOrDefault(genero, -1);
    }

    //ESTA BUENO
   public double stat1(){
       if (notas.isEmpty()) {
            return 0.0;
        }

        int totalEstudiantes = notas.size();
        int aprobados = 0;

        for (Double nota : notas.values()) {
            if (nota >= 60.0) {
                aprobados++;
            }
        }

        return (double) aprobados / totalEstudiantes * 100;
   }
   
   public double stat2(){
       int regulares = 0;

        for (Double nota : notas.values()) {
            // CAMBIEN EL !! POR EL &&, BASICAMENTE ES SI NOTA ES >= A 60 Y <= 80 CUMPLE LA FUNCIO
            if (nota >= 60.0 && nota <= 80.0) {
                regulares++;
            }
        }

        return regulares;
   }
   
   public boolean generoValido(String genero) {
    return generos.containsKey(genero);
  }
   
   public boolean materiaValida(String materia) {
    return materias.containsKey(materia);
  }

   // Método abstracto para determinar la materia con el mejor desempeño promedio para el género femenino
    public abstract String stat3();
    
    // Método abstracto para encontrar al estudiante con el mejor desempeño en la materia de Biología
    public abstract String stat4();
}   