package ar.com.jlv.api.teatro.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Fila {
    private Integer numero;
    private Integer Cantidad;
    private Double modificadorPrecio;

    public Fila() {
        this.modificadorPrecio = 1.0;
    }
}
