package br.gov.sp.cps;

import org.springframework.stereotype.Component;

@Component
public class calcimc{
    public double calcu(double peso, double altura){
        return peso / (altura * altura);
    }
}
