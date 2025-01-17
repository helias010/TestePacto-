package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.models.Jedi;
import com.padwan.test.models.Jedi.StatusJedi;
import com.padwan.test.repository.JediRepository;

@Service
public class JediService {

    private final JediRepository jediRepository;

    @Autowired
    public JediService(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    public Jedi criarJedi(JediDTO dto) {
        Jedi jedi = new Jedi();
        

        // Definir nome
        jedi.setNome(dto.getNome());

        // Verifica se o status é válido e converte para o enum
        try {
            // A conversão de String para Enum é feita corretamente
            jedi.setStatus(StatusJedi.valueOf(dto.getStatus()));  // Aqui, 'dto.getStatus()' deve ser uma string válida, como "JEDI"
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Status inválido: " + dto.getStatus());
        }

        // Verifica se o mentor existe e associa
        if (dto.getIdMentor() != null) {
            Jedi mentor = jediRepository.findById(dto.getIdMentor())
                    .orElseThrow(() -> new RuntimeException("Mentor não encontrado"));
            jedi.setMentor(mentor);
        }
        
        // Adicionar a quantidade de midichlorians
        jedi.setMidichlorians(dto.getMidichlorians());  // Definir quantidade de midichlorians


        // Salva o Jedi no banco de dados
        return jediRepository.save(jedi);
    }
    public List<Jedi> criarJedis(List<JediDTO> dtos) {
        List<Jedi> jedis = new ArrayList<>();
        for (JediDTO dto : dtos) {
            jedis.add(criarJedi(dto)); // Criando cada Jedi da lista
        }
        return jediRepository.saveAll(jedis); // Salvando todos de uma vez
    }
    public List<Jedi> listarTodos() {
        return jediRepository.findAll();
    }
    
    public List<Map<String, Object>> listarMestresEApreendizes() {
        return jediRepository.listarMestresEApreendizes();
    }

    public List<Jedi> listarJedisComMidichloriansAcimaDe9000() {
        return jediRepository.listarJedisComMidichloriansAcimaDe9000();
    }



    public List<Map<String, Object>> contarJedisPorCategoria() {
        return jediRepository.contarJedisPorCategoria();
    }
}
