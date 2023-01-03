package br.com.igor.port.MyProject.SqlGenerated;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.igor.port.MyProject.SqlGenerated.FakerRandomData.FakeCategory;
import br.com.igor.port.MyProject.SqlGenerated.FakerRandomData.FakeClient;
import br.com.igor.port.MyProject.SqlGenerated.FakerRandomData.FakeOrderStatus;


public class CreateFile {

  public static void main(String[] args) throws IOException {
      File file = new File("C:/Users/jbq.ilhsad02/Desktop/CDM/portifolio/MyProject/MyProject/src/main/resources/data.sql");
      BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
      
      
      try{
          file.createNewFile();
          
        }catch(IOException io){
            io.printStackTrace();
        }
        
        
        //
        //CATEGORY
        //
        FakeCategory fakeCategory = new FakeCategory();
        String[] i = fakeCategory.getcategorySql();

        for (int j = 0; j < i.length; j++) {
            bfw.write(i[j]);
            bfw.newLine();
        }

        //
        //CLIENT
        //
        FakeClient fakeClient = new FakeClient();
        for (int j = 0; j < 50; j++) {
            bfw.write(fakeClient.atomicClient());
            bfw.newLine();
        }

        //
        //ORDERSTATUS
        //
        FakeOrderStatus fakeOrderStatus = new FakeOrderStatus();

        String[] fk = fakeOrderStatus.getOrderStatusSql();

        for (int j = 0; j < i.length; j++) {
            bfw.write(fk[j]);
            bfw.newLine();
        }
   


    System.out.println("fim");
    bfw.close();
    

}
}