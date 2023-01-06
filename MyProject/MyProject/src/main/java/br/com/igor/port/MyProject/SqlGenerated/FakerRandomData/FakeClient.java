package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

import java.text.SimpleDateFormat;
import java.util.Random;

import net.datafaker.Faker;

public class FakeClient {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

    private static Faker faker = new Faker();

    private static Random aleatorio = new Random();

    private String name;

    private String email;

    private String date;

    private void name() {
    
        name = faker.name().firstName();
    }

    private void email() {
        int num = aleatorio.nextInt(1,4);
        email = this.name + randomEmailDomain(num);

        
    }

    private void Date() {
        date = sdf.format(faker.date().birthday());
    }

    public String atomicClient() {
        name();
        email();
        Date();

        String str = "INSERT INTO TB_CLIENT (name, birthday, email) VALUES ('"+name+"', '"+ date + "', '" + email + "');";
        return str;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    private String randomEmailDomain(int num) {
        switch (num) {
            case 1:
                return "@outlook.com";

            case 2:
                return "@gmail.com";

            case 3:
                return "@yahoo.com";

            default:
                return "@live.com";

        }
    }

}
