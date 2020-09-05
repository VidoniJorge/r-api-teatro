package ar.com.jlv.api.teatro.modelo;

import ar.com.jlv.api.teatro.modelo.descuentos.Descuento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {
    private Integer funcion;
    private Integer numero;
    private Integer fila;
    private Integer seccion;
    private Double consto;
    private List<Descuento> descuentos;
    private LocalDateTime fechaReserva;
    private LocalDate fechaFunsion;
    private Double costofinal;

    public Double getConstoFinal(){
        if(Objects.isNull(this.costofinal)) {
            this.costofinal = this.consto;
            for (Descuento descuento : this.descuentos) {
                this.costofinal += descuento.calcular(this);
            }
        }
        return this.costofinal;
    }
}
