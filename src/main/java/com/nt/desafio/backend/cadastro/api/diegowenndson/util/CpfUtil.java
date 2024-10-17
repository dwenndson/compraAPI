package com.nt.desafio.backend.cadastro.api.diegowenndson.util;

public class CpfUtil {
    public static String Mask(String cpf){
        if(cpf.isEmpty() || !cpf.matches("\\d{11}")){
            throw new IllegalArgumentException("O CPF, DEVE CONTER EXATAMENTE 11 DIGITOS NUMÉRICOS");
        }
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
