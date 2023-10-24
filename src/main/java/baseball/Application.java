package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer;
    static boolean threeStrike; // 3 스트라이크인지 판별
    public static void main(String[] args)  {

        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }
    // 게임 시작
    private static void start() {
        computer = createNumber();
        threeStrike = false;

        while(!threeStrike) {
            try {
                playing(computer);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
        if(threeStrike) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String oneOrTwo = Console.readLine();
            if("1".equals(oneOrTwo)) {
                start();
            }else {
                return;
            }
        }
    }
    // 게임 로직
    public static void playing(List<Integer> computer) throws IllegalArgumentException {

        int ball ;
        int strike = 0;
        int tmp = 0;

        System.out.println("숫자를 입력해주세요 : ");

        String go = Console.readLine();
        if(go.length() != 3 || notNumber(go)) {
            throw new IllegalArgumentException();

        }

        for (int i = 0; i < go.length(); i++) {
            int number = computer.get(i);
            char numberC = go.charAt(i);

            if (number == Character.getNumericValue(numberC)) {
                strike++;
            }

            if (computer.contains(Character.getNumericValue(numberC))) {
                tmp++;
            }
        }
        ball = tmp - strike;

        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }else if(ball == 0) {
            System.out.println(strike + "스트라이크");
        }else if(strike == 0) {
            System.out.println(ball + "볼");
        }else {
            System.out.println(ball + "볼 " +
                    strike + "스트라이크");
        }
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            threeStrike = true;
        }
    }
    // 난수 3자리 생성
    public static List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 문자열이 숫자로 이루어져 있는지 판별, -> 숫자가 아니면 true
    public static boolean notNumber(String go) {
        if(go == null) {
            return true;
        }
        for(char c : go.toCharArray()) {
            if(!Character.isDigit(c)) { // 숫자가 아니면 실행
                return true;
            }
        }
        return false;
    }
}




