import javax.swing.*;
import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();




        int words = 0;
        int lines = 0;
        int character = 0;

        String line;
        Scanner inFile;

        Path file = new File(System.getProperty("user.dir")).toPath();
        file = file.resolve("src");
        chooser.setCurrentDirectory(file.toFile());



        try{


            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                file = chooser.getSelectedFile().toPath();
                inFile = new Scanner(file);
                System.out.println("File: " + file.getFileName());





                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    lines++;
                    character += line.length();
                    words += new StringTokenizer(line, ",").countTokens();



                }
                inFile.close();
                System.out.printf("Lines: %d\nWords: %d\nCharacters: %d\n", lines, words, character);

            }
            else
            {
                System.out.println("You have to select a file ");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }




    }
}