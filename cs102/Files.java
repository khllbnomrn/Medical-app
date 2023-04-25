package app;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

  public void writefileapp(String fname, ArrayList<Appointment> data) {


    try {
      FileWriter pen = new FileWriter(fname);
      for (int i=0; i<data.size();i++)
      {
        pen.write(data.get(i).FiletoString()+"\n");
      }
      
      pen.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


  public void writefileuse(String fname, ArrayList<User> data) {


    try {
      FileWriter pen = new FileWriter(fname);
      for (int i=0; i<data.size();i++)
      {
        pen.write(data.get(i).FiletoString()+"\n");
      }
      
      pen.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public ArrayList<String> ReadFile(String fname){
 

    
    
    int i=0;
    ArrayList<String> data= new ArrayList<String>();
    try {

      File file = new File(fname);
      Scanner fread = new Scanner(file);
      while (fread.hasNextLine()) {
        String line = fread.nextLine();
        data.add(line);
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
