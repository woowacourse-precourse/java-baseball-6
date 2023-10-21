package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.LinkedHashSet;


//해결해야 하는거 mvc 다시 이해해서 구성해야함 // 예외 발생시 프로그램 종료한다는걸까먹음
public class BaseballGame {
    private static Iterator<Integer> bNumber = null;
    private static Boolean isGameOn = true;
    private static Boolean newGame = false;

    private static void generateNewNumber() {
        BaseModel.newbaseballNumber();
    }

    private static void newBNumber() {
        bNumber = BaseModel.generateBNumber();
    }

    private static LinkedHashSet<Integer> forUserExCheck(String userNumber) {
        return BaseModel.forUNumberChecking(userNumber);
    }

    private static Iterator<Integer> generateNewUserNumber(LinkedHashSet<Integer> userNumber) {
        return BaseModel.generateUNumber(userNumber);
    }

    private BaseballGame() {
    }

    public final static void turnOn() {
        BaseballOutput.gameStart();
        generateNewNumber();
        newBNumber();
        mainGame();
    }

    private static void mainGame() {
        BaseballOutput.printInputUserNum();
        LinkedHashSet<Integer> userInput = forUserExCheck(inputUserNumber());
        exceptionCheck(userInput);
        printBns(judgeNumber(generateNewUserNumber(userInput)));

        if (!isGameOn) {
            BaseballOutput.printNewOrEnd();
            String userChoice = inputUserNumber();
//            exceptionCheckNewOrEnd(userChoice);
            newOrEnd(userChoice);
            if (newGame) {
                generateNewNumber();
            } else if (!newGame) {
                return;
            }
        }
        newBNumber();
        mainGame();
    }

    private static void newOrEnd(String userChoice) {

        if (userChoice.equals("1")) {
            newGame = true;
            return;
        }
        newGame = false;
    }


    private static String inputUserNumber() {
        String userInputNumber = Console.readLine();
        return userInputNumber;
    }

    //    private static void exceptionCheckNewOrEnd(String userChoice) {
//        if (userChoice.length() != 1 || !userChoice.matches("\\d+")) {
//            throw new IllegalArgumentException("You should input single data");
//        }
//    }
//
    private static void exceptionCheck(LinkedHashSet<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("please input 3 digit");

        }
        for (int i : userNumber) {
            if (i < 1 || i > 9) {
                throw new IllegalArgumentException("please input the exact data");
            }
        }
    }

    private static int[] judgeNumber(Iterator<Integer> uNumber) {
        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        int first = 0;
        int second = 0;
        int strike = 0;

        while (bNumber.hasNext() && uNumber.hasNext()) {
            first = bNumber.next();
            second = uNumber.next();
            System.out.println(first);
            temp.add(first);
            temp.add(second);

            if (first == second) {
                strike++;
            }

        }//6개면 낫싱 5개면..1개 겹침 1스트면 4개면 2개 겹침 3개면 3개 겹침
        return new int[]{(6 - temp.size() - strike), strike};
    }

    private static void printBns(int[] bns) {
        if (bns[0] == 0 && bns[1] == 0) {
            BaseballOutput.printCall();
            return;
        } else if (bns[0] == 0) {
            BaseballOutput.printCall(new StrikeCall(bns[1]));
            if (bns[1] == 3) {
                isGameOn = false;
            }
            return;
        } else if (bns[1] == 0) {
            BaseballOutput.printCall(new BallCall(bns[0]));
            return;
        }
        BaseballOutput.printCall(new BallCall(bns[0]), new StrikeCall(bns[1]));
    }

    //메소드 하나는 게임을 계속할지 말지 결정을 하도록 하고
    //사용자가 1을 누르면 다시 게임이 시작된다.. 그러면 1을 누르거나 2를 받을 메소드도 필요함


}

class BaseballOutput {
    private BaseballOutput() {
    }

    static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printInputUserNum() {
        System.out.println("숫자를 입력해주세요 :");
    }

    static void printCall(BallCount... ballCounts) {
        for (BallCount i : ballCounts) {
            i.print();
        }
    }

    static void printNewOrEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void printCall() {
        System.out.println("낫싱");
    }

}

class StrikeCall implements BallCount {
    int count = 0;

    public StrikeCall(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        System.out.println(count + "스트라이크");
    }
}

class BallCall implements BallCount {
    int count = 0;

    public BallCall(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        System.out.printf("%d볼 ", count);
    }
}

class BaseModel {

    private BaseModel() {
    }

    static LinkedHashSet<Integer> baseballNumber = null;

    static void newbaseballNumber() {
        baseballNumber = NumberGenerator.numberGenerating(3);
    }

    static Iterator<Integer> generateBNumber() {
        return baseballNumber.iterator();
    }

    static LinkedHashSet<Integer> forUNumberChecking(String userNumber) {
        LinkedHashSet<Integer> userNumberRet = new LinkedHashSet<>();
        for (int i = 0; i < userNumber.length(); i++) {
            userNumberRet.add(userNumber.charAt(i) - '0');
        }
        return userNumberRet;
    }

    static Iterator<Integer> generateUNumber(LinkedHashSet<Integer> userNumber) {
        return userNumber.iterator();
    }
}


