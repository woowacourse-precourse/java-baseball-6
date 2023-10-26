package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Inspection {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.playGame();
    }
    public void askForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String input = Console.readLine();
            int choice = Integer.parseInt(input);
            if (choice == 1) {
                Application.main(new String[0]); // main 재시작 명령
            } else if (choice == 2) {
                System.out.print("게임을 종료합니다.");
            } else {
                System.out.print("1 또는 2만 입력하세요.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("입력 오류: 값을 읽을 수 없습니다. 다시 시도하세요.");
        }
    }
    public int[] getUserInput() {
        int[] userNumbers = new int[3];
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (input.equals("1") || input.equals("2")) {
                    System.out.println("1 또는 2는 게임을 재시작/종료 명령어입니다. 3자리 숫자를 입력해주세요.");
                    continue;
                }
                if (input.length() != 3) {
                    throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
                }
                for (int i = 0; i < 3; i++) {
                    userNumbers[i] = Integer.parseInt(input.substring(i, i + 1));
                    if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                        throw new IllegalArgumentException("1에서 9까지의 숫자만 입력 가능합니다.");
                    }
                }
                if (hasDuplicate(userNumbers)) {
                    throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다.");
                }
                return userNumbers;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
    private boolean hasDuplicate(int[] userNumbers) {
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = i + 1; j < userNumbers.length; j++) {
                if (userNumbers[i] == userNumbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
