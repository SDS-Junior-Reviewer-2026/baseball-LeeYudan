import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private void getQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
    }

    @Test
    void returnSolvedResultIfMatchedNumber(){
        getQuestion("123");

        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfUnMatchedNumber(){
        getQuestion("123");

        assertMatchedNumber(game.guess("456"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfSomeMatchedNumber(){
        getQuestion("123");
        assertMatchedNumber(game.guess("120"), false, 2, 0);
        assertMatchedNumber(game.guess("061"), false, 0, 1);
        assertMatchedNumber(game.guess("136"), false, 1, 1);
    }

    private void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }


    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            org.junit.jupiter.api.Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }
}
