public class Game {

    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if(guessNumber.equals(question)){
            return new GuessResult(true,3,0);
        }else{
            return null;
        }
    }

    private void assertIllegalArgument(String guessNumber) {
        if(guessNumber ==null){
            throw new IllegalArgumentException("You must enter");
        }

        if(guessNumber.length() !=3){
            throw new IllegalArgumentException("You must enter THREE number");
        }
        for(char number: guessNumber.toCharArray()){
            if(number<'0'||number>'9'){
                throw new IllegalArgumentException("You must enter a number");
            }
        }

        if(isDuplicatedNumber(guessNumber)){
            throw new IllegalArgumentException("You must not enter same number");
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1) ||
                guessNumber.charAt(0) == guessNumber.charAt(2) ||
                guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
