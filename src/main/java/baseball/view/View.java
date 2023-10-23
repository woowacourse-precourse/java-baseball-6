package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        //예외 확인
        if (!checkDigit(number)) {
            throw new IllegalArgumentException("자릿수가 3보다 작거나 큽니다.");
        }
        if (!checkCharacterOrZero(number)) {
            throw new IllegalArgumentException("1~9사이의 숫자를 입력해야합니다.");
        }
        if (!checkSameNumber(number)) {
            throw new IllegalArgumentException("동일한 숫자는 입력하시면 안됩니다.");
        }
        return number;
    }

    public void printResult(int cntStrike, int cntBall) {
        if (cntStrike == 0 && cntBall == 0) {
            System.out.println("낫싱");
        } else if (cntStrike == 0) {
            System.out.println(cntBall + "볼");
        } else if (cntBall == 0) {
            System.out.println(cntStrike + "스트라이크");
        } else {
            System.out.println(cntBall + "볼 " + cntStrike + "스트라이크");
        }
    }

    public void printCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean inputRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        //예외 확인
        if (!checkRestartNumber(number)) {
            throw new IllegalArgumentException("1과 2이외의 값은 입력하시면 안됩니다.");
        }
        if (Integer.parseInt(number) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkDigit(String number) {
        if (number.length() > 3 || number.length() < 3) {
            return false;
        }
        return true;
    }

    public boolean checkCharacterOrZero(String number) {
        char[] chs = number.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < 49 || chs[i] > 57) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSameNumber(String number) {
        char[] chs = number.toCharArray();
        if (chs[0] == chs[1]) {
            return false;
        } else if (chs[0] == chs[2]) {
            return false;
        } else if (chs[1] == chs[2]) {
            return false;
        }
        return true;
    }

    public boolean checkRestartNumber(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            return false;
        }
        return true;
    }

}
