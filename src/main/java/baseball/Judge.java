package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Judge {
    int[] computerNumbers = createComputerNumber();
    public int[] createComputerNumber() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int tempNum;
            do {
                tempNum = Randoms.pickNumberInRange(1, 9);
            } while (containsNumber(numbers, tempNum));
            numbers[i] = tempNum;
        }
        return numbers;
    }

    public int[] createUserNumber(String userInputStr){
        checkError(userInputStr);
        int userInputNum = Integer.parseInt(userInputStr);
        int[] userInputArr = new int[3];
        userInputArr[0] = userInputNum / 100;
        userInputArr[1] = (userInputNum / 10) % 10;
        userInputArr[2] = userInputNum % 10;
        return userInputArr;
    }

    public String playGame(int[] user) {
        int[] strikeAndBall = calculateStrikeAndBall(user);
        return checkStrikeAndBall(strikeAndBall);
    }

    private int[] calculateStrikeAndBall( int[] user) {
        int[] strikeAndBall = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == user[i])
                strikeAndBall[1]++; // strikes
            else if (containsNumber(computerNumbers, user[i]))
                strikeAndBall[0]++; // balls
        }
        return strikeAndBall;
    }

    public String checkStrikeAndBall(int[] strikeAndBall) {
        String message = switch (strikeAndBall[0]) {
            case 1 -> "1볼 ";
            case 2 -> "2볼 ";
            case 3 -> "3볼 ";
            default -> "";
        };

        message += switch (strikeAndBall[1]) {
            case 1 -> "1스트라이크";
            case 2 -> "2스트라이크";
            case 3 -> "3스트라이크";
            default -> "낫싱";
        };

        return message;
    }

    public boolean isGameEnd(String gameResult) {
        return gameResult.equals("3스트라이크");
    }

    private void checkError(String inputStr){
        if (inputStr.length() != 3)
            throw new IllegalArgumentException();

        int[] inputNumArray = new int[inputStr.length()];

        for (int i = 0; i < 3; i++) {
            int tempIndex = Character.getNumericValue(inputStr.charAt(i));
            if(tempIndex < 1 || tempIndex > 9 || containsNumber(inputNumArray,tempIndex))
                throw new IllegalArgumentException();
            inputNumArray[i] = tempIndex;
        }
    }

    private boolean containsNumber(int[] array, int target) {
        for (int number : array)
            if (number == target)
                return true;
        return false;
    }
}
