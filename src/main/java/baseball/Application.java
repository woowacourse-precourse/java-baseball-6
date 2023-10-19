package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Application {

    public static ArrayList<Integer> generateAnswer(){
        ArrayList<Integer> rval = new ArrayList<>(3);
        for(int i = 0; i < 3; i ++){
            int num = Randoms.pickNumberInRange(1, 10);
            while (rval.contains(num)) {
                num = Randoms.pickNumberInRange(1, 10);
            }
            rval.add(num);
        }
        return rval;
    }

    public static ArrayList<Integer> guessInputHandler() throws IllegalArgumentException{
        ArrayList<Integer> result;
        String s = Console.readLine();

        if(s.isEmpty() || s.length() > 3)
            throw new IllegalArgumentException();
        try{
            result = (ArrayList<Integer>) Arrays
                    .stream(s.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new IllegalArgumentException();
        }

        return result;
    }

    public static String restartInputHandler() throws  IllegalArgumentException{
        String rval = Console.readLine();

        if(rval.equals("1") || rval.equals("2"))
            return rval;

        throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> userNumber;
        ArrayList<Integer> answer;
        int ball;
        int strike;
        StringBuilder resultStatement;

        do {
            answer = generateAnswer();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                ball = 0;
                strike = 0;
                resultStatement = new StringBuilder();

                System.out.print("숫자를 입력해주세요 : ");
                userNumber = guessInputHandler();
                for (int i = 0; i < 3; i++) {
                    int num = answer.indexOf(userNumber.get(i));
                    if (num == i) {
                        strike++;
                    } else if(num != -1){
                        ball++;
                    }
                }
                if (ball > 0)
                    resultStatement.append(ball).append("볼 ");
                if (strike > 0)
                    resultStatement.append(strike).append("스트라이크");

                if(strike == 0 && ball == 0)
                    resultStatement.append("낫싱");

                System.out.println(resultStatement);

                if (strike == 3) {
                    System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        } while (!Objects.equals(restartInputHandler(), "2"));
    }
}
