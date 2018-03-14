package dice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ui {
    private roll first;
    private roll second;
    private roll third;
    private game gameObject;
    
    static Scanner scan = new Scanner(System.in);
    
    public ui(game game) {
        this.first = game.first();
        this.second = game.second();
        this.third = game.third();
        this.gameObject = game;
    }
    
    public void stats() {
        System.out.println("Current Values:\t\t[" + this.first.colorValue() + "][" + this.second.colorValue() + "][" + this.third.colorValue() + "]");
    }
    
    public void turnsLeft() {
        System.out.println("Turns Left:\t\t" + gameObject.turnsLeft());
    }
    
    public void successChance() {
        
        ArrayList<roll> lista = new ArrayList(Arrays.asList(this.first, this.second, this.third));
        int lockedElements = 0;

        for (int x = 0; x < lista.size(); x++) {
            if (lista.get(x).locked == false) {
                lockedElements++;
            }
        }

        double math = Math.pow((1 - Math.pow(5.0 / 6, this.gameObject.turnsLeft())), lockedElements) * 100;
        System.out.println("Chance to Win:\t\t" + misc.round(math, 2) + "%");
    }
    
    public void bundle() {
        
        this.stats();
        this.turnsLeft();
        
        if (this.gameObject.turnsLeft() == 0) {
            System.out.println("\nGame Over - You ran out of turns!");
            
        } else {
            if (this.first.value() == this.second.value() && this.second.value() == this.third.value()) {
                System.out.println("\nYou won with " + this.gameObject.turnsLeft() + " turn(s) left!");

            } else {
                this.successChance();
                this.action();
            }
        }
    }
    
    public void action() {
        
        System.out.print("\nUser Input =>\t\t");
        String input = scan.nextLine();
        
        if (input.length() == 6 && misc.numeric(input) > 0 && misc.numeric(input) < 4) {
            if ("lock ".equals(input.substring(0, 5))) {
                
                switch (misc.numeric(input)) {  
                    case 1:
                        this.first.lock();
                    break;
                    
                    case 2:
                        this.second.lock();
                    break;
                    
                    case 3:
                        this.third.lock();
                    break;
                }
                
                System.out.println("Success:\t\t#" + input.charAt(input.length() - 1) + " Locked!");
                this.stats();
                this.successChance();
                this.action();
            }
        
        } else if (input.length() == 8 && misc.numeric(input) > 0 && misc.numeric(input) < 4) {
            if ("unlock ".equals(input.substring(0, 7))) {
                
                switch (misc.numeric(input)) {  
                    case 1:
                        this.first.unlock();
                    break;
                    
                    case 2:
                        this.second.unlock();
                    break;
                    
                    case 3:
                        this.third.unlock();
                    break;
                }
                
                System.out.println("Success:\t\t#" + input.charAt(input.length() - 1) + " Unlocked!");
                this.stats();
                this.successChance();
                this.action();
            }
            
        } else if (input.equals("roll")) {
            ArrayList<roll> lista = new ArrayList(Arrays.asList(this.first, this.second, this.third));
            
            for (int x = 0; x < lista.size(); x++) {
                if (lista.get(x).locked == false) {
                    lista.get(x).reroll();
                }
            }
            
            this.gameObject.subtractTurn();
            this.bundle();
            
        } else if (input.equals("exit")) {
            System.out.println("Success:\t\tApplication Killed!");
            
        } else {
            System.out.println("Error:\t\t\tSyntax Error. Try again!");
            this.action();
        }
    }
}
