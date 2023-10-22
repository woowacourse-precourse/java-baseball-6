package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.randomNumberGenerate();
        System.out.println("숫자 야구 게임을 시작합니다.");

        try {
            while (true) {
                System.out.printf("숫자를 입력하세요 : ");
                String inputString = Console.readLine();

                Validation validation = new Validation();
                validation.inputValidation(inputString);

                PitchResult pitchResult = new PitchResult(randomNumber, validation);
                pitchResult.judgePitch(inputString);
                pitchResult.printPitchResult();
                if (pitchResult.getRestartNumber() == 2) {
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("입력이 잘못되었습니다.");
        }
    }
}
