package ar.com.jlv.api.teatro.service;

import ar.com.jlv.api.teatro.modelo.Asiento;

public interface CarritoService {
    void agregar(final Asiento asiento);
    void printAsientosYCosto();
    void printAsientosDescuentosAplicados();
    void printCostoTotal();
}
