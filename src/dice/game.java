package dice;

public class game {
    int turnsLeft;
    roll first;
    roll second;
    roll third;
    
    public game() {
        this.turnsLeft = 10;
        this.first = new roll();
        this.second = new roll();
        this.third = new roll();
    }
    
    public void subtractTurn() {
        this.turnsLeft -= 1;
    }
    
    public roll first() {
        return this.first;
    }
    
    public roll second() {
        return this.second;
    }
    
    public roll third() {
        return this.third;
    }
}
