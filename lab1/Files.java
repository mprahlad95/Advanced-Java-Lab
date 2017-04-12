import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files {

   public static void main(String args[]){
     		
      try{
         File file=new File("E:\\130911390\\file.txt");
        FileReader fr= new FileReader(file);
              }
      
      catch(IOException e){
          e.printStackTrace();
       }
   }
       
       }
    