package br.gov.sp.cps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DecimalFormat;

@SpringBootApplication
@RestController
public class Calc{
    @Autowired
    @Qualifier("calcu")
    private calcimc calc;
    @Autowired
    @Qualifier("clasf")
    private clasfi clasif;
    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/index.html");
    }
    @GetMapping("/{nome}/{peso}/{altura}")
    public RedirectView calcimc(@PathVariable String nome, @PathVariable double peso, @PathVariable double altura, ModelMap model){
        model.addAttribute("nome", nome);
        model.addAttribute("peso", peso);
        model.addAttribute("altura", altura);
        double imc = calc.calcu(peso, altura);
        DecimalFormat df = new DecimalFormat("##.##");
        String Peso = df.format(peso);
        String Altura = df.format(altura);
        String resposta = df.format(imc);
        model.addAttribute("Peso", Peso);
        model.addAttribute("Altura", Altura);
        model.addAttribute("valorIMC", resposta);
        return clasif.clasf(imc, nome, Peso, Altura, resposta);
    }
}
