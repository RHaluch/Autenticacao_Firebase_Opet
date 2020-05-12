package com.example.firebaseopet;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Pessoa {
    public String nome;
    public int qtde_filhos;
    public boolean ativo;
    public double salario;
    public List<String> pets;
    public Date dataAniversario;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", qtde_filhos=" + qtde_filhos +
                ", ativo=" + ativo +
                ", salario=" + salario +
                ", pets=" + pets +
                ", dataAniversario=" + dataAniversario +
                '}';
    }
}
