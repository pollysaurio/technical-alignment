package com.mercadolibre.patrones.factory;

import com.mercadolibre.enums.OvenEnum;
import com.mercadolibre.service.IOven;
import com.mercadolibre.service.impl.OvenClayImpl;
import com.mercadolibre.service.impl.OvenElectricImpl;
import com.mercadolibre.service.impl.OvenGasImpl;
import org.springframework.stereotype.Component;

@Component
public class OvenFactory {

    private final OvenGasImpl ovenGas;
    private final OvenElectricImpl ovenElectric;
    private final OvenClayImpl ovenClay;

    public OvenFactory(OvenGasImpl ovenGas, OvenElectricImpl ovenElectric, OvenClayImpl ovenClay) {
        this.ovenGas = ovenGas;
        this.ovenElectric = ovenElectric;
        this.ovenClay = ovenClay;
    }

    public IOven getOvenInstance(OvenEnum ovenEnum) {
        IOven instance;
        switch (ovenEnum) {
            case GAS:
                instance = ovenGas;
                break;
            case ELECTRIC:
                instance = ovenElectric;
                break;
            case CLAY:
                instance = ovenClay;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ovenEnum.getOvenId());
        }
        return instance;
    }

}
