package com.padwan.test.repository;

import com.padwan.test.models.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;

import com.padwan.test.models.Jedi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    // Listar mestres Jedis e seus aprendizes
    @Query(value = """
        SELECT m.id AS mentorId, 
               m.nome AS mentorNome, 
               a.id AS aprendizId, 
               a.nome AS aprendizNome 
        FROM jedi m 
        LEFT JOIN jedi a ON m.id = a.mentor_id 
        WHERE m.status = 'MESTRE_JEDI';
        """, nativeQuery = true)
    List<Map<String, Object>> listarMestresEApreendizes();

    // Listar Jedis com midichlorians acima de 9000
    @Query(value = "SELECT * FROM jedi WHERE midichlorians > 9000", nativeQuery = true)
    List<Jedi> listarJedisComMidichloriansAcimaDe9000();


    // Listar por categoria
    @Query(value = "SELECT status AS categoria, COUNT(*) AS quantidade FROM jedi GROUP BY status", nativeQuery = true)
    List<Map<String, Object>> contarJedisPorCategoria();
}
