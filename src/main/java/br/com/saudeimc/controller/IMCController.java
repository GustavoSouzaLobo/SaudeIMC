package br.com.saudeimc.controller;

import br.com.saudeimc.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class IMCController {


    Usuario usuario = new Usuario();

    @GetMapping
    public String recebendoNome(){
        usuario.setNome();
        String retorno = "Nome: "+ usuario.getNome();

        return retorno;

    }

//    @GetMapping
//    public void recebendoIdade(Integer idade){
//        user.setIdade(idade);
//    }
//
//    @GetMapping
//    public void recebendoSexo(String sexo){
//        user.setSexo(sexo);
//    }
//
//    @GetMapping
//    public void recebendoAltura(double altura){
//         user.setAltura(altura);
//    }
//
//    @GetMapping
//    public void recebendoPeso(double peso){
//        user.setPeso(peso);
//    }
//
}
