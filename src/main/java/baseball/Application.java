package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;

    private static List<Integer> createRandomNumber(int length) {
        List<Integer> digits = new ArrayList<>();

        while (digits.size() < length) {
            int digit = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!digits.contains(digit)) {
                digits.add(digit);
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        List<Integer> valueList = createRandomNumber(3);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요: ");
            String guess = Console.readLine();

            if(guess.length()!=3){
                throw new IllegalArgumentException("입력값은 세 자리 숫자여야 합니다.");
            }

            List<Integer> guessNumbers=new ArrayList<>();
            for(char c:guess.toCharArray()){
                if(Character.isDigit(c)){
                    guessNumbers.add(Character.getNumericValue(c));
                }else{
                    throw new IllegalArgumentException("입력값에 숫자 이외의 문자가 포함되어 있습니다.");
                }
            }

            if (valueList.equals(guessNumbers)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                int restartOption=Integer.parseInt(Console.readLine());

                if (restartOption == 1) {
                    valueList=createRandomNumber(3);
                } else if(restartOption ==2){
                    break;
                }
            } else {
                for(int i=0; i<3; i++) {
                    if(valueList.get(i).equals(guessNumbers.get(i)))
                        strike++;
                    else if(valueList.contains(guessNumbers.get(i)))
                        ball++;
                }

                String result = "";
                if (ball != 0 && strike != 0) {
                    result += ball + "볼 " + strike + "스트라이크";
                } else if (ball != 0) {
                    result += ball + "볼";
                } else if (strike != 0) {
                    result += strike + "스트라이크";
                } else if(ball+strike==0){
                    result  += "낫싱";
                }
                System.out.println(result);
            }
        }
    }
}
