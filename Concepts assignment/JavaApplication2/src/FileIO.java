import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileIO
{
        
    
    //this method is used to open the saveDialog to save the text file of the quiz created
    public static String showSaveDialog() 
    {
        String chosenPath = "";
        
        JFileChooser chooser = new JFileChooser();
        
        
        chooser.setSelectedFile(new File("newQuiz.txt")); //suggest a name
        
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) //user did not click Cancel
        {
            chosenPath = chooser.getSelectedFile().getAbsolutePath();
            return chosenPath;
        }
        else
        {
            return "";
        }     

    }
    
    
    //this method is used to show the openDialog and open the text files.
    public static String showOpenDialog() 
    {
        JFileChooser chooser = new JFileChooser();
        String chosen = "";
        //set file filter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
                    chosen = chooser.getSelectedFile().getAbsolutePath();
                    //open file in chosen path
                    return chosen;
        }
        else
        {
            return "";
        }
    }
    //This method is used to write in the text file
    public static void writeToTextFile(String filePath, String toWrite)
    {
        Path path = Paths.get(filePath);
        
        try 
        {
            BufferedWriter writer = null;
            
            writer = Files.newBufferedWriter(path);

            writer.write(toWrite);
            writer.newLine();

            writer.close();
            
        }
        catch (IOException io)
        {
            System.out.println("Problem while writing to file!");
        }

    }
    
    
    public static String readTextFile(String filePath)
    {
        Path path = Paths.get(filePath);
        
        String write = "";
        
        try 
        {
            BufferedReader reader = null;

            reader = Files.newBufferedReader(path);
            
            String line = null;
            
            while ((line = reader.readLine()) != null) 
            {
               write += line;
            }
            reader.close();
        }
        catch (IOException io)
        {
           System.out.println("Problem while reading file!");            
        } 
        return write;
    }
    
    
} 