package baseball;


import camp.nextstep.edu.missionutils.Console;

public class NumbersBaseballManager {
    private NumbersBaseball numbersBaseball = new NumbersBaseball();
    public static String RESTART_CMD = "1";
    public static String FINISH_CMD = "2";
    public void setGameMessage(String startMessage, String finishMessage) {
        numbersBaseball.setMessages(startMessage, finishMessage);
    }
    public void startGame() {
        System.out.println(numbersBaseball.getStartMessage());
        gameLogic();
    }

    private void gameLogic() {
        BaseballInfo baseballInfo = new BaseballInfo(0, 0);
        numbersBaseball.generateAnswer();
        while (!baseballInfo.isThreeStrike()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            NumbersBaseball.validateInput(input);
            baseballInfo = NumbersBaseball.getCompareResultWith(convertToIntArr(input));
            System.out.println(baseballInfo);
            if (baseballInfo.isThreeStrike()) {
                finish();
                return;
            }
        }
    }

    public void finish() {
        System.out.println(numbersBaseball.getFinishMessage());
        String input = Console.readLine();
        if (input.equals(RESTART_CMD)) {
            gameLogic();
        }
    }


    private int[] convertToIntArr(String input) {
        int[] inputArr = new int[3];
        for (int i = 0; i < 3; i++) {
            inputArr[i] = Integer.parseInt(input.charAt(i) + "");
        }
        return inputArr;
    }
}
