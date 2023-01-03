package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

public class FakeCategory {

   static String[] category = {"INSERT INTO TB_CATEGORY (NAME) VALUES ('Eletronics');", 
                         "INSERT INTO TB_CATEGORY (NAME) VALUES ('Book');",
                         "INSERT INTO TB_CATEGORY (NAME) VALUES ('Food');"};

public String[] getcategorySql() {
    return category;
}



    
}
