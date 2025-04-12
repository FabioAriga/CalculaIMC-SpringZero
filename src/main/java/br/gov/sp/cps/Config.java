package br.gov.sp.cps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Config{
    @Bean(name = "calcu")
    public calcimc calcu(){
        return new calcimc();
    }
    @Bean(name = "clasf")
    public clasfi clasf(){
        return new clasfi();
    }
    @Component
    public static class limitclasf{
        public double limiteAbaixo(){
            return 18.5;
        }
        public double limiteIdeal(){
            return 25.0;
        }
        public double limiteSobrepeso(){
            return 30.0;
        }
        public double limiteOb1(){
            return 35.0;
        }
        public double limiteOb2(){
            return 40.0;
        }
    }
}
