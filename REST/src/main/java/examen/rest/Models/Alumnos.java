package examen.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Alumnos {
    private int id;
    private String nombre;
    private String fct;
}
