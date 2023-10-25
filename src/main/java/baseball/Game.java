package baseball;

public class Game {

    public void play(String answer) {

        int success = 0;

        while (success != 1) {
            success = Compare.comp(Input.inFir(), answer);
        }

    }


}
