package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

import java.time.LocalDate;

public class teste {
    
    public static void main(String[] args) {

//        Faker faker = new Faker();
        
        FakeProduct_Fruit fkF = new FakeProduct_Fruit();

        String nome = "1997-12-23";
        

        LocalDate hoje = LocalDate.parse(nome);
        System.out.println(hoje);


        
        
       System.out.println(fkF.atomicCreateFoodTable());

    

    }
}
