package com.nt.desafio.backend.cadastro.api.diegowenndson.service.mapper;

import com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint.request.CompraDto;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.Compra;
import com.nt.desafio.backend.cadastro.api.diegowenndson.util.CpfUtil;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {
    public Compra mapToCompra(CompraDto compraDto) {
        return new Compra(
                compraDto.produtoId().longValue(),
                compraDto.nomeProduto(),
                compraDto.quantidade(),
                CpfUtil.Mask(compraDto.cpfComprador()),
                compraDto.valorUnitario()
        );
    }
}
