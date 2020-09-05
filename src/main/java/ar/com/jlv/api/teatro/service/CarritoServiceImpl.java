package ar.com.jlv.api.teatro.service;

import ar.com.jlv.api.teatro.modelo.*;
import ar.com.jlv.api.teatro.modelo.descuentos.Descuento;
import ar.com.jlv.api.teatro.modelo.Seccion;
import ar.com.jlv.api.teatro.repositories.FuncionResitory;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarritoServiceImpl implements CarritoService{
    private String nameCliente;
    private List<Asiento> asientos;
    private FuncionResitory funcionResitory;

    public CarritoServiceImpl(final String nameCliente) {
        this.nameCliente = nameCliente;
        this.asientos = new ArrayList<>();
        this.funcionResitory = new FuncionResitory();
    }

    public void agregar(final Asiento asiento) {
        if (!buscarAsiento(asiento).isPresent()) {
            asiento.setFechaReserva(LocalDateTime.now());
            asiento.setFechaFunsion(this.buscarFuncion(asiento).getFechaFuncion());
            asiento.setConsto(this.calcularCostoAsiento(asiento));
            asiento.setDescuentos(this.buscarDescuntos(asiento));
            asientos.add(asiento);
        }
    }

    private Optional<Asiento> buscarAsiento(final Asiento asiento) {
        return asientos.stream().filter(a -> asiento.equals(a)).findAny();
    }

    private Double calcularCostoAsiento(final Asiento asiento) {
        return this.buscarSeccion(asiento)
                .map(s -> s.getCostoAsiento(asiento.getFila()))
                .orElseThrow(RuntimeException::new);
    }

    private Optional<Seccion> buscarSeccion(final Asiento asiento) {
        return this.buscarFuncion(asiento).getSecciones().stream()
                .filter(seccion -> seccion.getId().equals(asiento.getSeccion())).findFirst();
    }

    private List<Descuento> buscarDescuntos(final Asiento asiento) {
        return buscarFuncion(asiento).getDescuentos().stream().filter(descuento -> descuento.aplicaDescuento(asiento))
                .collect(Collectors.toList());
    }

    private Funcion buscarFuncion(final Asiento asiento) {
        return this.funcionResitory.buscar(asiento.getFuncion()).orElseThrow(RuntimeException::new);
    }

    public void printAsientosYCosto() {
        this.printLineas();
        System.out.println("Lista de los asientos reservados y su costo");
        this.asientos.stream().forEach(asiento ->
                System.out.println(String.format("\tEl Asiento %d de la fila %d  de la funsion: %d  tiene un consto de $%s"
                        , asiento.getNumero()
                        , asiento.getFila()
                        , asiento.getFuncion()
                        , asiento.getConstoFinal()))
        );
    }

    public void printAsientosDescuentosAplicados() {
        this.printLineas();
        System.out.println("Lista de los asientos reservados y los descuentos aplicados");
        this.asientos.stream().forEach(asiento ->
                System.out.println(String.format
                        ("\tAl Asiento %d de la fila %d  de la funsion: %d  se le aplican los siguientes descuentos $%s"
                                , asiento.getNumero()
                                , asiento.getFila()
                                , asiento.getFuncion()
                                , asiento.getDescuentos()))
        );
    }

    public void printCostoTotal() {
        this.printLineas();
        System.out.println("Consto total de la reserva");
        Double costo = this.asientos.stream()
                .mapToDouble(asiento -> asiento.getConstoFinal())
                .sum();
        System.out.println(String.format("\tEl usuario %s lleva gastado %s", this.nameCliente, costo));
    }

    private void printLineas() {
        System.out.println("***************");
        System.out.println("***************");
        System.out.println("***************");
    }
}
