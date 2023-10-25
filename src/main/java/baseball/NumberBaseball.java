package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {
    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();

        while (isContinue(readLine())) {
            startGame();
        }
    }

    private void startGame() {
        int[] answers = pickNumberInRange();
        PlayerPartner playerPartner = PlayerPartner.inputAnswerOf(answers);

        playerPartner.startGame();
    }

    private int[] pickNumberInRange() {
        int[] answers = new int[3];

        for (int i = 0; i < 3; i++) {
            answers[i] = Randoms.pickNumberInRange(1, 9);
        }

        return answers;
    }

    private boolean isContinue(String command) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        validateRight(command);

        if (command.equals("1")) {
            System.out.println("1");
            return true;
        }

        endGame();
        return false;
    }

    private void validateRight(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException("잘못된 명령어입니다.");
        }
    }

    private void endGame() {
        System.out.println("게임 종료");
    }


}