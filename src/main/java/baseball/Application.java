package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        outer: while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            inner : while (true) {
                int myIntNum = 0;
                try {
                    myIntNum= Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException("값을 잘못입력하였습니다.");
                }

                String myNum = "" + myIntNum;

                if (myNum.length() != 3) {
                    throw new IllegalArgumentException("세 자리수를 입력하세요");
                }
                List<Integer> user = Arrays.stream(myNum.split("")).map(Integer::parseInt).collect(Collectors.toList());
                int strikes = 0;
                int balls = 0;

                strikes = findstrikes(computer, user, strikes);
                balls = findBall(computer, user, balls);
                int result = result(br, strikes, balls);
                switch(result){
                    case 1:
                        break inner;
                    case 2:
                        break outer;
                }
            }
        }
    } //main

    private static int result(BufferedReader br,int strikes, int balls) {
        if (strikes == 3) { //s =3
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int play = 0;
            try {
                play = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch(play){
                case 1:
                    return 1;
                case 2:
                    return 2;
            }

        }

        if (balls > 0 && strikes > 0) { //둘다
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (balls > 0 && strikes == 0) {//ball만
            System.out.println(balls + "볼");
        } else if (balls == 0 && strikes > 0) {//strike만 있는 경우
            System.out.println(strikes + "스트라이크");
        } else {//아무거도 없어
            System.out.println("낫싱");
        }
        return 0;
    }

    private static int findBall(List<Integer> computer, List<Integer> user, int balls) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i) == computer.get(j) && (i != j)) {
                    balls++;
                }
            }
        }
        return balls;
    }

    private static int findstrikes(List<Integer> computer, List<Integer> user, int strikes) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) == computer.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }
}
