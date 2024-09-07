package com.joaocarloslima;

import java.util.*;

public class Maquina {
    private double saldo;
    private double totalArrecadado;
    private List<Refrigerante> refrigerantes = new ArrayList<Refrigerante>();

    public Maquina() {
        for(int i = 0; i < 10; i++) {
            Sabor sabor = Sabor.values()[new Random().nextInt(Sabor.values().length)];

            var refrigerante = new Refrigerante(sabor.toString(), new Random().nextInt(10) + 1, sabor);
            adicionarRefrigerante(refrigerante);
        }
    }

    public void adicionarRefrigerante(Refrigerante refrigerante) {
        if (refrigerante == null) return;

        refrigerantes.add(refrigerante);
    }

    public void inserirDinheiro(double dinheiro) {
        this.saldo += dinheiro;
    }

    public void sacarDinheiro() {
        this.saldo = 0;
    }

    public void comprarRefrigerante(Refrigerante refrigerante) {
        if (this.getSaldo() < refrigerante.getPreco()) {
            throw new RuntimeException("Saldo insuficiente!");
        }

        this.saldo -= refrigerante.getPreco();
        this.totalArrecadado += refrigerante.getPreco();
        refrigerantes.remove(refrigerante);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }

    public List<Refrigerante> getRefrigerantes() {
        return refrigerantes;
    }
}
