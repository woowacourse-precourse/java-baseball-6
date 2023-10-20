package baseball;

public class NumberBaseball {

    public int[] create(String userInputStr){
        checkError(userInputStr);
        int userInputNum = Integer.parseInt(userInputStr);
        int[] userInputArr = new int[3];
        userInputArr[0] = userInputNum / 100;
        userInputArr[1] = (userInputNum / 10) % 10;
        userInputArr[2] = userInputNum % 10;
        return userInputArr;
    }

    public boolean playGame(int[] computer, int[] user){
        int[] strikeAndBall = new int[2];
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computer[i] == user[i])
                strikes++;
            else if (containsNumber(computer, user[i]))
                balls++;
        }

        strikeAndBall[0] = balls;
        strikeAndBall[1] = strikes;

        new InputAndOutput().checkInputNumber(strikeAndBall);

        return strikes == 3 ? false : true;
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

    public boolean containsNumber(int[] array, int target) {
        for (int number : array)
            if (number == target)
                return true;
        return false;
    }
}
