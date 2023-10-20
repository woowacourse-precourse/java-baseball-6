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
        com.getIntArray();
    }

    public void getInput(String msg) {
        System.out.print(msg);
        input = Console.readLine();
    }

    public void restartOrFinishGame() {
        while (true) {
            getInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            if (input.equals("1")) {
                com.clearList();
                com.getIntArray();
                runGame();
            }
            if (input.equals("2")) {
                System.out.println("숫자 야구 게임을 종료합니다.");
                Console.close();
                break;
            }
        }
    }

    public void runGame() {
        while (true) {
            // 사용자 입력
            getInput("숫자를 입력해주세요 : ");
            user.getIntArray(input);
            // 스트라이크, 볼 개수 구하기
            rules.countBallAndStrikes(com.getList(), user.getList());
            // 결과 출력
            if (rules.isThreeStrikes()) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            rules.printBallAndStrikes();
            user.clearList();
        }
    }
}
