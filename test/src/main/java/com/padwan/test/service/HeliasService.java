package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeliasService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Telecinese");
        skills.add("Sentir ataques");
        skills.add("Influenciar pensamentos");
        skills.add("Ver o futuro");
        skills.add("Ler pensamentos:");
        skills.add("Localizar pessoas");
        skills.add("Piloto de Fuga");
        return skills;
    }

}
