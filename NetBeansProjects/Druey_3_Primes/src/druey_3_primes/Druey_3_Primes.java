/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package druey_3_primes;

/**
 *
 * @author Cybermetal
 */
public class Druey_3_Primes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  int evens = 0;
        for(int i = 0; i < 100;i++) {
            if(i % 2 == 0){
                evens++;
            }
         
        }
     System.out.println("I ate " + evens + " wafflez");
             
    }
       
    //What is a Method?!?!?!?
    //A Method is like a little program, e.g.
    //Like finding a square root, something you might want to do again and again
        
   static boolean isEven (int somenumber) {
       //A return value is the type of value you're giving back to the program
       return(somenumber % 2 == 0);
   }
   static boolean isOdd (int somenumber) {
       return (somenumber % 2 != 0);
   }
   static boolean isPrime (int somenumber) {
       int divisors = 0;
       for(int i = 2; i < somenumber; i++) {
           if(somenumber % i == 0) {
               divisors += 1;
           }
       }
       if(divisors > 0){ 
           return false;
       } else {
           return true;
       }
           
   }
}
