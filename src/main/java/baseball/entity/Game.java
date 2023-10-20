package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public Game() {

    }

    // 게임중, 사용자 입력 예외 처리를 위한 함수
    private static void validInputNumber(String inputNumber) {
        // 사용자 입력의 길이가 3이 아니면 예외 처리
        if(inputNumber.length() != 3) throw new IllegalArgumentException();

        // 사용자의 입력이 1~9까지 다른 숫자가 아니라면 예외 처리
        for(int i = 0; i < 3; i++) {
            char currentNumber = inputNumber.charAt(i);
            if (currentNumber < '0' || currentNumber > '9') {
                throw new IllegalArgumentException();
            }
            for(int j = i + 1; j < 3; j++) {
                if (currentNumber == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // 게임종료 후, 사용자 입력 예외 처리를 위한 함수
    private static void validRestartNumber(String restartNumber) {
        // 사용자 입력이 1 또는 2가 아니면 예외 처리
        if(!restartNumber.equals("1") && !restartNumber.equals("2")) throw new IllegalArgumentException();
    }

    // 게임중 입력을 받기 위한 함수
    private static String receiveInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        validInputNumber(inputNumber);

        return inputNumber;
    }

    // 게임 종료후, 입력을 받기 위한 함수
    private static String receiveRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();

        validRestartNumber(restartNumber);

        return restartNumber;
    }

}
