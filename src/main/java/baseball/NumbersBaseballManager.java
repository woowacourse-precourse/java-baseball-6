package baseball;


import camp.nextstep.edu.missionutils.Console;

public class NumbersBaseballManager {
    private NumbersBaseball numbersBaseball = new NumbersBaseball();
    public static String RESTART_CMD = "1";
    public static String FINISH_CMD = "2";
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String FINSIH_MESSAGE = "게임을 종료합니다.";

    public void gameStart(String startMessage,String finishMessage) {
        System.out.println(startMessage);
        gameLogic(startMessage,finishMessage);
    }

    private void gameLogic(String startMessage,String finishMessage) {
        BaseballInfo baseballInfo = new BaseballInfo(0, 0);
        numbersBaseball.generateAnswer();
        while (!baseballInfo.isThreeStrike()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            NumbersBaseball.validateInput(input);
            baseballInfo = NumbersBaseball.getCompareResultWith(convertToIntArr(input));
            System.out.println(baseballInfo);
            if (baseballInfo.isThreeStrike()) {
                finish(startMessage,finishMessage);
                return;
            }
        }
    }

    public void finish(String startMessage,String finishMessage) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(RESTART_CMD)) {
            gameLogic(startMessage,finishMessage);
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
