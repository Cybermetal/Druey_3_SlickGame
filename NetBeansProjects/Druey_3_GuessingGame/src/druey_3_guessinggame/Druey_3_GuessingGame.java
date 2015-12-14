package druey_3_guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Druey_3_GuessingGame { //Start of program
    
    static Scanner username = new Scanner(System.in);
    static String name;
    static int magicnumber;
    static int userguess;
    
    static Random randy = new Random(10);
    static boolean playagain;
    
    public static void main(String[] args) { //Start of main class
        
        
    
     name = username.nextLine();
              System.out.println("Hello Would you like to play a game?");  
                System.out.println("Whats your name?");
                    System.out.println("Hello" +name+ "Lets begin");
        
   
                playagain = true;
        magicnumber = randy.nextInt(10);
        Scanner number = new Scanner(System.in);
        System.out.println("Choose a number between 1 and 10");
        int i = number.nextInt();
        int answer = 101;
        if(answer == i){
            System.out.println("why you do dis");
        }
        else{
            System.out.println("u ded heh, lol uninstall m8 ur bad");
      //  Scanner userinputname = new Scanner(System.in);
        //Scanner sc = new Scanner (System.in);
        //sc.nextInt();
        //sc.nextLine();    
        }
        
        
        }
}// End of main class
    
 //End of program
