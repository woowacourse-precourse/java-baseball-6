package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class UserNumber {
    private List<Integer> userAnswer = new ArrayList<>();

    public UserNumber() {
    }

    public List<Integer> set() {
        String input = Console.readLine();
        System.out.println(input);
        checkInputError(input);
        this.userAnswer = stringToList(input);
        return this.userAnswer;
    }

    public List<Integer> get() {
        return this.userAnswer;
    }

    private List<Integer> stringToList(String number) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            String oneNum = number.substring(i, i + 1);
            Integer oneNumInt = Integer.parseInt(oneNum);
            ret.add(oneNumInt);
        }
        return ret;
    }

    private void checkInputError(String input) {
        String[] inputArray = input.split("");

        if (checkNullError(inputArray) || checkLengthError(inputArray, 3) || checkNumericError(inputArray)
                || checkEach1to9Error(inputArray)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNullError(String[] input) {
        if (input == null || input.length == 0) {
            return true;
        }
        return false;
    }

    private boolean checkLengthError(String[] userInput, int length) {
        if (userInput.length != length) {
            return true;
        }
        return false;
    }

    private boolean checkNumericError(String[] userInput) {
        try {// 숫자형식으로 변환 시 예외 발생 여부
            for (String n : userInput)
                Integer.decode(n);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean checkEach1to9Error(String[] userInput) {
        for (String userInputChar : userInput) {// 1~9 확인
            char c = userInputChar.charAt(0);
            if (c < '1' || c > '9') {
                return true;
            }
        }
        return false;
    }

}

class ComNumber {
    private List<Integer> comAnswer = null;

    ComNumber() {
        this.comAnswer = newNumber();
    }

    List<Integer> newNumber() {
        List<Integer> newNumber = new ArrayList<>();

        while (newNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newNumber.contains(randomNumber)) {
                newNumber.add(randomNumber);
            }
        }
        this.comAnswer = newNumber;
        return this.comAnswer;
    }

    List<Integer> get() {
        return this.comAnswer;
    }
}

class Game {

    private void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private int countStrike(List<Integer> userNumber, List<Integer> comNumber) {// 스트라이크 개수 확인
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            Integer user = userNumber.get(i);
            Integer com = comNumber.get(i);
            if (user == com) {
                ret++;
            }
        }
        return ret;
    }

    private int countBall(List<Integer> userNumber, List<Integer> comNumber) {// 볼 개수 확인
        int ret = 0;

        for (int i = 0; i < userNumber.size(); i++) {
            Integer userNumber1 = userNumber.get(i);
            for (int j = 0; j < comNumber.size(); j++) {
                Integer comNumber1 = comNumber.get(j);
                if (i != j && userNumber1 == comNumber1) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private int printResult(List<Integer> userNumber, List<Integer> comNumber) { // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
        int strikeCnt = countStrike(userNumber, comNumber);
        int ballCnt = countBall(userNumber, comNumber);
        if (ballCnt > 0) {
            System.out.print(ballCnt + "볼");
        }
        if (strikeCnt > 0) {
            if (ballCnt > 0) {
                System.out.print(" ");
            }
            System.out.print(strikeCnt + "스트라이크");
        } else if (strikeCnt == 0 && ballCnt == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return strikeCnt;
    }

    private void checkRestartInputError(String restartInput) throws IllegalArgumentException {
        List<String> correctAnswer = List.of("1", "2");
        if (correctAnswer.contains(restartInput) == false) {
            throw new IllegalArgumentException();
        }
    }

    private boolean askContinue() {// 재시작여부 입력 받기
        boolean ret = false;
        String userInput = Console.readLine();
        checkRestartInputError(userInput);
        if (userInput.compareTo("1") == 0) {
            ret = true;
        } else if (userInput.compareTo("2") == 0) {
            ret = false;
        }
        return ret;
    }

    public void play() {
        printStart();
        boolean continueGame = true;
        UserNumber userNumber = new UserNumber();
        ComNumber comNumber = new ComNumber();
        List<Integer> comNumberList = comNumber.get();
        while (continueGame) {
            printInput();
            userNumber.set();
            List<Integer> userNumberList = userNumber.get();
            printResult(userNumberList, comNumberList);

            int cnt = countStrike(userNumberList, comNumberList);
            if (cnt == 3) {
                printRestart();
                continueGame = askContinue();
            }
            if (cnt == 3 && continueGame) {
                comNumber.newNumber();
                comNumberList = comNumber.get();
            }
        }
    }

}

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.play();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
