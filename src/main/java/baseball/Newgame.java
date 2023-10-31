package baseball;

public class Newgame {
    public int newGameCheck(String retry) {
        try {
            if (retry.length() != 1) {
                throw new IllegalArgumentException();
            }
            int newgame = Integer.parseInt(retry);
            if (newgame == 1) {
                return 1;
            } else if (newgame == 2) {
                return 0;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
