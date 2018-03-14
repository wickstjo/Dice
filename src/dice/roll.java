package dice;

public class roll {
    int value;
    boolean locked;
    
    public roll() {
        this.value = (int) (Math.random() * (6 - 1)) + 1;
        this.locked = false;
    }
    
    public void reroll() {
        this.value = (int) (Math.random() * (6 - 1)) + 1;
    }
    
    public void change() {
        this.locked = true;
    }
    
    public int value() {
        return this.value;
    }
    
    public boolean locked() {
        return this.locked;
    }
}
