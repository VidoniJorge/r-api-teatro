package ar.com.jlv.api.teatro.modelo;

import ar.com.jlv.api.teatro.modelo.Fila;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seccion {
    private Integer id;
    private String nombre;
    private Double precio;
    private List<Fila> filas;

    public Double getCostoAsiento(Integer filaId){
        return buscarFila(filaId).map(s -> s.getModificadorPrecio() * precio).orElseThrow(RuntimeException::new);
    }

    private Optional<Fila> buscarFila(final Integer id) {
        return this.filas.stream().filter(fila -> fila.getNumero().equals(id)).findFirst();
    }
}
