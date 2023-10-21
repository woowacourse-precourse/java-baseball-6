package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.InputClass.extractRandomNumber;
import static baseball.Application.InputClass.inputUserNumber;
import static baseball.Application.PrintPackage.printGameStartMessage;
import static baseball.Application.PrintPackage.printRequestNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }
    public static void gameStart() {
        printGameStartMessage();
        List<Integer> computer = extractRandomNumber();
        while(compare(computer, inputUserNumber())){

        }
    }

    private static Boolean compare(List<Integer> computer, List<Integer> user) {
        return Boolean.TRUE;
    }
    public class PrintPackage {
        public static void printGameStartMessage() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        public static void printRequestNumber() {
            System.out.print("숫자를 입력해주세요 : ");
        }
    }
    public class InputClass {
        static List<Integer> extractRandomNumber() {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
        }
        public static List<Integer> inputUserNumber() {
            printRequestNumber();
            String readLine = Console.readLine();
            List<Integer> user = new ArrayList<>();
            for( int i = 0 ; i < readLine.length(); i++) {
                user.add(readLine.indexOf(i));
            }
            return user;
        }
    }
}
