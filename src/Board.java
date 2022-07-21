public class Board {

    private Letter[] board;
    private int[] pointMult;

    public Board(int[] multiplier) {
        this.board = new Letter[multiplier.length];
        this.pointMult = multiplier.clone();
    }

    public Letter getLetter(int index) throws Exception {

        boolean withinBounds = index >= 0 && index < board.length;

        if (!withinBounds)
            throw new ArrayIndexOutOfBoundsException();
        
        return board[index];
    }
    
    public int getPointMult(int index) throws Exception {
        boolean withinBounds = index >= 0 && index < board.length;

        if (!withinBounds)
            throw new ArrayIndexOutOfBoundsException();

        return pointMult[index];
    }

    public int getBoardScore() {
        // keep track of the sum of all letter points * their multiplier
        int sum = 0;

        // loop through every letter on the board
        for (int i = 0; i < board.length; i++) {

            if (board[i] != null) {
                // get the points of the letter on the board * the point multiplier at the corresponding index
                int product = board[i].getPoints() * pointMult[i];

                // accumulate the sum using the product
                sum += product;
            }
        }

        //vreturn the sum
        return sum;
    }

    public boolean play(Letter letter, int index) throws Exception {

        boolean withinBounds = index >= 0 && index < board.length;
        
        if (!withinBounds)
            throw new ArrayIndexOutOfBoundsException();

        // if index is within bounds and has no value stored there
        else if (withinBounds && board[index] == null) {
            board[index] = letter;
            return true;
        }

        else 
            return false;
    }

    public boolean fits(String word, int index) {
        int spacesFromIndex = board.length - index;
        if (word.length() > spacesFromIndex)
            return false;
        else 
            return true;
    }

    public int getLetterScore(int index) {

        boolean withinBounds = index >= 0 && index < board.length;

        if (!withinBounds)
            throw new ArrayIndexOutOfBoundsException();

        else if (board[index] == null)
            return 0;
        
        else 
            return board[index].getPoints() * pointMult[index];
    } 

    @Override
    public String toString() {
        return "";
    }

}
