package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Play {

    private final User user;
    private final Computer com;
    private final Rules rules;

    public Play() {
        user = new User();
        com = new Computer();
        rules = new Rules();
    }

    public void numberBaseBallGame() {
        startGame();
        runGame();
        restartOrFinishGame();
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        com.setCom();
    }

    private String setInput(String msg) {
        System.out.print(msg);
        String temp = Console.readLine();
        checkInputHasChar(temp);
        return temp;
    }

    private void checkInputHasChar(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("This input is not Integer: " + input);
        }
    }

    private int checkMenuNumber(String input) {
        checkInputHasChar(input);
        int menuNum = Integer.parseInt(input);
        if (menuNum < 1 || menuNum > 2) {
            throw new IllegalArgumentException("Invalid Number: " + menuNum);
        }
        return menuNum;
    }

    private void runGame() {
        while (true) {
            String input = setInput("숫자를 입력해주세요 : ");
            user.setUser(input);
            rules.countBallAndStrikes(user.getUser(), com.getCom());
            if (rules.isThreeStrikes()) {
                rules.printIfAnswer();
                break;
            }
            rules.printIfNotAnswer();
            user.clearUser();
        }
    }

    private void restartOrFinishGame() {
        while (true) {
            String input = setInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int menuNum = checkMenuNumber(input);
            if (menuNum == 1) {
                restartGame();
            } else if (menuNum == 2) {
                finishGame();
                break;
            }
        }
    }

    private void restartGame() {
        user.clearUser();
        com.clearCom();
        com.setCom();
        runGame();
    }

    private void finishGame() {
        System.out.println("숫자 야구 게임을 종료합니다.");
        user.clearUser();
        com.clearCom();
        Console.close();
    }
}
