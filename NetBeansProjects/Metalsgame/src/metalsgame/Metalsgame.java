/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalsgame;

import java.util.Scanner;

/**
 *
 * @author Cybermetal
 */
public class Metalsgame {
    static int useractions;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Your home planet, Koppai, is running out of food supply due to over population.");
        System.out.println("The leaders of your planet select you and two other trained space explorers to go out to a different planet to find food supply");
        System.out.println("As you explore, you find a planet with edible matter.");
        System.out.println("You crash land on this mysterious planet, in which you named PNF-404, and your ship was preserved, but your other crew members scattered throughout the planet.");
        System.out.println("What will you do?");
        System.out.println("1: Get up you fool! You need to get up and search for your other crew members!!");
        System.out.println("2: Nah. You can just lay there and your other captains will surely find you.");
        Scanner userinput = new Scanner(System.in);
        useractions= userinput.nextInt();
        if(useractions == 2){
            System.out.println("Jokes on you, your other crew members have been knocked out, and are unconscious.");
            System.out.println("They have also been put into force sleep mode by their space suits, so they are unable to find you, and you all die. Great.");
        }
            
            if(useractions == 1){
        System.out.println("Good thing you got up. Sadly, however, you run into another problem. Your life support system runs out in 30 days, so you MUST hurry!");
            }
        System.out.println("You find an almost extinct species of alien on the planet, and it seemingly is willing to obey and follow your commands. They seem to be part animal, and part plant... and are very small, only roughly a centemeter in height, like yourself! It resembles a carrot, is red and has a nose with two beady eyes.");
        System.out.println("You decide to give it a name, what will you call this species?");
                Scanner alien = new Scanner(System.in);
        String alienname = alien.nextLine();
        System.out.println("You have named it "+alienname+", and you have found ways to make more of them.");
        System.out.println("You have made 50 "+alienname+"'s, so you and your new army go out and find a hostile creature, at which it charges at you.");
        System.out.println("What will you do?");
        System.out.println("1: You use your new army of "+alienname+"'s to attack it.");
        System.out.println("2: You turn back and run away.");
        useractions= userinput.nextInt();
        if(useractions == 1){
        System.out.println("You and your army of "+alienname+"'s attack it, and kill it.");
        }
        System.out.println("Your "+alienname+"'s take the carcass of the enemy you've just slain, and they take it back to their ship, and they sprout more "+alienname+"'s.");
        System.out.println("You have doubled the amount of "+alienname+"'s you have, leading you to have exactly 100 red "+alienname+"'s.");
        System.out.println("It is now the end of the day. You MUST get off the planets surface, as the hostile creatures will come out at night and they WILL kill you");
        
        if(useractions == 2){
            System.out.println("You have decided to turn back and run away. You've doomed half of your amy of "+alienname+"'s do die, you fool!");
            System.out.println("It is now the end of the day. You MUST get off the planets surface, as the hostile creatures will come out at night and they WILL kill you");
        }
          System.out.println("What will you do?");
          System.out.println("1: Take off in your ship and stay in the planets atmosphere over night");
          System.out.println("2: Stay here on PNF-404's surface and risk being eaten alive by the deadly nocturnal creatures.");
          useractions= userinput.nextInt();
          if (useractions == 1){
              System.out.println("Smart move, you go into your ship and fly up into the planets atmosphere, and the "+alienname+"'s follow you up there.");
              System.out.println("You get rest, and it becomes daytime. You land back on the surface and begin your day in attempt to find food, and your captains.");
          }
          if(useractions == 2){
         System.out.println("You stayed on the planets surface RISKING YOUR LIFE LIKE A DUMDUM!");
         System.out.println("Luckily, however, you're still alive. To your dismay, though, you have lost HALF of your army of "+alienname+"'s.");
         
         System.out.println("You have an opportunity to raise up your army of "+alienname+"'s, will you take it?");
         System.out.println("1: Heckles yeah!");
         System.out.println("2: Nah.");
         useractions= userinput.nextInt();
         if(useractions == 1);
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
            
            }

        
        
    }
}
            