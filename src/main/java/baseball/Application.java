package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String targetNumber = null, inputNumber = null;
        List<Integer> score = new ArrayList<>(); // strike, ball
        Integer strike = 0, ball = 0;
        score.add(strike);
        score.add(ball);
        while (true) {
            targetNumber = generateTargetNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                inputNumber = readLine();
                checkForm(inputNumber);
                score = checkScore(targetNumber, inputNumber);
                strike = score.get(0);
                ball = score.get(1);
                if(strike + ball == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ball != 0)
                        System.out.print(ball + "볼 ");
                    if (strike != 0)
                        System.out.print(strike + "스트라이크");
                    System.out.println();
                }
                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    inputNumber = readLine();
                    if(inputNumber.equals("1")) {
                        break;
                    }
                    else if (inputNumber.equals("2")) {
                        return;
                    }
                }
            }
        }
    }

    private static String generateTargetNumber() {
        String res = "";
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        for(Integer i=0; i<computer.size(); i++) {
            res += computer.get(i).toString();
        }
        return res;
    }

    private static void checkForm(String inputNumber) throws IllegalArgumentException {
        if (inputNumber.length()!=3)
            throw new IllegalArgumentException();
        if (checkRepeat(inputNumber))
            throw new IllegalArgumentException();
        return;
    }

    private static Boolean checkRepeat(String inputNumber) {
        for (Integer i=0; i<inputNumber.length(); i++) {
            for (Integer j=i+1; j<inputNumber.length(); j++) {
                if(inputNumber.charAt(i) == inputNumber.charAt(j)) return true;
            }
        }
        return false;
    }

    private static List<Integer> checkScore(String targetNumber, String inputNumber) {
        List<Integer> score = new ArrayList<>(); //strike, ball
        Integer strike = 0, ball = 0;
        score.add(strike);
        score.add(ball);
        for (Integer i=0; i<targetNumber.length(); i++) {
            for(Integer j=0; j<inputNumber.length(); j++) {
                if(targetNumber.charAt(i) == inputNumber.charAt(j)) {
                    if(i == j)
                        score.set(0, score.get(0)+1);
                    else
                        score.set(1, score.get(1)+1);
                }
            }
        }
//        score.set(1, score.get(1) - 2 * score.get(0));
        return score;
    }
}
