import java.util.*;
import java.io.* ;

public class WordSearchPuzzle {
    private char[][] puzzle ;
    private char[][] onlyWords;
    private List<String> puzzleWords;
    private int puzzleSize;
    private int row,col,direction;
    private int number = 0;

    public WordSearchPuzzle(List<String> userSpecifiedWords) {
        this.puzzleWords = userSpecifiedWords;
        generateWordSearchPuzzle(); 
    }

    public  WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest) {     
        puzzleWords= new ArrayList<String> () ;
        try{
            FileReader aFileReader = new FileReader(wordFile);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            String lineFromFile;
            int i=0;
            lineFromFile = aBufferReader.readLine() ;
            while (lineFromFile != null && i!=wordCount) {

                if((lineFromFile.length()>=shortest) &&(lineFromFile.length() <= longest)) {     

                    puzzleWords.add(lineFromFile.toUpperCase());
                    i++;

                } 

                lineFromFile = aBufferReader.readLine() ;
            }
        }
        catch(Exception E){
            System.out.println("Error!");
        }
      
        generateWordSearchPuzzle(); 
    }

    public void showWordSearchPuzzle(boolean hide){

        if(!hide){
            display(this.puzzle);
            String name ="";
            for (String word : puzzleWords) {
                if(searchLeftToRigth(word)){
                    System.out.println(word + " [" + this.row + "] [" + this.col + "] " + "L");   
                } else if (searchRighttoLeft(word)){
                    System.out.println(word + " [" + this.row + "] [" + this.col + "] " + "R");
                }else if (searchUpToDown(word)){
                    System.out.println(word + " [" + this.row + "] [" + this.col + "] " + "U");
                } else if (searchDownToUp(word)){
                    System.out.println(word + " [" + this.row + "] [" + this.col + "] " + "D");
                }

            }
            System.out.println(name);
        }
        else{
            display(this.puzzle);
            System.out.println(getPuzzleAsString());   
        }
    }
    // --------------------------------
    public List <String> getWordSearchList() {
        // String name="";
        for (String word : puzzleWords) {
            // name = word + "\n";
            System.out.println(word);
        }
        return puzzleWords;
    }

    public char[][] getPuzzleAsGrid () {
      //  display(this.puzzle);

        return puzzle;
    }

    public String getPuzzleAsString() {
        String name ="";
        for (String word : puzzleWords) {
            name =name + word + "\n";
                   }
        return name;
    }

    //---------------------------------------

    
    public void search(String word) {
        System.out.println("Searching for (" + word + ")");

        //Call the other search methods below as needed

        if(searchLeftToRigth(word)){
            System.out.println("left to right " + searchLeftToRigth(word) + " [" + this.row + "] [" + this.col + "]");   
        } else if (searchRighttoLeft(word)){
            System.out.println("right to left " + searchRighttoLeft(word)  + " [" + this.row + "] [" + this.col + "]");
        }else if (searchUpToDown(word)){
            System.out.println("up to down " + searchUpToDown(word) + " [" + this.row + "] [" + this.col + "]");
        } else if (searchDownToUp(word)){
            System.out.println("down to up " + searchDownToUp(word) + " [" + this.row + "] [" + this.col + "]");
        }

    }

    private boolean searchLeftToRigth(String word) {  // I adapted code from https://stackoverflow.com/questions/14888667/word-search-in-java-2d-array
        clear();
        int k = 0;

        for (int i = 0; i < puzzle.length; i++) 
        {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (word.charAt(k) == puzzle[i][j]) {
                    k++;
                    if(k == 1){
                        this.col = j;  
                    }
                } 
                else {
                    k = 0;

                }
                if (k == word.length()) {
                    this.row = i;


                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchRighttoLeft(String word) {  // I adapted code from https://stackoverflow.com/questions/14888667/word-search-in-java-2d-array
        clear();
        String reversedWord = "";
        for (int i = word.length() - 1; i != -1; i--)
        {
            reversedWord += word.charAt(i);
        }

        int k = 0;

        for (int i = 0; i < puzzle.length; i++) 
        {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (reversedWord.charAt(k) == puzzle[i][j]) {
                    k++;
                    if(k == 1){
                        this.col = j;  
                    }
                } 
                else {
                    k = 0;
                }
                if (k == reversedWord.length()) {
                    this.row = i;
                    
                    this.col = this.col + reversedWord.length()-1;
                    return true;
                }
            }
        }

        return false;

    }

    private boolean searchUpToDown(String word) {  // I adapted code from https://stackoverflow.com/questions/14888667/word-search-in-java-2d-array
        clear();
        int k = 0;

        for (int j = 0; j < puzzle.length; j++){
            for (int i = 0; i < puzzle.length; i++){
                if (word.charAt(k) == puzzle[i][j]){
                    k++;
                    if(k == 1){
                        this.col = j; 
                        this.row = i;
                    }
                }else{
                    k = 0;
                }
                if (k == word.length())
                {

                    

                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchDownToUp(String word) {  // I adapted code from https://stackoverflow.com/questions/14888667/word-search-in-java-2d-array
        clear();
        String reversedWord = "";
        for (int i = word.length() - 1; i != -1; i--){
            reversedWord += word.charAt(i);
        }

        int k = 0;
        int store = 0;

        for(int i = 0; i < puzzle.length; i++){
            store = puzzle[i].length;
        }

        for (int j = 0; j < puzzle.length; j++){
            for (int i = 0; i < puzzle.length; i++){
                if (reversedWord.charAt(k) == puzzle[i][j]){
                    k++;
                    if(k == 1){
                        this.col = j; 
                        this.row = i + reversedWord.length()-1;
                    }
                }else{
                    k = 0;
                }
                if (k == reversedWord.length()){

                    
                    this.col = this.col;
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String name, int row, int col, int direction){
        // String temp = name;

        if(direction == 0){ // up to down

            if ((row + name.length()) > puzzle.length ){ // not sure do we need = or only >
                return false;
            }
            for(int i =0 ; i<name.length(); i++){
                if(!(puzzle[row+i][col]=='\u0000')){
                    return false;
                }
            }

        } else if (direction == 1){ // down to up
            if ((row - name.length()) < 0 ){
                return false;
            }
            for(int i = 0 ; i<name.length(); i++){ // is it correct
                if(!(puzzle[row-i][col]=='\u0000')){
                    return false;
                }
            }

        } else if (direction == 2){ // right to left
            if ((col - name.length()) < 0 ){
                return false;
            }
            for(int i =0 ; i<name.length(); i++){ // is it correct
                if(!(puzzle[row][col-i]=='\u0000')){
                    return false;
                }
            }

        } else {// left to right
            if ((col + name.length()) > puzzle.length ){ // not sure do we need = or only >
                return false;
            }
            for(int i =0 ; i<name.length(); i++){ // is it correct
                if(!(puzzle[row][col+i]=='\u0000')){
                    return false;
                }
            }

        }
        return true; 
    }

    private void clear(){
        this.row = 0;
        this.col = 0;  
    }

   

    private void generateWordSearchPuzzle(){

        this.puzzle = new char[creatGrid(this.puzzleWords)][creatGrid(this.puzzleWords)];
        this.onlyWords = new char[creatGrid(this.puzzleWords)][creatGrid(this.puzzleWords)];

        this.puzzleSize = creatGrid(this.puzzleWords);
        display(this.puzzle);
        for (String word : puzzleWords) {
            int row,col,direction;
            do {

                row = (int) (Math.random()*this.puzzleSize);
                col = (int) (Math.random()*this.puzzleSize); 
                direction = (int) (Math.random()*4);

            } while(!check(word, row, col, direction));
            fillUp(word,row,col,direction);

            // TODO insert word into puzzle at row, col
        }
        System.out.println("==========================");
        System.out.println("Placing the words randomly");
        System.out.println("==========================");
        System.out.println("which they are;\n"+puzzleWords.toString());
        display(puzzle);
        //display(onlyWords);
        System.out.println("=====================");
        System.out.println("Add random characters");
        System.out.println("=====================");
        generateRandomChar();
        display(puzzle);

        // System.out.println("========= Without the random characters ============");

        //display(onlyWords);
    }

    private void fillUp(String word,int row, int col , int direction){
        if(direction == 0){ // up to down
            for(int i =0 ; i<word.length(); i++){
                this.puzzle[row+i][col] = word.charAt(i);
                this.onlyWords[row+i][col] = word.charAt(i);
            }
        } else if (direction == 1){ // down to up
            for(int i = 0 ; i<word.length() ; i++){
                this.puzzle[row-i][col] = word.charAt(i);
                this.onlyWords[row-i][col] = word.charAt(i);
            }
        } else if (direction == 2){ // right to left
            for(int i = 0 ; i<word.length(); i++){
                this.puzzle[row][col-i] = word.charAt(i);
                this.onlyWords[row][col-i] = word.charAt(i);
            }
        } else {
            for(int i =0 ; i<word.length(); i++){
                this.puzzle[row][col+i] = word.charAt(i);
                this.onlyWords[row][col+i] = word.charAt(i);
            }
        }
    }

    private void generateRandomChar(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int RandomChar = (int) (Math.random()*alphabet.length()); 
        char temp;
        for (int row = 0 ; row<puzzle.length ;row++){
            for(int col = 0 ; col<puzzle.length ; col++){

                temp = alphabet.charAt(RandomChar);
                RandomChar = (int) (Math.random()*alphabet.length()); 
                if (puzzle[row][col] == '\u0000' || puzzle[row][col] == ' '){
                    puzzle[row][col] = temp;
                }

            }
        }
    }

    private void display(char[][] name) {
        int row, col ;
        for(row = 0 ; row < name.length ; row++) {
            for(col = 0 ; col < name.length ; col++) {
                System.out.print("|"+ name[row][col] + "\t") ;
            }
            System.out.println() ;
        }
        System.out.println() ;
    }

    private int creatGrid(List<String> puzzleWords){
        int sumOfAllWord =0;
        String word;
        for(int i =0; i < this.puzzleWords.size() ;i++){
            word = puzzleWords.get(i);

            sumOfAllWord =sumOfAllWord+ word.length() ;

        }
        sumOfAllWord = (int) (sumOfAllWord *0.25);

        return sumOfAllWord;
    }

}
