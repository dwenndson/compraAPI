package com.nt.desafio.backend.cadastro.api.diegowenndson.service.impl;

import com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint.request.CompraDto;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.Compra;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.relatorio.Relatorio;
import com.nt.desafio.backend.cadastro.api.diegowenndson.repository.CompraRepository;
import com.nt.desafio.backend.cadastro.api.diegowenndson.service.CompraService;
import com.nt.desafio.backend.cadastro.api.diegowenndson.service.mapper.CompraMapper;
import com.nt.desafio.backend.cadastro.api.diegowenndson.util.CpfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraMapper compraMapper;

    public Compra cadastrarCompra(CompraDto compraDto) {
        if (compraDto.quantidade() <= 3) {
            List<Compra> comprasExistentes = compraRepository.findByCpfComprador(CpfUtil.Mask(
                    compraDto.cpfComprador()));
            if (!comprasExistentes.isEmpty()) {
                validaCompra(comprasExistentes, compraDto.quantidade());
            }
            Compra compraSave = compraMapper.mapToCompra(compraDto);
            return compraRepository.save(compraSave);
        }
        throw new IllegalArgumentException("Um CPF não pode comprar mais de 3 unidades do mesmo produto.");
    }

    public List<Compra> pesquisarCompras(String cpfComprador, String nomeProduto, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return compraRepository.findByFilters(cpfComprador, nomeProduto, dataInicio, dataFim);
    }

    public List<Relatorio> gerarRelatorio(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Compra> compras = compraRepository.findByDataHoraCompraBetween(dataInicio, dataFim);
        return compras.stream()
                .collect(Collectors.groupingBy(Compra::getNomeProduto, Collectors.toList()))
                .entrySet().stream()
                .map(entry -> new Relatorio(
                        entry.getKey(),
                        entry.getValue().get(0).getValorUnitario(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Compra::getValorUnitario)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                )).collect(Collectors.toList());
    }

    private void validaCompra(List<Compra> compraList, int quantidade) {
        int totalQuantidade = compraList.stream()
                .mapToInt(Compra::getQuantidade).sum() + quantidade;

        if (totalQuantidade > 3) {
            throw new IllegalArgumentException("Um CPF não pode comprar mais de 3 unidades do mesmo produto.");
        }
    }
}
