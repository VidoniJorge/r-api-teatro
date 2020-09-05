package ar.com.jlv.api.teatro.modelo.descuentos;

import ar.com.jlv.api.teatro.modelo.Asiento;
import lombok.Getter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
public class DescuentoDiaSemana extends Descuento {
    private static final Double porcentaje = -0.5;

    public DescuentoDiaSemana() {
        super();
        this.name = "Descuento mitad de semana";
    }

    @Override
    public Double calcular(Asiento asiento) {
        if (this.aplicaDescuento(asiento)) {
            return asiento.getConstoFinal() * this.porcentaje;
        }
        return 0.0;
    }

    @Override
    public Boolean aplicaDescuento(Asiento asiento) {
        return (DayOfWeek.TUESDAY.equals(asiento.getFechaReserva().getDayOfWeek()) ||
                DayOfWeek.WEDNESDAY.equals(asiento.getFechaReserva().getDayOfWeek()));
    }
}
