package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
class BullsAndCows {
    int answer;
    boolean checkNumber[];
    public void RandomNumber() {
    checkNumber = new boolean[10];
    int number = 0;
        for (int i = 0; i < 3; i++) {
            int randomNumber = pickNumberInRange(1, 9);
            if (checkNumber[randomNumber]) {
                i--;
                continue;
            }
            number += Math.pow(10, 2 - i) * randomNumber;
            checkNumber[randomNumber] = true;
        }
        answer = number;
    }
    public boolean isCorrect(int input) {
        int ball = 0;
        int strike = 0;
        int inputDigit_1 = input % 10;
        int answerDigit_1 = answer % 10;
        if (inputDigit_1 == answerDigit_1) {
            strike += 1;
        } 
        else if (checkNumber[inputDigit_1]) {
            ball += 1;
        }
        int inputDigit_10 = input % 100 / 10;
        int answerDigit_10 = answer % 100 / 10;
        if (inputDigit_10 == answerDigit_10) {
            strike += 1;
        } 
        else if (checkNumber[inputDigit_10]) {
            ball += 1;
        }
        int inputDigit_100 = input / 100;
        int answerDigit_100 = answer / 100;
        if (inputDigit_100 == answerDigit_100) {
            strike += 1;
        } 
        else if (checkNumber[inputDigit_100]) {
            ball += 1;
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } 
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } 
        else if (strike == 0) {
            System.out.println(ball + "볼");
        } 
        else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }
    public void run() {
        while (true) {
            System.out.printf("숫자를 입력해주세요 : ");
            int input = checkValid(readLine());

            if (isCorrect(input)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    public int checkValid(String input) {
        try {
            int userInput = Integer.parseInt(input);
            if (userInput < 100 || userInput > 999) {
                throw new IllegalArgumentException("Wrong Input");
            }
            return userInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong Input");
        }
    }

}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BullsAndCows game = new BullsAndCows();
        while (true) {
            game.RandomNumber();
            game.run();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = checkInput(readLine());
            if (input == 2) {
                break;
            }
        }
    }
    public static int checkInput(String input) {
        try {
            int userInput = Integer.parseInt(input);
            if (userInput < 1 || userInput > 2) {
                throw new IllegalArgumentException("Wrong Input");
            }
            return userInput;
        } 

        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong Input");
        }
    }
}