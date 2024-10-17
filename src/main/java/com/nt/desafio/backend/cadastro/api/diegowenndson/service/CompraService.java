package com.nt.desafio.backend.cadastro.api.diegowenndson.service;

import com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint.request.CompraDto;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.Compra;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.relatorio.Relatorio;

import java.time.LocalDateTime;
import java.util.List;

public interface CompraService {
    Compra cadastrarCompra(CompraDto compraDto);
    List<Compra> pesquisarCompras(String cpf, String nomeProduto, LocalDateTime dataInit, LocalDateTime dataFim);
    List<Relatorio> gerarRelatorio(LocalDateTime dataInit, LocalDateTime dataFim);
}
