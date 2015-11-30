package druey_3_guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Druey_3_GuessingGame { //Start of program
    
    
    static int magicnumber;
    static int userguess;
    static String username;
    static Random randy = new Random(10);
    static boolean playagain;
    
    public static void main(String[] args) { //Start of main class
        playagain = true;
        magicnumber = randy.nextInt(10);
        Scanner number = new Scanner(System.in);
        System.out.println("Choose a number between 1 and 10");
        int i = number.nextInt();
        int answer = 101;
        if(answer == i){
            System.out.println("why you do dis");
        }else{
            System.out.println("u ded heh, lol uninstall m8 ur bad");
        Scanner userinputname = new Scanner(System.in);
        Scanner sc = new Scanner (System.in);
        sc.nextInt();
        sc.nextLine();
        username = userinputname.nextLine();
        System.out.println("Hello " + username + " Let's play a game");
        
        /*while(playagain){
            playthegame();
            
            
        } */
        }
        
        
        
    } // End of main class
    
} //End of program
