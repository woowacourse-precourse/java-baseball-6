package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> comNum(List<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static String playGame(List<Integer> computer, List<Integer> player){

        int same = sameNumber(computer, player);
        int strike = checkStrike(computer, player);
        int ball = same - strike;

        if(same == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";

    }
    public static int sameNumber(List<Integer> computer, List<Integer> player){
        int result = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                result += 1;
            }
        }
        return result;
    }
    public static int checkStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        computer = comNum(computer);
        for(;;){
            user.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String input  = Console.readLine();
            if (input.length()> 3){
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < input.length(); i++) {
                char digitChar = input.charAt(i); // 문자열3에서 한 문자를 가져옴
                int digit = Character.getNumericValue(digitChar); // 문자를 int로 변환
                user.add(digit);
            }

            String strike = playGame(computer,user);

            System.out.println(strike);
            if (strike.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame  = Console.readLine();
                if(reGame.equals("1")){
                    System.out.println("숫자 야구 게임을 시작합니다.");
                    computer = comNum(computer);
                } else if (reGame.equals("2")) {
                    break;
                }


            }

        }


    }
}
