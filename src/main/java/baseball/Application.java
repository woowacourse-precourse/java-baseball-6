package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean loof = true;

        while (loof) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            computerRandom(computer);
            
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String Numbers = Console.readLine();

                List<Integer> user = new ArrayList<>();
                userNumberList(user, Numbers);
                userListValid(user);

                HashMap<Integer, Integer> map = new HashMap();
                computerUserComparisonList(map, user, computer);
                int ball = 0;
                int strike = 0;
                for (int m = 0; m < user.size(); m++) {
                    if (map.containsKey(user.get(m)) == true) {
                        if (user.get(m) == map.get(user.get(m))) {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
                if(strike==3){
                    System.out.println("3스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String userOpinion = Console.readLine();
                    if (userOpinion.equals("2")) {
                        loof = !loof;
                    }
                    break;
                }

                String judgeResult= ballStrikeResult(ball, strike);
                System.out.println(judgeResult);
            }
        }


    }
    public static String ballStrikeResult(int ball, int strike){
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public static void computerUserComparisonList(HashMap<Integer, Integer> map, List<Integer> user, List<Integer> computer){
        for (int k = 0; k < user.size(); k++) {
            map.put(computer.get(k), user.get(k));
        }
    }
    public static void userListValid(List<Integer> user){
        if (!(user.size() == 3)) {
            throw new IllegalArgumentException();
        }
    }

    public static void userNumberList(List<Integer> user,String Numbers){
        for (int i = 0; i < Numbers.length(); i++) {
            int userNumber = Numbers.charAt(i) - '0';
            userValid(user, userNumber);
            user.add(userNumber);

        }
    }

    public static void userValid(List<Integer> user, int userNumber){
        if(userNumber<1){
            throw new IllegalArgumentException();
        }
        if(userNumber>9){
            throw new IllegalArgumentException();
        }
        if(user.contains(userNumber)){
            throw new IllegalArgumentException();
        }
    }
    public static void computerRandom(List<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}