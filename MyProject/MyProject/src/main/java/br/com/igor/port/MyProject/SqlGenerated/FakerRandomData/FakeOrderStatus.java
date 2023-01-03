package br.com.igor.port.MyProject.SqlGenerated.FakerRandomData;

public class FakeOrderStatus {

    static String[] orderStatus = {
    "INSERT INTO TB_ORDER_STATUS (STATUS) VALUES ('PROCESSING');", 
    "INSERT INTO TB_ORDER_STATUS (STATUS) VALUES ('CANCELED');",
    "INSERT INTO TB_ORDER_STATUS (STATUS) VALUES ('APROVED');"};

public String[] getOrderStatusSql() {
return orderStatus;
}

    
}
