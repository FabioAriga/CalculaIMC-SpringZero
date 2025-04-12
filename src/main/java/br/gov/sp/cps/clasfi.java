package br.gov.sp.cps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

@Component
public class clasfi{
    @Autowired
    private Config.limitclasf limites;
    public RedirectView clasf(double imc, String nome, String Peso, String Altura, String resposta){
        if(imc < limites.limiteAbaixo()){
            return new RedirectView("/abaixo.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        } else if (imc < limites.limiteIdeal()) {
            return new RedirectView("/ideal.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        } else if (imc < limites.limiteSobrepeso()) {
            return new RedirectView("/sobrepeso.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        } else if (imc < limites.limiteOb1()) {
            return new RedirectView("/ob1.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        } else if (imc < limites.limiteOb2()) {
            return new RedirectView("/ob2.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        } else {
            return new RedirectView("/ob3.html?nome=" + nome + "&peso=" + Peso + "&altura=" + Altura + "&imc=" + resposta);
        }
    }
}
