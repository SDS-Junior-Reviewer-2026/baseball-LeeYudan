public class Game {
    public void guess(String guessNumber) {
        if(guessNumber==null){
            throw new IllegalArgumentException("You must enter a number");
        }

        if(guessNumber.length() !=3){
            throw new IllegalArgumentException("You must enter THREE number");
        }
    }
}
