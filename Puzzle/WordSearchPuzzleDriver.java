 /* Project made by;
    Wasim Ghazal Aswad - 17193559
    Miracle Ugwu - 18125883
    Nadine Frawley - 18219659 
    */

import java.util.*;
import java.lang.*;
import java.io.* ; // I took this code from my friend who is in the first year on the electronic engineering department
import javax.swing.JOptionPane; // I took this code from my friend who is in the first year on the electronic engineering department
public class WordSearchPuzzleDriver {

    public static void main(String[] args) {
        System.out.println("R = right \t L = left");
                System.out.println("R = right");
                        System.out.println("R = right");
        String fileName,message= "Please write your file name";
        JOptionPane.showMessageDialog(null,message,"Hello", JOptionPane.PLAIN_MESSAGE);// The GUI is used for the first constructor

        fileName = JOptionPane.showInputDialog("Please type your file name");
        message = fileName;
        JOptionPane.showMessageDialog(null,"your file name is\n"+message,"OK", JOptionPane.PLAIN_MESSAGE);
        loadWordsFromFile(fileName);
//        System.out.println("R = right /t L = left" + /n + "D = down" + \n + "U = up" + \n "the first number is for the row and second number for column");

        System.out.println("**************************************");
        System.out.println("**  calling the first constructor  **");
        System.out.println("**************************************");
        System.out.println("Create the grid of words, place the words randomly and generate random characters with place them\n");
        List<String> Name = loadWordsFromFile(fileName);
        List<WordSearchPuzzle> puzzle = new ArrayList<WordSearchPuzzle>();
        puzzle.add(new WordSearchPuzzle(Name));
     //   (puzzle.get(0)).display();
        System.out.println("_____________________________________________");
        System.out.println("display the word without to show the position\n");
        (puzzle.get(0)).showWordSearchPuzzle(true);
        System.out.println("__________________________________________");
        System.out.println("display the word with showing the position\n");
        (puzzle.get(0)).showWordSearchPuzzle(false);
        System.out.println("***************************************");
        System.out.println("** calling the BasicEnglish.txt file **");
        System.out.println("***************************************");
        System.out.println("generate new puzzle with take same name of the file and take word count from 15 shorter one start from 0 and the longest one 15\n");
        puzzle.add(new WordSearchPuzzle ("BasicEnglish.txt",15 , 0 ,15));
      //  (puzzle.get(1)).display();
        System.out.println("_____________________________________________");
        System.out.println("display the word without to show the position\n");
        (puzzle.get(1)).showWordSearchPuzzle(true);
        System.out.println("__________________________________________");
        System.out.println("display the word with showing the position\n");
        (puzzle.get(1)).showWordSearchPuzzle(false);
        System.out.println("");
        //puzzle = WordSearchPuzzle.WordSearchPuzzle(Name);
        //puzzle.add(new WordSearchPuzzle(Name));

    }

    private static List<String> loadWordsFromFile(String filename) {
        // BasicEnglish.txt - the 850 words of Basic English
        // BNCwords.txt - 5456 words
        try {
            FileReader aFileReader = new FileReader(filename);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            String lineFromFile;
            List<String> words = new ArrayList<String>();
            lineFromFile = aBufferReader.readLine() ;
            while (lineFromFile != null) {  
                if (lineFromFile.length() > 0) {
                    words.add(lineFromFile.toUpperCase());
                }
                lineFromFile = aBufferReader.readLine() ;
            }

            aBufferReader.close();
            aFileReader.close();
            return words ;
        }
        catch(IOException x) {
            return null ;
        }

    }
}
