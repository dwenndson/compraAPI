package com.nt.desafio.backend.cadastro.api.diegowenndson.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.desafio.backend.cadastro.api.diegowenndson.models.Compra;
import org.springframework.data.repository.query.Param;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    
    @Query("SELECT c FROM Compra c WHERE " +
           "LOWER(c.cpfComprador) LIKE LOWER(CONCAT('%', :cpfComprador, '%')) " +
           "AND LOWER(c.nomeProduto) LIKE LOWER(CONCAT('%', :nomeProduto, '%')) " +
           "AND c.dataHoraCompra BETWEEN :dataInicio AND :dataFim")
    List<Compra> findByFilters(
            @Param("cpfComprador") String cpfComprador,
            @Param("nomeProduto") String nomeProduto,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);

    List<Compra> findByCpfComprador(String cpfComprador);
    List<Compra> findByDataHoraCompraBetween(LocalDateTime dataInit, LocalDateTime dataFim);
}
