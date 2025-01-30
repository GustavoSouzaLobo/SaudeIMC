package br.com.saudeimc.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste/imc")
public interface IMCService {


    @GetMapping
    public default ImcResponse calcularIMC(@RequestParam double peso, @RequestParam double altura) {
        double imc = peso / (altura * altura);
        String classificacao = classificarIMC(imc);

        return new ImcResponse(imc, classificacao);
    }

    private String classificarIMC(double imc) {
        if (imc < 16.0) return "Magreza grave";
        if (imc > 16.0 && imc < 16.9) return "Magreza moderada";
        if (imc > 17.0 && imc < 18.4) return "Magreza leve";
        if (imc > 18.5 && imc < 24.9) return "Ideal";
        if (imc > 25.0 && imc < 29.9) return "Sobrepeso";
        if (imc > 30.0 && imc < 34.9) return "Obesidade grau I";
        if (imc > 35.0 && imc < 39.9) return "Obesidade grau II (severa)";
        if (imc > 40.0) return "Obesidade grau III (mórbida)";
        return "Não recebndo dados";
    }

    record ImcResponse(double imc, String classificacao) {}

}
