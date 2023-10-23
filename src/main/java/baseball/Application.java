package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.randomNumberGenerate();
        System.out.println("숫자 야구 게임을 시작합니다.");
        PitchResult pitchResult = new PitchResult(randomNumber);

        while (true) {
            System.out.printf("숫자를 입력하세요 : ");
            String inputString = Console.readLine();
            InputRange.inputValidation(inputString);

            pitchResult.judgePitch(inputString);
            pitchResult.printPitchResult();

            if (pitchResult.getStrike() == PitchRange.MAX_STRIKES.getValue()) {
                int gameOption = Integer.parseInt(Console.readLine());
                GameOption.gameOptionValidation(gameOption);
                if (gameOption == GameOption.RESTART_GAME.getOption()) {
                    randomNumber.randomNumberGenerate();
                }
                if (gameOption == GameOption.QUIT_GAME.getOption()) {
                    break;
                }
            }
            pitchResult.pitchClear();
        }

    }
}

