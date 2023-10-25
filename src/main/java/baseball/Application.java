package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = Make();
        // Game 메서드 호출
        Game(randomNumber);

    }
    public static List<Integer> Make(){
        int num;
        List<Integer> answer = new ArrayList<>();
        num = pickNumberInRange(1, 9);
        answer.add(num);
        while (answer.size() < 3) {
            num = pickNumberInRange(0, 9);
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }


        return answer;
    }
    public static String Insert(){
        String num = readLine();
        return num;
    }


    public static void Game(List<Integer> randomNumber) {
        System.out.print("숫자을 입력해 주세요 : ");
        String su = Insert();
        char c;

        // 입력값 검사
        if (!isValidInput(su)) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < su.length(); i++) {
            c = su.charAt(i);
            int number = (int) (c - '0');
            for (int j = 0; j < randomNumber.size(); j++) {
                if (randomNumber.get(j) == number && i == j) {
                    strike++;
                } else if (randomNumber.get(j) == number && i != j) {
                    ball++;
                }
            }
        }
        if (strike + ball == 0) {
            System.out.println("낫싱");
            Game(randomNumber);
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String nn = Insert();
            char n = nn.charAt(0);
            int num = (int) (n - '0');
            if(num==1){
                randomNumber = Make();
                // Game 메서드 호출
                Game(randomNumber);
            }
        } else if(strike==0){
            System.out.println(ball + "볼");
            Game(randomNumber);
        } else if(ball==0){
            System.out.println(strike + "스트라이크");
            Game(randomNumber);
        }else{
            System.out.println(ball + "볼 "+strike + "스트라이크");
            Game(randomNumber);
        }

    }

    private static boolean isValidInput(String input) {
        return Pattern.matches("\\d{3}", input);
    }
}

