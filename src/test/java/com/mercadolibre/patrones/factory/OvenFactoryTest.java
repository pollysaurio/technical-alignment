package com.mercadolibre.patrones.factory;

import com.mercadolibre.AppConfig;
import com.mercadolibre.enums.OvenEnum;
import com.mercadolibre.service.IOven;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Slf4j
public class OvenFactoryTest {

    @Autowired
    OvenFactory ovenFactory;

    @Test
    public void gettingAllOvens(){
        IOven iOvenGas = ovenFactory.getOvenInstance(OvenEnum.GAS);
        IOven iOvenElectric = ovenFactory.getOvenInstance(OvenEnum.ELECTRIC);
        IOven iOvenClay = ovenFactory.getOvenInstance(OvenEnum.CLAY);
        log.info(iOvenGas.getDescription());
        log.info(iOvenElectric.getDescription());
        log.info(iOvenClay.getDescription());
    }

}
