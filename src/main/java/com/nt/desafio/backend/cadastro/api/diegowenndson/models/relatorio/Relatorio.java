package com.nt.desafio.backend.cadastro.api.diegowenndson.models.relatorio;

import java.math.BigDecimal;

public class Relatorio {
    private String nomeProduto;
    private BigDecimal valorUnitario;
    private int quantidadeCompras;
    private BigDecimal totalVendido;

    public Relatorio(String nomeProduto, BigDecimal valorUnitario, int quantidadeCompras, BigDecimal totalVendido) {
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeCompras = quantidadeCompras;
        this.totalVendido = totalVendido;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public void setQuantidadeCompras(int quantidadeCompras) {
        this.quantidadeCompras = quantidadeCompras;
    }

    public BigDecimal getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(BigDecimal totalVendido) {
        this.totalVendido = totalVendido;
    }
}

