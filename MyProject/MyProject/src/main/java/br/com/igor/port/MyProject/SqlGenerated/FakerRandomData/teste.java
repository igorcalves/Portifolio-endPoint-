package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

import net.datafaker.Faker;

public class teste {
    
    public static void main(String[] args) {

        Faker faker = new Faker();
        
        FakeClient fk = new FakeClient();

        
       System.out.println(faker.food().ingredient());

    }
}
