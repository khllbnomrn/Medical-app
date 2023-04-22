package app;
import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 


public class initializing_Files {
 

 public void initializing_Files();

 public void createfile(String fname)
    try {
      File file = new File(fname);
      if (file.createNewFile()) {
        System.out.println("File created: "+ fname);
      else{ System.out.println("file already exists");}
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
public void writefile(File file, String data) {


    try {
      FileWriter pen = new FileWriter(fname);
      pen.write(data);
      pen.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}

  public String[] ReadFile(File file){
 
    String[] data = new String[1000];
    try {
      
      Scanner fread = new Scanner(file);
      int i=0;
      while (fread.hasNextLine()) {
        String line = fread.nextLine();
        data[i]=line;
        i++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return data;
  }
}
}