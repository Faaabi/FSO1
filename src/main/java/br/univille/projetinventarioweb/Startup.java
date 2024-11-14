package br.univille.projetinventarioweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projetinventarioweb.entity.Localizacao;
import br.univille.projetinventarioweb.entity.Tec;
import br.univille.projetinventarioweb.service.LocalizacaoService;
import br.univille.projetinventarioweb.service.TecService;

@Component
public class Startup {
    @Autowired
    private LocalizacaoService serviceLocalizacao;
    @Autowired
    private TecService serviceTec;
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var CA = new Localizacao();
        CA.setId(1);
        CA.setNome("Lab CA");
        serviceLocalizacao.save(CA);

        var NVH = new Localizacao();
        NVH.setId(2);
        NVH.setNome("Lab NVH");
        serviceLocalizacao.save(NVH);

        var SAFETY = new Localizacao();
        SAFETY.setId(3);
        SAFETY.setNome("Lab SAFETY");
        serviceLocalizacao.save(SAFETY);

        var APLICATION = new Localizacao();
        APLICATION.setId(1);
        APLICATION.setNome("Lab APLICATION");
        serviceLocalizacao.save(APLICATION);


        var inverter = new Tec();
        inverter.setId(1);
        inverter.setNome("Inverter");
        serviceTec.save(inverter);

        var onoff= new Tec();
        onoff.setId(2);
        onoff.setNome("ON/OFF");
        serviceTec.save(onoff);
    }
    
    
}

