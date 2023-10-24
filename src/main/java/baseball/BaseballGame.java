package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private int[] answer = new int[3];

    private final GameUtils gameUtils;

    //게임을 생성 합니다.
    public BaseballGame(GameUtils gameUtils) {
        this.gameUtils = gameUtils;
    }

    //게임을 실행 합니다.
    public void run() {
        this.answer = gameUtils.generateAnswer();
        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i]);
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            int[] userAnswer = new int[3];
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                char index = input.charAt(i);
                userAnswer[i] = Character.getNumericValue(index);
            }
            if (gameUtils.checkNums(userAnswer)) {
                throw new IllegalArgumentException();
            }

            if (gameUtils.checkAnswer(this.answer, userAnswer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!restart()) {
                    break;
                }
            }
        }
        Console.close();
    }

    //재시작 분기 처리를 진행 합니다.
    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int restart = Integer.parseInt(Console.readLine());
        if (restart != 1 && restart != 2) {
            throw new IllegalArgumentException();
        } else if (restart == 1) {
            this.answer = gameUtils.generateAnswer();
            return true;
        }

        return false;
    }

}
