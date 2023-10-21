package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Play {

    private final User user;
    private final Computer com;
    private final Rules rules;
    private String input;

    public Play() {
        user = new User();
        com = new Computer();
        rules = new Rules();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        com.setCom();
    }

    private void setInput(String msg) {
        System.out.print(msg);
        input = Console.readLine();
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

    private int checkInputNumber() {
        int temp;
        try {
            temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not Integer: " + input);
        }
        if (temp < 1 || temp > 2) {
            throw new IllegalArgumentException("Invalid Number: " + temp);
        }
        return temp;
    }

    public void restartOrFinishGame() {
        while (true) {
            setInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int menu = checkInputNumber();
            if (menu == 1) {
                restartGame();
            } else if (menu == 2) {
                finishGame();
                break;
            }
        }
    }

    public void runGame() {
        while (true) {
            setInput("숫자를 입력해주세요 : ");
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
}
