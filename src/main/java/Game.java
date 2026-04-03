public class Game {
    public void guess(Object o) {
        if(o==null){
            throw new IllegalArgumentException("You must enter a number");
        }
    }
}
