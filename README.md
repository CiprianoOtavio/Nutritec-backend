# ROTAS 
## Nutricionistas 
@get `/nutritionists`\
Retorna todos os nutricionistas no banco de dados

@post `/nutritionists`\
É esperado um json neste formato para salvar um nutricionista no banco de dados
```js
   {
        "registration": "4237",
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
        "registration": "4237",
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

@get `nutritionists/{registration}`\
Retorna um nutricionista a partir de sua matrícula


## Patients

@get `/patients`\
Retorna todos os pacientes no banco de dados

@post `/patients`\
É esperado um json neste formato para salvar um paciente no banco de dados
```js
    {
        "cpf": "15263584965"
        "name": "Jorgina",
        "age": 25,
        "weight": 56.16,
        "height": 2.04,
        "healthPlan": "HAP_SAUDE"
    }
```

@delete `/patients/{CPF}`\
Deleta um paciente a partir de seu CPF

@put `/patients`\
É esperado um json neste formato para editar um paciente no banco de dados
```js
    {
        "cpf": "15263584965",
        "name": "Jorgina",
        "age": 25,
        "weight": 56.16,
        "height": 2.04,
        "healthPlan": "HAP_SAUDE"
    }
```

@get `/patients/{CPF}`\
Retorna um nutricionista a partir de seu CPF


## Consulta

@get `/consultas`\
Retorna todas as consultas no banco de dados

@get `/consultas/{nutritionistRegistration}`\
Retorna todas as consultas de um nutricionista a partir de sua matrícula

@get `/consultas/data`\
Retorna uma lista que relaciona quantidade de consultas por idade de paciente

@get `/consultas/nutritionistCount`\
Retorna uma lista que mostra a quantidade de nutricionistas por plano de saúde

@post `/consultas`\
É esperado um json neste formato para salvar uma consulta no banco de dados
```js
    {
        "nutritionistRegistration": "4237",
        "patientCPF": "15263584965",
        "date": "1643338218"
    }
```
Obs.: A data deve, **obrigatoriamente**, ser uma *String* no formato *Timestamp*.

@put `/consultas`\
É esperado um json neste formato para editar uma consulta no banco de dados
```js
    {
        "id": "61f35c7d8b2f7051ee9a6447",
        "nutritionistRegistration": "4237",
        "patientCPF": "15263584965",
        "date": "1643338218"
    }
```

@delete `/consultas/{id}`\
Deleta uma consulta a partir de seu Id










