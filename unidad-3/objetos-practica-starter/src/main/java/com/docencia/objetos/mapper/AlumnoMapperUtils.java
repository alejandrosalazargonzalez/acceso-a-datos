package com.docencia.objetos.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;

public class AlumnoMapperUtils {

    /**
     * funcion que transaforma un objeto de tipo alumnoEntity a alumno
     * @param alumnoEntity de entrada
     * @return alumno transaformado
     */
    public static Alumno to(AlumnoEntity alumnoEntity){
        if (alumnoEntity == null) {
            return null;
        }
        Alumno alumno = new Alumno(alumnoEntity.getId(),alumnoEntity.getNombre(),alumnoEntity.getEmail(),alumnoEntity.getCiclo());
        return alumno;
    }

        public static AlumnoEntity to(Alumno alumno){
        if (alumno == null) {
            return null;
        }
        AlumnoEntity alumnoEntity = new AlumnoEntity(alumno.getId(),alumno.getNombre(),alumno.getEmail(),alumno.getCiclo());
        return alumnoEntity;
    }

    /**
     * funcion que transaforma una lista de tipo alumnoEntity a alumno
     * @param alumnoEntity de entrada
     * @return alumno transaformado
     */
    public static List<Alumno> to(List<AlumnoEntity> alumnosEntity){
        List<Alumno> alumnos = new ArrayList<>();
        if (alumnosEntity == null || alumnosEntity.isEmpty()) {
            return alumnos;
        }
        for (AlumnoEntity alumnoEntity : alumnosEntity) {
            alumnos.add(to(alumnoEntity));
        }
        return alumnos;
    }

    public static Optional<Alumno> to(Optional<AlumnoEntity> alumnoEntity) {
        Optional<Alumno> resultado = java.util.Optional.empty();
        if (alumnoEntity == null || alumnoEntity.isEmpty()) {
            return resultado;
        }
        return resultado.map(alumno -> to(alumnoEntity).orElse(null));
    }
}
