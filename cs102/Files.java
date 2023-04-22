package app;
import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.io.*;


public class Files {
 

 public Files() {}

 public void createfile(String fname){
    try {
      File file = new File(fname);
      if (file.createNewFile()) {
        System.out.println("File created: "+ fname);}
      else{ System.out.println("file already exists");}
    } catch (final IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
  public void writefile(String fname, User[] data) {


    try {
      FileWriter pen = new FileWriter(fname);
      for (int i=0; i<data.length;i++)
      {
        pen.write(data[i].FiletoString()+"\n");
      }
      
      pen.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public String[] ReadFile(String fname){
 

    String[] data = new String[1000];
    try {
      
      File file = new File(fname);
      Scanner fread = new Scanner(file);
      int i=0;
      while (fread.hasNextLine()) {
        String line = fread.nextLine();
        data[i]=line;
        i++;
      }
      fread.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return data;
  }
}
