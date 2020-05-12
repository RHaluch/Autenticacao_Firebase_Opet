package com.example.firebaseopet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

class PopulateUtil {

    public static List<Pessoa> loadPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "pedro jose";
        pessoa.qtde_filhos=1;
        pessoa.salario=2400.75;
        pessoa.ativo=false;
        pessoa.pets = Arrays.asList("pingo","princessa");
        pessoa.dataAniversario = new GregorianCalendar(1991, Calendar.AUGUST,16).getTime();
        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "maria ana";
        pessoa.qtde_filhos=2;
        pessoa.salario=2900;
        pessoa.ativo=true;
        pessoa.pets = Arrays.asList("maria","maça");
        pessoa.dataAniversario = new GregorianCalendar(1998, Calendar.JANUARY,21).getTime();
        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "pedro moreira";
        pessoa.qtde_filhos=0;
        pessoa.salario=1800.00;
        pessoa.ativo=true;
        pessoa.pets = null;
        pessoa.dataAniversario = new GregorianCalendar(1995, Calendar.DECEMBER,30).getTime();
        pessoas.add(pessoa);

        return pessoas;
    }
}
