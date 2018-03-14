package dice;

public class Dice {
    public static void main(String[] args) {
        
        game game = new game();
        ui ui = new ui(game);
        
        ui.bundle();
    }
}
