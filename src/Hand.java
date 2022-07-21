public class Hand {
    static int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    public Hand() {
        this.size = MAX_SIZE;
        this.hand = new Letter[this.size];
    }

    public Hand(int size) {

        if (size > MAX_SIZE) 
            this.size = MAX_SIZE;

        else if (size <= 0)
            this.size = 0;

        else 
            this.size = size;

        this.hand = new Letter[this.size];
    }

    public int getSize() {
        return size;
    }

    public Letter getLetter(int index) {
        return hand[index];
    }

    public boolean insert(Letter letter, int index) throws Exception {

        // index is not less than zero or greater than the length of hand
        boolean withinBounds = index >= 0 && index < hand.length;

        if (!withinBounds)
            throw new ArrayIndexOutOfBoundsException();

        // if the inputted index is within bounds, and has no letter in it then set store the letter in that index and return true
        else if (withinBounds && hand[index] == null) {

            // set value at index to letter
            hand[index] = letter;

            // return true to indicate successful insertion
            return true;
        } 

        else
            return false;
    }

    public Letter remove(int index) throws Exception {

        // index is not less than zero or greater than the length of hand
        boolean withinBounds = index >= 0 && index < hand.length;

        if (!withinBounds) 
            throw new ArrayIndexOutOfBoundsException();
        
        else if (withinBounds && hand[index] != null) {

            // store the removed value in a variable
            Letter removedValue = hand[index];

            // remove the letter at the given index
            hand[index] = null;

            return removedValue;
        } 

        else
            return null;
    }

    public int indexOf(char letter) {

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && hand[i].getLetter() == letter) 
                return i;
        }

        return -1;
    }

    public boolean canForm(String word) throws Exception {

        // if the word is null, throw an exception
        if (word == null)
            throw new NullPointerException();

        // keep track of whether the letters of the word are contained in the hand
        int sum = 0;

        int handCount = 0;
        
        // convert the word to a character array
        char lettersInWord[] = word.toCharArray();

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) 
                handCount += 1;
        }

        if (handCount >= lettersInWord.length) {

            // check if each character is contained of the word is contained in the hand
            for (char c : lettersInWord) {
                if (indexOf(c) > -1)
                    sum++;
            }
    
            if (sum == lettersInWord.length)
                return true;
            else
                return false;
        } 

        else 
            return false;
    } 

    @Override 
    public String toString() {

        String returnString = "";

        for (int i = 0; i < hand.length; i++) {

            // if the current hand position has no letter in it, add a dash
            if (hand[i] == null) 
                returnString += String.format("%d: -\n", i);
            else
                returnString += String.format("%d: %s\n", i, hand[i].toString());
        }

        return returnString;
    }

}
