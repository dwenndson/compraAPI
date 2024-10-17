package com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint.request;

import java.math.BigDecimal;

public record CompraDto(Integer produtoId,
                        String nomeProduto,
                        Integer quantidade,
                        String cpfComprador,
                        BigDecimal valorUnitario) {
}
