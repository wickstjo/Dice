package dice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ui {
    
    static Scanner scan = new Scanner(System.in);
    
    public static void values(roll first, roll second, roll third) {
        System.out.println("Current Values:\t\t[" + first.value + "][" + second.value + "][" + third.value + "]");
    }
    
    public static void question(roll first, roll second, roll third) {
        
        ui.values(first, second, third);
        
        System.out.println("\n1. Lock target");
        System.out.println("2. Unlock target");
        System.out.println("3. Reroll Unlocked");
        System.out.println("4. Exit Game");
        
        System.out.print("> ");
        int input = scan.nextInt();
        
        switch (input) {
            case 1:
                System.out.println("\nLock element number:");
                System.out.print("> ");
                input = scan.nextInt();
                
                while (input < 0 || input > 4) {
                    System.out.println("\n=> OUT OF RANGE, TRY AGAIN!\n");
                    System.out.print("> ");
                    input = scan.nextInt();
                }
                
                switch (input) {
                    case 1:
                        first.lock();
                    break;
                    case 2:
                        second.lock();
                    break;
                    case 3:
                        third.lock();
                    break;
                }
                
                System.out.println("\n=> ELEMENT #" + input + " LOCKED!\n");
            break;
            
            case 2:
                System.out.println("\nUnlock element number:");
                System.out.print("> ");
                input = scan.nextInt();
                
                while (input < 0 || input > 4) {
                    System.out.println("\nOut of Range. Try again.");
                    System.out.print("> ");
                    input = scan.nextInt();
                }
                
                switch (input) {
                    case 1:
                        first.unlock();
                    break;
                    case 2:
                        second.unlock();
                    break;
                    case 3:
                        third.unlock();
                    break;
                }
                
                System.out.println("\n=> ELEMENT #" + input + " UNLOCKED!\n");
            break;
            
            case 3:
                ArrayList<roll> lista = new ArrayList(Arrays.asList(first, second, third));
                
                for (int x = 0; x < lista.size(); x++) {
                    if (lista.get(x).status() == false) {
                        lista.get(x).reroll();
                    }
                }
                
                System.out.println("\n=> UNLOCKED ELEMENTS REROLLED!\n");
            break;
            
            case 4:
                System.out.println("\n=> APPLICATION KILLED!");
                System.exit(0);
            break;
            
            default:
                System.out.println("\n=> Command not Found. Try again.\n");
            break;
        }
        
        ui.question(first, second, third); 
    }
    
}
