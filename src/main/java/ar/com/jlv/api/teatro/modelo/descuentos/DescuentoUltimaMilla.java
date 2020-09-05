package ar.com.jlv.api.teatro.modelo.descuentos;

import ar.com.jlv.api.teatro.modelo.Asiento;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
public class DescuentoUltimaMilla extends Descuento{
    private static final Double porcentaje = -0.8;
    public DescuentoUltimaMilla () {
        this.name = "Descuento ultima milla";
    }


    @Override
    public Double calcular(Asiento asiento) {
        if(this.aplicaDescuento(asiento)) {
            return asiento.getConstoFinal() * porcentaje;
        }
        return 0.0;
    }

    @Override
    public Boolean aplicaDescuento(Asiento asiento) {
        Integer diferenciaEnDias = asiento.getFechaReserva().getDayOfYear() - asiento.getFechaFunsion().getDayOfYear();
        return (diferenciaEnDias.intValue() == 1 || diferenciaEnDias.intValue() == 0);
    }
}
