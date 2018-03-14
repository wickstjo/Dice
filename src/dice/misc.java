package dice;

public class misc {
    
    public static int numeric(String input) {
        return Character.getNumericValue(input.charAt(input.length() - 1));
    }
 
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
}
