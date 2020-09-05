package ar.com.jlv.api.teatro.modelo;


import ar.com.jlv.api.teatro.modelo.descuentos.Descuento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Funcion {
    private Integer id;
    private String nombre;
    private List<Seccion> secciones;
    private LocalDate fechaFuncion;
    private List<Descuento> descuentos;

    public Funcion(){
        this.secciones = new ArrayList<>();
        this.descuentos = new ArrayList<>();
    }

    public void reservaAsiento(final Integer seccionId, final Integer filaId, final Integer asientoId) {
       //TODO Agregar la logica de la reserva
    }

    public List<Seccion> getSecciones(){
        return this.secciones;
    }
}
