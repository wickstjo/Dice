package dice;

public class game {
    private int turnsLeft;
    private roll first;
    private roll second;
    private roll third;
    
    public game() {
        this.turnsLeft = 10;
        this.first = new roll();
        this.second = new roll();
        this.third = new roll();
    }
    
    public int turnsLeft() {
        return this.turnsLeft;
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
