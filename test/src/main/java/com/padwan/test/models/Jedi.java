package com.padwan.test.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Jedi {
	public enum StatusJedi {
	    PADAWAN,
	    JEDI,
	    MESTRE_JEDI
	}



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Enumerated(EnumType.STRING)
    private StatusJedi status;

    @ManyToOne(fetch = FetchType.LAZY)  // Relacionamento Many-to-One com Mentor
    @JoinColumn(name = "mentor_id")  // Coluna para armazenar o mentor
    private Jedi mentor;
    
    private int midichlorians;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusJedi getStatus() {
        return status;
    }

    public void setStatus(StatusJedi status) {
        this.status = status;
    }

    public Jedi getMentor() {
        return mentor;
    }

    public void setMentor(Jedi mentor) {
        this.mentor = mentor;
    }
    
    public int getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(int midichlorians) {
        this.midichlorians = midichlorians;
    }
}