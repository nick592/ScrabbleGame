public class Letter {
    
    // class variables
    private char letter;
    private int points;

    public Letter(char letter, int points) throws Exception {

        // only set the letter if it is uppercase and only set points if greater than 0
        if (Character.isUpperCase(letter) && points > 0) {
            this.letter = letter;
            this.points = points;
        } else
            // throw an illegal argument exception if invalid parameters are passed to constructor
            throw new IllegalArgumentException();
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    public boolean equals(Object obj) {

        // attempt to cast object as a Letter type
        try {
            // cast the other object to a letter class
            Letter other = (Letter) obj;
            //boolean isLetter = other.getClass().getName().equals("Letter");

            // if the points and letter of the two objects match, then return true.
            // otherwise, return false
            if (other.points == getPoints() && other.letter == getLetter()) 
                return true; 
            else 
                return false;
        } 
        
        // if the try block fails, return false
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        // this is what is printed when the letter object is printed
        return "Letter: " + getLetter() + " Points: " + getPoints();
    }
}
