package WincentsFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WincentsFiles {
    String fileName= "words.txt";
    File myFileObject;

    public WincentsFiles(){
        createFile(); //creates a file
        //write2File(); //Writes to a file
        readFromFile();
    }

    private void readFromFile() {
        try {
            Scanner myFileScanner = new Scanner(myFileObject);
            while(myFileScanner.hasNext()) {
                System.out.println(myFileScanner.nextLine());
            }
        }catch (IOException e){
            System.out.println("Kunde inte läsa från filen");
        }

    }

    private void write2File() {
        try {
            FileWriter myWriterObject = new FileWriter(fileName,true);
            Scanner myKeyScanner= new Scanner(System.in);
            System.out.println("Vad vill du skriva i filen?");
            myWriterObject.write(myKeyScanner.nextLine());
            myWriterObject.close();
            System.out.println("Jag skrev till filen " + fileName);
        }catch(IOException e){
            System.out.println("Kunde inte skriva till filen");
        }
    }

    public void createFile(){
        myFileObject= new File(fileName);
        try {
            if (myFileObject.createNewFile()){
                System.out.println(fileName + " har skapats");
            }else {
                System.out.println(fileName + " existerar redan");
            }

        }catch (IOException ioErr){
            System.out.println("Filen kunde inte skapas");

        }catch(Exception generalException){
            System.out.println("Något gick fel");
        }

    }



}
