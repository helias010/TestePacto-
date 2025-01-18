## 1) Yoda: Como primeira parte de seu treinamento, capaz você deverá ser para subir a aplicação;
  **Resposta: após fazer clone do repositório dado para começar fazer o projeto, ao tentar subir a aplicação na qual eu usei o eclipse estava com um problema no json,**
   **foi quando olhei o arquivo e vi a falta da dependencia e coloquei.**
  ```
<dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20210307</version>
 </dependency>
```

## 2)Qual será o retorno se eu fizer um POST em http://localhost:9099/generic-post passando o seguinte body?
```
 {
   "planet": "Coruscant 985",
    "ranking": 42,
  "classe": "Jedi Knight"
 }
```
   **Resposta:**
   ```
   {
    "planetAbreviado": "Coruscant",
    "rankingMultiplicado": 37944,
    "classeAbreviado": "Jedi"
}

```
## 3)Se mudarmos o campo “ranking” para 0, a aplicação dá um erro. Por quê?
**Resposta:**
 ```
     public ProcessDTO process(GenericoDTO generico){
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setClasseAbreviado(generico.getClasse().split(" ")[0]);
        processDTO.setPlanetAbreviado(generico.getPlanet().split(" ")[0]);
        Integer divisor = generico.getRanking() * 2;
        processDTO.setRankingMultiplicado(generico.getRanking()*124*612/divisor);
        return processDTO;
    }

}
```
O erro ocorre porque o cálculo envolve o método getRanking, que está sendo utilizado como divisor. Se o valor retornado por getRanking for zero, haverá uma tentativa de realizar uma divisão por zero, o que não é permitido em operações matemáticas e resulta em erro.

## 4)Como podemos mudar a porta onde a aplicação sobe?
**Resposta:**

dentro do application.properties
server.port=9099
so alterar a port para qual você quiser.

## 5) Agora você vai ter que programar. Massa, hein?! Quando acessamos o endpoint http://localhost:9099/vader/skills, a aplicação retorna uma lista de habilidades do Darth Vader. Faça com que o sistema tenha um endpoint igual a esse, só que com seu nome e suas habilidades. Por exemplo, o meu seria http://localhost:9099/joaoalcides/skills. Detalhe muito importante: ao fazer isso, você não pode impactar o do Darth Vader. Envie para mim seu usuário do github, vou te adicionar nesse projeto para que você possa subir uma branch com suas alterações.
   **Resposta:**

**Para fazer isso eu criei um outro controller e service, ficou com http://localhost:9099/helias/skills e resultado do get**
```
   {
    "Helias Kenobi": [
        "Telecinese",
        "Sentir ataques",
        "Influenciar pensamentos",
        "Ver o futuro",
        "Ler pensamentos:",
        "Localizar pessoas",
        "Piloto de Fuga"
    ]
}
```



## 6) Mestre Windu explica que todo Jedi já foi um Padawan, então necessário é definir nome, status (padawan/jedi/mestre jedi) e um mentor para cada Jedi;

## 7) Qui-Gon ao fazer contato, estando no mundo espiritual da Força, nos diz que é possível mensurar a quantidade de midichlorians em cada Jedi, por isso, você deverá informar isso lá;

**Reposta do 6 e 7 :**

Foi feito um models para criar a tabela no banco de dados na qual estou usando o PostgreSQL. Fazendo ligação relacionado entre ID e IdMentor.

Além disso foi criado um repository também.

E foi criado um controlle, service e DTO. 

Post http://localhost:9099/jedis
```
[
  {
    "nome": "Yoda",
    "status": "MESTRE_JEDI",
    "midichlorians": 20000
  },
  {
    "nome": "Obi-Wan Kenobi",
    "status": "JEDI",
    "midichlorians": 15000,
    "idMentor": 1
  },
  {
    "nome": "Mace Windu",
    "status": "JEDI",
    "midichlorians": 18000,
    "idMentor": 1
  },
  {
    "nome": "Anakin Skywalker",
    "status": "JEDI",
    "midichlorians": 25000,
    "idMentor": 2
  },
  {
    "nome": "Ahsoka Tano",
    "status": "PADAWAN",
    "midichlorians": 12000,
    "idMentor": 4
  },
  {
    "nome": "Quinlan Vos",
    "status": "PADAWAN",
    "midichlorians": 11000,
    "idMentor": 3
  },
  {
    "nome": "Barriss Offee",
    "status": "PADAWAN",
    "midichlorians": 10500,
    "idMentor": 7
  },
  {
    "nome": "Kit Fisto",
    "status": "PADAWAN",
    "midichlorians": 10000,
    "idMentor": 3
  },
  {
    "nome": "Plo Koon",
    "status": "PADAWAN",
    "midichlorians": 9000,
    "idMentor": 3
  }
]
```

