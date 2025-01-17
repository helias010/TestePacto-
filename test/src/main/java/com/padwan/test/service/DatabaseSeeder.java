/*package com.padwan.test.service;

import com.padwan.test.models.Jedi;
import com.padwan.test.models.Jedi.StatusJedi;
import com.padwan.test.repository.JediRepository;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final JediRepository jediRepository;

    @Autowired
    public DatabaseSeeder(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Criar mentores
        Jedi obiWan = new Jedi();
        obiWan.setNome("Obi-Wan Kenobi");
        obiWan.setStatus(StatusJedi.MESTRE_JEDI);

        Jedi yoda = new Jedi();
        yoda.setNome("Yoda");
        yoda.setStatus(StatusJedi.MESTRE_JEDI);

        Jedi quiGon = new Jedi();
        quiGon.setNome("Qui-Gon Jinn");
        quiGon.setStatus(StatusJedi.MESTRE_JEDI);

        // Salvar mentores no banco
        jediRepository.saveAll(Arrays.asList(obiWan, yoda, quiGon));
    }
}
*/