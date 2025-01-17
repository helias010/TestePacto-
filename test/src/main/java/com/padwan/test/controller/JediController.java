package com.padwan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.models.Jedi;
import com.padwan.test.service.JediService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jedis")
public class JediController {

    private final JediService jediService;

    @Autowired
    public JediController(JediService jediService) {
        this.jediService = jediService;
    }

    @PostMapping
    public ResponseEntity<List<Jedi>> criarJedis(@RequestBody List<JediDTO> dtos) {
        List<Jedi> jedis = jediService.criarJedis(dtos); // Passando a lista de JediDTO
        return ResponseEntity.ok(jedis);
    }

    @GetMapping
    public ResponseEntity<List<Jedi>> listarJedis() {
        return ResponseEntity.ok(jediService.listarTodos());
    }
    
    @GetMapping("/mestres-e-aprendizes")
    public ResponseEntity<List<Map<String, Object>>> listarMestresEApreendizes() {
        return ResponseEntity.ok(jediService.listarMestresEApreendizes());
    }

    @GetMapping("/midichlorians/acima-de-9000")
    public ResponseEntity<List<Jedi>> listarJedisComMidichloriansAcimaDe9000() {
        return ResponseEntity.ok(jediService.listarJedisComMidichloriansAcimaDe9000());
    }


    @GetMapping("/categorias")
    public ResponseEntity<List<Map<String, Object>>> contarJedisPorCategoria() {
        return ResponseEntity.ok(jediService.contarJedisPorCategoria());
    }
}
