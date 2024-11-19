package br.univille.projetinventarioweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projetinventarioweb.entity.Localizacao;
import br.univille.projetinventarioweb.entity.Status;
import br.univille.projetinventarioweb.entity.Tec;
import br.univille.projetinventarioweb.entity.Tipo;
import br.univille.projetinventarioweb.service.LocalizacaoService;
import br.univille.projetinventarioweb.service.StatusService;
import br.univille.projetinventarioweb.service.TecService;
import br.univille.projetinventarioweb.service.TipoService;

@Component
public class Startup {
    @Autowired
    private LocalizacaoService serviceLocalizacao;
    @Autowired
    private TecService serviceTec;
    @Autowired
    private StatusService serviceStatus;
    @Autowired
    private TipoService serviceTipo;

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
        APLICATION.setId(4);
        APLICATION.setNome("Lab APLICATION");
        serviceLocalizacao.save(APLICATION);

        var inverter = new Tec();
        inverter.setId(5);
        inverter.setNome("Inverter");
        serviceTec.save(inverter);

        var onoff= new Tec();
        onoff.setId(6);
        onoff.setNome("ON/OFF");
        serviceTec.save(onoff);

        var baseline = new Status();
        baseline.setId(6);
        baseline.setStatus("Baseline");
        serviceStatus.save(baseline);
        
        var prototipo = new Status();
        prototipo.setId(7);
        prototipo.setStatus("Protótipo");
        serviceStatus.save(prototipo);

        var modificado = new Status();
        modificado.setId(8);
        modificado.setStatus("Modificado");
        serviceStatus.save(modificado);

        var Split = new Tipo();
        Split.setId(9);
        Split.setTipo("Split");
        serviceTipo.save(Split);

        var window = new Tipo();
        window.setId(10);
        window.setTipo("Window");
        serviceTipo.save(window);
    }
    
    
}
