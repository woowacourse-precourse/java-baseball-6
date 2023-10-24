package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private List<Integer> computerNumber;

    private Printer printer;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    //Printer를 주입 받는 생성자
    public Computer(Printer printer) {
        this.printer = printer;
    }

    //한 게임을 실행하는 기능
    public boolean play() {

        //숫자 생성
        generateNumber();

        //게임 play
        while (true) {

            //숫자를 입력해주세요 :
            printer.printInputMent();

            //입력된 숫자 받기
            String guessString = Console.readLine();

            // *잘못된 값 입력시 예외를 반환하고 종료하는 기능
            List<Integer> guessNumber = checkInputFormat(guessString);

            // *입력한 숫자를 사용해 결과를 반환하는 기능
            boolean isCorrect = checkGuess(guessNumber);

            // 3스트라이크인 경우 break
            if (isCorrect) {
                printer.printFinishMent();
                break;
            }

        }
        //사용자로부터 재시작 숫자 받아서 리턴하기
        return checkReplay();
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
        // 예외 발생가능

        //3자리가 아닌 경우
        if (guessString.length() != 3) {
            throw new IllegalArgumentException();
        }

        //정수가 아닌 경우
        for (int i = 0; i < 3; i++) {
            if (guessString.charAt(i) < '0' || guessString.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }

        //같은 값의 정수가 존재하는 경우
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 3; i++) {
            char testChar = guessString.charAt(i);

            if (set.contains(testChar)) {
                throw new IllegalArgumentException();
            }
            set.add(testChar);
        }

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
            //guessNum의 값을 contain하는지 체크
            //contain한다면, 위치까지 맞는지 체크
            if (computerNumber.contains(guessNumber.get(i))) {
                if (computerNumber.get(i) == guessNumber.get(i)) {
                    strike++;
                    continue;
                }
                ball++;
            }
        }
        //Printer 사용해서 출력
        printer.printResult(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    //정답을 맞췄을 시 사용자의 입력을 받아 재시작을 확인하는 기능
    public boolean checkReplay() {
        String replayNumberString = Console.readLine();
        int replayNumber = -1;

        try {
            replayNumber = Integer.parseInt(replayNumberString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        } finally {
            if (replayNumber == 1) {
                return true;
            }
            if (replayNumber == 2) {
                return false;
            }
            throw new IllegalArgumentException();
        }
    }
}
