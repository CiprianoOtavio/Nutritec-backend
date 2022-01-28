# ROTAS 
## Nutricionistas 
@get `/nutritionists`\
Retorna todos os nutricionistas no banco de dados

@post `/nutritionists`\
É esperado um json neste formato para salvar um nutricionista no banco de dados
```js
   {
        "registration": 4237,
        "name": "Suel Nutras",
        "age": 22,
        "speciality": "Pamonha",
        "healthPlan": [
            "HAP_SAUDE",
            "UT_MAIS"
        ]
   }
```

@delete `/nutritionists/{registration}`\
Deleta um nutricionista a partir de sua matrícula

@put `/nutritionists`\
É esperado um json neste formato para editar um nutricionista no banco de dados
```js
   {
        "id": "61f43e48c713ab27b1fb6a6c",
        "registration": 4237,
        "name": "Suel Nutras",
        "age": 22,
        "speciality": "Pamonha",
        "healthPlan": [
            "HAP_SAUDE",
            "UT_MAIS"
        ]
   }
```

@get `nutritionists/healthplan/{healthPlan}`\
Retorna nutricionistas por plano de saúde

@get `nutritionists/{id}`\
Retorna um nutricionista a partir de seu Id


## Patients

@get `/patients`\
Retorna todos os pacientes no banco de dados

@post `/patients`\
É esperado um json neste formato para salvar um paciente no banco de dados
```js
    {
        "name": "Jorgina",
        "age": 25,
        "weight": 56.16,
        "height": 2.04,
        "healthPlan": "HAP_SAUDE"
    }
```

@delete `/patients/{id}`\
Deleta um paciente a partir de seu Id

@put `/patients`\
É esperado um json neste formato para editar um paciente no banco de dados
```js
    {
        "id": "61f33dc3f188405212f60488",
        "name": "Jorgina",
        "age": 25,
        "weight": 56.16,
        "height": 2.04,
        "healthPlan": "HAP_SAUDE"
    }
```

@get `/patients/{id}`\
Retorna um nutricionista a partir de seu Id


## Consulta

@get `/consultas`\
Retorna todas as consultas no banco de dados

@get `/consultas/{nutritionistId}`\
Retorna todas as consultas de um nutricionista a partir de seu Id

@get `/consultas/data`\
Retorna as uma lista que relaciona quantidade de consultas por idade de paciente

@post `/consultas`\
É esperado um json neste formato para salvar uma consulta no banco de dados
```js
    {
        "nutritionistId": "61f330b721fafe5eb28374c4",
        "patientId": "61f33ed059b3ea62f4239ad2",
        "date": 1643338218
    }
```
Obs.: A data deve, **obrigatoriamente**, estar no formato *timestamp*.

@put `/consultas`\
É esperado um json neste formato para editar uma consulta no banco de dados
```js
    {
        "id": "61f35c7d8b2f7051ee9a6447",
        "nutritionistId": "61f330b721fafe5eb28374c4",
        "patientId": "61f33ed059b3ea62f4239ad2",
        "date": 1643338218
    }
```

@delete `/consultas/{id}`\
Deleta uma consulta a partir de seu Id










