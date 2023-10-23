package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>(); // computer 숫자 (정답)
        List<Integer> user = new ArrayList<>(); // computer 숫자 (정답)
        int strike = 0;
        int ball = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while(true) {

            while (true){
                user = Arrays.stream(Console.readLine().split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
                if (! user.get(0).equals(user.get(1)) && ! user.get(1).equals(user.get(2)) && ! user.get(0).equals(user.get(2))){
                    break;
                }
                System.out.println("중복된 값을 입력했습니다.");
            }
            for (int x : computer){
                System.out.println(x+" ");
            }
            for (int x : user){
                System.out.println(x+" ");
            }
            for(int i = 0; i < computer.size(); i++) {
                for(int j = 0; j < user.size(); j++) {
                    if(computer.get(i).equals(user.get(j)) && i == j) {
                        strike++;
                    }else if(computer.get(i).equals(user.get(j)) && i != j) {
                        ball++;
                    }
                }
            }

            System.out.println(ball + "볼" + strike + "스트라이크");
            if(strike == 3) {
                System.out.println("정답!");
                break;
            }
            strike = 0;
            ball = 0;
        }
    }
}
