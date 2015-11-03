
package druey_3_challenge0;

public class Druey_3_Challenge0  { 

    public static void main(String[] args) { 
         for (int i=0; i<501; i++){
         if(isDivbytwo(i) && isDivbythree(i) && isDivbyfive(i)){
             System.out.println("Team Building");
             }
         else if(isDivbythree(i) && isDivbyfive(i)){
             System.out.println("Old School");
         }
         else if(isDivbytwo(i) && isDivbythree(i)){
             System.out.println("chisme");
         }
         else if(isDivbyeleven(i)){
             if(isDivbytwo(i)){
               System.out.println("ninja");
             }
             else if(isDivbythree(i)){
                 System.out.println("Herr Direktor");
             }
             else if(isDivbyfive(i)){
                 System.out.println("Animate this!");
             }
             
         }
         else if(isDivbytwo(i)){
             System.out.println("Davis");
         }
         
       
         else if(isDivbythree(i)){
             System.out.println("Claughton");
         }
         else if(isDivbyfive(i)){
             System.out.println("Vidal");
         }
         else{
             System.out.println(i);
         }
         }
         
           } 
    static boolean isDivbytwo(int number){
        if(number % 2 == 0){
        return true;
        } else {
            return false;             
        }
    }
    
        static boolean isDivbythree(int number){
        if(number % 3 == 0){
        return true;
           
        }
        else {
            return false;
           
                    
        }
    }
             static boolean isDivbyfive(int number){
        if(number % 5 == 0){
        return true;
           
        }
        else {
            return false;
           
                    
        }
    }
                 static boolean isDivbyeleven(int number){
        if(number % 11 == 0){
        return true;
           
        }
        else {
            return false;
           
                    
        }
    }
}
    