Get http://localhost:9099/jedis
```
[
    {
        "id": 1,
        "nome": "Yoda",
        "status": "MESTRE_JEDI",
        "mentor": null,
        "midichlorians": 20000
    },
    {
        "id": 2,
        "nome": "Obi-Wan Kenobi",
        "status": "JEDI",
        "mentor": {
            "id": 1,
            "nome": "Yoda",
            "status": "MESTRE_JEDI",
            "mentor": null,
            "midichlorians": 20000
        },
        "midichlorians": 15000
    },
    {
        "id": 3,
        "nome": "Mace Windu",
        "status": "JEDI",
        "mentor": {
            "id": 1,
            "nome": "Yoda",
            "status": "MESTRE_JEDI",
            "mentor": null,
            "midichlorians": 20000
        },
        "midichlorians": 18000
    },
    {
        "id": 4,
        "nome": "Anakin Skywalker",
        "status": "JEDI",
        "mentor": {
            "id": 2,
            "nome": "Obi-Wan Kenobi",
            "status": "JEDI",
            "mentor": {
                "id": 1,
                "nome": "Yoda",
                "status": "MESTRE_JEDI",
                "mentor": null,
                "midichlorians": 20000
            },
            "midichlorians": 15000
        },
        "midichlorians": 25000
    },
    {
        "id": 5,
        "nome": "Ahsoka Tano",
        "status": "PADAWAN",
        "mentor": {
            "id": 4,
            "nome": "Anakin Skywalker",
            "status": "JEDI",
            "mentor": {
                "id": 2,
                "nome": "Obi-Wan Kenobi",
                "status": "JEDI",
                "mentor": {
                    "id": 1,
                    "nome": "Yoda",
                    "status": "MESTRE_JEDI",
                    "mentor": null,
                    "midichlorians": 20000
                },
                "midichlorians": 15000
            },
            "midichlorians": 25000
        },
        "midichlorians": 12000
    },
    {
        "id": 6,
        "nome": "Quinlan Vos",
        "status": "PADAWAN",
        "mentor": {
            "id": 3,
            "nome": "Mace Windu",
            "status": "JEDI",
            "mentor": {
                "id": 1,
                "nome": "Yoda",
                "status": "MESTRE_JEDI",
                "mentor": null,
                "midichlorians": 20000
            },
            "midichlorians": 18000
        },
        "midichlorians": 11000
    }
]
```


8) Anakin Skywalker antes de se tornar o Darth Vader, deixou para você a última missão, após isso, estará apto a se tornar um Jedi. Essa missão é a de criar, com Native SQL as seguintes consultas, com seus respectivos endpoints:
a) Listar todos os mestres Jedis e seus aprendizes;
b) Listar todos Jedis cujo midichlorians sejam acima de 9000;
c) Listar por categoria, quantos são os Jedis;


Resposta:

a) http://localhost:9099/jedis/mestres-e-aprendizes
[
    {
        "aprendizid": 2,
        "aprendiznome": "Obi-Wan Kenobi",
        "mentorid": 1,
        "mentornome": "Yoda"
    },
    {
        "aprendizid": 3,
        "mentorid": 1,
        "mentornome": "Yoda",
        "aprendiznome": "Mace Windu"
    }
]

b) http://localhost:9099/jedis/midichlorians/acima-de-9000

[
    {
        "id": 1,
        "nome": "Yoda",
        "status": "MESTRE_JEDI",
        "mentor": null,
        "midichlorians": 20000
    },
    {
        "id": 2,
        "nome": "Obi-Wan Kenobi",
        "status": "JEDI",
        "mentor": {
            "id": 1,
            "nome": "Yoda",
            "status": "MESTRE_JEDI",
            "mentor": null,
            "midichlorians": 20000
        },
        "midichlorians": 15000
    },
    {
        "id": 3,
        "nome": "Mace Windu",
        "status": "JEDI",
        "mentor": {
            "id": 1,
            "nome": "Yoda",
            "status": "MESTRE_JEDI",
            "mentor": null,
            "midichlorians": 20000
        },
        "midichlorians": 18000
    },
    {
        "id": 4,
        "nome": "Anakin Skywalker",
        "status": "JEDI",
        "mentor": {
            "id": 2,
            "nome": "Obi-Wan Kenobi",
            "status": "JEDI",
            "mentor": {
                "id": 1,
                "nome": "Yoda",
                "status": "MESTRE_JEDI",
                "mentor": null,
                "midichlorians": 20000
            },
            "midichlorians": 15000
        },
        "midichlorians": 25000
    },
    {
        "id": 5,
        "nome": "Ahsoka Tano",
        "status": "PADAWAN",
        "mentor": {
            "id": 4,
            "nome": "Anakin Skywalker",
            "status": "JEDI",
            "mentor": {
                "id": 2,
                "nome": "Obi-Wan Kenobi",
                "status": "JEDI",
                "mentor": {
                    "id": 1,
                    "nome": "Yoda",
                    "status": "MESTRE_JEDI",
                    "mentor": null,
                    "midichlorians": 20000
                },
                "midichlorians": 15000
            },
            "midichlorians": 25000
        },
        "midichlorians": 12000
    },
    {
        "id": 6,
        "nome": "Quinlan Vos",
        "status": "PADAWAN",
        "mentor": {
            "id": 3,
            "nome": "Mace Windu",
            "status": "JEDI",
            "mentor": {
                "id": 1,
                "nome": "Yoda",
                "status": "MESTRE_JEDI",
                "mentor": null,
                "midichlorians": 20000
            },
            "midichlorians": 18000
        },
        "midichlorians": 11000
    }
]

c) http://localhost:9099/jedis/categorias

[
    {
        "categoria": "MESTRE_JEDI",
        "quantidade": 1
    },
    {
        "categoria": "PADAWAN",
        "quantidade": 2
    },
    {
        "categoria": "JEDI",
        "quantidade": 3
    }
]
