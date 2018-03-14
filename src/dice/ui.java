package dice;
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
                System.out.println("\n Lock target/targets number:");
                System.out.print("> ");
                input = scan.nextInt();
                
                while (input < 0 || input > 4) {
                    System.out.println("\nOut of Range. Try again.");
                    System.out.print("> ");
                    input = scan.nextInt();
                }
                
                switch (input) {
                    case 1:
                        first.change();
                    break;
                    case 2:
                        second.change();
                    break;
                    case 3:
                        third.change();
                    break;
                }
                
                System.out.println("Target Locked!\n");
                ui.question(first, second, third);
            break;
            
            case 2:
                System.out.println("Unlock target/targets number:");
            break;
            
            case 3:
                System.out.println("Reroll Initialized");
            break;
            
            default:
                System.out.println("Command not Found.");
            break;
        }
        
    }
    
}
