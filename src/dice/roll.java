package dice;

public class roll {
    private int value;
    boolean locked;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    public roll() {
        this.value = (int) (Math.random() * (6 - 1)) + 1;
        this.locked = false;
    }
    
    public void reroll() {
        this.value = (int) (Math.random() * (6 - 1)) + 1;
    }
    
    public void lock() {
        this.locked = true;
    }
    
    public void unlock() {
        this.locked = false;
    }
    
    public int value() {
        return this.value;
    }
    
    public String colorValue() {
        if (this.locked == true) {
            return ANSI_GREEN + this.value + ANSI_RESET;
        } else {
            return ANSI_RED + this.value + ANSI_RESET;
        }
    }
    
    public boolean status() {
        return this.locked;
    }
}
