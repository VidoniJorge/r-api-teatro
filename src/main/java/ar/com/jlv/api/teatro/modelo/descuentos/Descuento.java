package ar.com.jlv.api.teatro.modelo.descuentos;

import ar.com.jlv.api.teatro.modelo.Asiento;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Descuento {
    protected String name;

    public String getName(){
        return this.name;
    }

    public abstract Double calcular(Asiento asiento);

    public abstract Boolean aplicaDescuento(Asiento asiento);
}
