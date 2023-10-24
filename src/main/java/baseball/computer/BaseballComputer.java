package baseball.computer;

import baseball.printer.Printer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballComputer implements Computer {

    private List<Integer> computerNumber;

    private Printer printer;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    //Printer를 주입 받는 생성자
    public BaseballComputer(Printer printer) {
        this.printer = printer;
    }

    //한 게임을 실행하는 기능
    public boolean play() {
        generateNumber();

        while (true) {
            printer.printInputMent();
            String guessString = Console.readLine();

            List<Integer> guessNumber = checkInputFormat(guessString);
            boolean isCorrect = checkGuess(guessNumber);

            if (isCorrect) {
                printer.printFinishMent();
                break;
            }
        }
        //사용자로부터 재시작 숫자 받아서 리턴하기
        String replayNumberString = Console.readLine();
        boolean shouldRestartGame = checkReplay(replayNumberString);
        return shouldRestartGame;
    }

    //랜덤하게 숫자 생성하는 기능
    public void generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerNumber = computer;
    }

    //잘못된 값 입력시 예외를 반환하고 종료하는 기능
    //* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    public List<Integer> checkInputFormat(String guessString) {
        List<Integer> guessNumber = new ArrayList<>();

        //3자리가 아닌 경우 예외 발생
        if (guessString.length() != 3) {
            throw new IllegalArgumentException();
        }

        //정수가 아닌 경우 예외 발생
        for (int i = 0; i < 3; i++) {
            if (guessString.charAt(i) < '0' || guessString.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }

        //같은 값의 정수가 존재하는 경우 예외 발생
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 3; i++) {
            char testChar = guessString.charAt(i);
            if (set.contains(testChar)) {
                throw new IllegalArgumentException();
            }
            set.add(testChar);
        }

        //예외 없는 경우
        for (int i = 0; i < 3; i++) {
            guessNumber.add(guessString.charAt(i) - '0');
        }
        return guessNumber;
    }

    //입력한 숫자를 사용해 결과를 반환하는 기능
    public boolean checkGuess(List<Integer> guessNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == guessNumber.get(i)) {
                strike++;
                continue;
            }

            if (computerNumber.contains(guessNumber.get(i))) {
                ball++;
            }
        }
        printer.printResult(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    //정답을 맞췄을 시 사용자의 입력을 받아 재시작을 확인하는 기능
    public boolean checkReplay(String replayNumberString) {

        //길이가 1이 아닌 경우 예외처리
        if (replayNumberString.length() != 1) {
            throw new IllegalArgumentException();
        }

        //1또는 2인 경우 알맞은 값 반환
        if (replayNumberString.charAt(0) == '1') {
            return true;
        }

        if (replayNumberString.charAt(0) == '2') {
            return false;
        }

        //1또는 2가 아닐 경우 예외처리
        throw new IllegalArgumentException();

    }
}
