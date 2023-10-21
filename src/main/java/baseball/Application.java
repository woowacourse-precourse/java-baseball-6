package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.randomNumberGenerate();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.printf("숫자를 입력하세요 : ");
            String inputString = Console.readLine();
        }
    }
}
