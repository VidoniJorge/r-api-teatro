package ar.com.jlv.api.teatro;

import ar.com.jlv.api.teatro.modelo.Asiento;
import ar.com.jlv.api.teatro.service.CarritoService;
import ar.com.jlv.api.teatro.service.CarritoServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String arg[]) {
        CarritoService c = new CarritoServiceImpl("jorge");
        c.agregar(Asiento.builder().funcion(2).fila(1).numero(1).seccion(1).build());
        c.agregar(Asiento.builder().funcion(2).fila(1).numero(6).seccion(2).build());
        c.agregar(Asiento.builder().funcion(1).fila(1).numero(2).seccion(2).build());
        c.printAsientosYCosto();
        c.printAsientosDescuentosAplicados();
        c.printCostoTotal();
    }
}
