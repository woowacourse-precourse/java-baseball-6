package baseball;

public class GameService {

    GameService() {
    }

    public int[] compareGuessToRandom(UserGuessNumber userGuessNumber, RandomNumber randomNumber) {
        int[] ballAndStrike = new int[2];
        for (int guessNumindex = 0; guessNumindex < userGuessNumber.size(); guessNumindex++) {
            int guessNumber = userGuessNumber.getNumber(guessNumindex);
            if (!randomNumber.isNumberContain(guessNumber)) {
                continue;
            }
            int randNumIndex = randomNumber.findIndex(guessNumber);
            if (randNumIndex == guessNumindex) {
                ballAndStrike[1]++;
            } else if (randNumIndex != guessNumindex) {
                ballAndStrike[0]++;
            }
        }
        return ballAndStrike;
    }
}
