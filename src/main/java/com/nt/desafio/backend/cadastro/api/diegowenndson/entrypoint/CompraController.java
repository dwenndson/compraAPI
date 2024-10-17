package com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint;

import com.nt.desafio.backend.cadastro.api.diegowenndson.entrypoint.request.CompraDto;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.Compra;
import com.nt.desafio.backend.cadastro.api.diegowenndson.models.relatorio.Relatorio;
import com.nt.desafio.backend.cadastro.api.diegowenndson.service.CompraService;
import com.nt.desafio.backend.cadastro.api.diegowenndson.service.impl.CompraServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> cadastrarCompra(@RequestBody @Valid CompraDto compraDto) {
        Compra novaCompra = compraService.cadastrarCompra(compraDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCompra);
    }

    @GetMapping
    public ResponseEntity<List<Compra>> pesquisarCompras(
            @RequestParam String cpfComprador,
            @RequestParam String nomeProduto,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        List<Compra> compras = compraService.pesquisarCompras(cpfComprador, nomeProduto, dataInicio, dataFim);
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<Relatorio>> gerarRelatorio(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        List<Relatorio> relatorio = compraService.gerarRelatorio(dataInicio, dataFim);
        return ResponseEntity.ok(relatorio);
    }
}

