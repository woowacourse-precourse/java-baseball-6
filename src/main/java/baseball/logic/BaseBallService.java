package baseball.logic;

public class BaseBallService {
    public String getGameResult(int computerInput, int userInput) {
        int[] computerInputArray = convertToArray(computerInput);
        int[] userInputArray = convertToArray(userInput);

        int checkStrike = 0;
        int checkBall = 0;
        final String NOTHING = "낫띵";

        for (int i = 0; i < computerInputArray.length; i++) {
            if (computerInputArray[i] == userInputArray[i]) {
                checkStrike += 1;
            } else {
                for (int j = 0; j < computerInputArray.length; j++) {
                    if (computerInputArray[i] == userInputArray[j]) {
                        checkBall += 1;
                    }
                }
            }
        }

        String strikeResult = checkStrike + "스트라이크";
        String ballResult = checkBall + "볼";

        if (checkStrike == 0 && checkBall == 0) {
            return NOTHING;
        }

        if (checkStrike == 0) {
            return ballResult;
        }

        if (checkBall == 0) {
            return strikeResult;
        }

        return ballResult + " " + strikeResult;
    }

    private int[] convertToArray(int number) {
        String numberString = String.valueOf(number);
        int[] array = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            array[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return array;
    }
}
