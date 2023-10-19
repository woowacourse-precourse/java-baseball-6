package baseball;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int isContinue = 1;
        List<Integer> computer = new ArrayList<>();

        while(isContinue == 1) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            // 사용자 입력 예외처리
            String inputPattern = "^[1-9]{3}$";
            Matcher matcher = Pattern.compile(inputPattern).matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException();
            }
            Set<Character> set = new HashSet<>();
            for (char c : input.toCharArray()) {
               if (!set.add(c)) {
                   throw new IllegalArgumentException();
               }
            }

            // 랜덤 숫자 생성 - 한 게임에 한 번만 생성!
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            int strike = 0;
            int ball = 0;
            for (int i=0; i < input.length(); i++) {
                char numChar = input.charAt(i);
                int num = Character.getNumericValue(numChar);
                if (num == computer.get(i)) {
                    strike++;
                } else if (computer.contains(num)) {
                    ball ++;
                }
            }

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // TODO : 변수명 바꾸기
                String input2 = Console.readLine();
                isContinue = Integer.parseInt(input2);
                computer.clear();
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                if (strike > 0 && ball > 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                } else if (ball != 0) {
                    System.out.printf("%d볼\n", ball);
                } else {
                    System.out.printf("%d스트라이크\n", strike);
                }
            }
        }
    }
}
