package ar.com.jlv.api.teatro.repositories;

import ar.com.jlv.api.teatro.modelo.*;
import ar.com.jlv.api.teatro.modelo.descuentos.Descuento;
import ar.com.jlv.api.teatro.modelo.descuentos.DescuentoDiaSemana;
import ar.com.jlv.api.teatro.modelo.descuentos.DescuentoUltimaMilla;
import ar.com.jlv.api.teatro.modelo.Seccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionResitory {

    private List<Funcion> funciones;

    public FuncionResitory() {
        List<Descuento> descuentos = new ArrayList<>();
        descuentos.add(new DescuentoDiaSemana());
        descuentos.add(new DescuentoUltimaMilla());

        List<Fila> filas = new ArrayList<>();
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(1).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(2).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(3).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(4).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(5).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(6).build());
        filas.add(Fila.builder().Cantidad(2).modificadorPrecio(1.0).numero(7).build());
        List<Seccion> secciones = new ArrayList<>();
        secciones.add(Seccion.builder().id(1).nombre("Platea").precio(20.0).filas(filas).build());
        secciones.add(Seccion.builder().id(2).nombre("Cazuela").precio(40.0).filas(filas).build());

        this.funciones = new ArrayList<>();
        this.funciones.add(Funcion.builder().id(1).fechaFuncion(LocalDate.now()).secciones(secciones).descuentos(descuentos).build());
        this.funciones.add(Funcion.builder().id(2).fechaFuncion(LocalDate.now()).secciones(secciones).descuentos(descuentos).build());
    }

    public Optional<Funcion> buscar(final Integer id) {
        return this.funciones.stream().filter(fun->fun.getId().equals(id)).findAny();
    }
}
