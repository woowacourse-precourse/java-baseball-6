package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}

class Game {
    private int[] computer = new int[3];;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        do {
            // 랜덤 숫자 생성
            computer = random();
            do {
                // 정답을 맞출 때까지 반복
            } while (play(computer));
        } while (again());
    }

    public boolean play(int[] computer) {
        // 사용자의 값을 입력받고, 결과를 출력
        System.out.print("숫자를 입력해주세요 : ");
        int[] user = getInput();
        Result r = new Result(user, computer);
        return r.end();
    }

    public boolean again() {
        // 재시작 여부 확인
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if ("1".equals(userInput)) {
            return true;
        } else if ("2".equals(userInput)) {
            return false;
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public int[] random() {
        // 랜덤한 숫자 세개 생성
        boolean[] isDuplicate = new boolean[10];
        int[] randomNumbers = new int[3];
        int pickNumber;

        for (int i = 0; i < 3; i++) {
            do {
                pickNumber = Randoms.pickNumberInRange(1, 9);
            } while (isDuplicate[pickNumber]);
            randomNumbers[i] = pickNumber;
            isDuplicate[pickNumber] = true;
        }

        return randomNumbers;
    }

    public int[] getInput() {
        // 사용자 값 입력 받기
        int[] user = new int[3];
        String userInput;

        try {
            userInput = Console.readLine();
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
        } catch (IllegalArgumentException e) {
            return null;
        }

        for (int i = 0; i < 3; i++) {
            user[i] = Integer.parseInt(String.valueOf(userInput.charAt(i)));
        }
        return user;
    }

}

class Result {
    private int ball = 0;
    private int strike = 0;
    private int nothing = 0;

    public Result(int[] user, int[] computer) {
        // 사용자 값과 랜덤 숫자 대조
        boolean[] isCorrect = new boolean[10];

        for (int i = 0; i < 3; i++) {
            isCorrect[user[i]] = true;
        }

        for (int i = 0; i < 3; i++) {
            if (user[i] == computer[i]) {
                strike++;
            } else if (isCorrect[computer[i]]) {
                ball++;
            } else {
                nothing++;
            }
        }
    }
    public void printResult() {
        // 결과 출력
        if (nothing == 3) {
            System.out.print("낫싱");
        }
        if (ball > 0 && strike == 0) {
            System.out.print(ball + "볼");
        } else if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public boolean end() {
        // 정답 여부 확인
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        printResult();
        return true;
    }
}