package game;

import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        System.out.println("********************");
        System.out.println("*       Game       *");
        System.out.println("* Guess the number *");
        System.out.println("********************");
        System.out.println("");
        System.out.println("Choose number between 0 to 100");
        System.out.println("");
        System.out.println("You have 10 attempts");
        int RandomNumber, UserInput, tryNumber, wrong , stop = 0;
        boolean play_again = true;
        tryNumber = 1;
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        char c;
        while(play_again){
            System.out.println("Try number " + tryNumber);
            System.out.print("Please choose your number ");
            UserInput = input.nextInt();
            System.out.println("Your number is " + UserInput);
            RandomNumber = (int) (Math.random()*100) + 1; 
            if (RandomNumber == UserInput){
                System.out.println("Good, you get the number from first try");
            } else {
                while(tryNumber <= 10){
                    if (RandomNumber < UserInput){
                        System.out.println("Sorry, your number is too big");
                        tryNumber++;
                        System.out.println("Try number " + tryNumber);
                        System.out.print("Please choose another number ");
                        UserInput = input.nextInt();
                        System.out.println("Your number is " + UserInput);
                    } else if  (RandomNumber > UserInput && tryNumber != 10){
                        System.out.println("Sorry, your number is too small");
                        tryNumber++;
                        System.out.println("Try number " + tryNumber);
                        System.out.print("Please choose another number ");
                        UserInput = input.nextInt();
                        System.out.println("Your number is " + UserInput);
                    } else if (tryNumber == 10){ 
                        System.out.println("Sorry, you have exhausted all opportunities.");
                        System.out.println("The number was " + RandomNumber);
                        System.out.println("");
                        System.out.println("Do you want play again?");
                        System.out.println("Choose Y/N for Yes/No ");
                        c = sc.next().charAt(0);
                        if (c == 'Y' || c == 'y'){
                            System.out.println("Good choose, have a fun.");
                            tryNumber = 1;
                        } else if (c == 'N' || c == 'n'){
                            System.out.println("Goodby, see you later!!");
                            play_again = false;
                        }
                        break;
                    }else {
                        System.out.println("Your get the number after " + tryNumber + " tries");
                        System.out.println("");
                        System.out.println("Do you want play again?");
                        System.out.println("Please choose Y/N for Yes/No ");
                        c = sc.next().charAt(0);
                        while(c != 'y' || c != 'Y' || c != 'n' || c != 'N'){
                            if (c == 'Y' || c == 'y'){
                                System.out.println("Good choose, have a fun.");
                                tryNumber = 1;
                                break;
                            } else if (c == 'N' || c == 'n'){
                                System.out.println("Goodby, see you later");
                                play_again = false;
                                break;
                            } else {
                            }
                        }
                        break;
                    }
                }
                if(tryNumber >= 10){
                    System.out.println("Do you want play again?");
                    System.out.println("choose Y/N for Yes/No ");
                    c = sc.next().charAt(0);
                    if (c == 'Y' || c == 'y'){
                        System.out.println("Good choose, have a fun.");
                        tryNumber = 1;
                        play_again = true;
                    } else if (c == 'N' || c == 'n'){
                        System.out.println("Goodby, see you later");
                        play_again = false;
                    } 
                }
            }
        }
    }
}
