package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int response = 1;

        while(response==1) {
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            response = requestRestart();
        }
    }
    private static void play() {
        List<Integer> answer = setNums();

        while(true) {
            int[] input = requestNums();

            long strike = IntStream.range(0, input.length)
                    .filter(i -> input[i] == answer.get(i))
                    .count();

            long ball = IntStream.range(0, input.length)
                    .filter(i -> input[i] != answer.get(i) && answer.contains(input[i]))
                    .count();

            judge(ball, strike);

            if (strike == 3) break;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private static int requestRestart() {
        String input = readLine();
        if (input.equals("1")) return 1;
        if (input.equals("2")) return 2;

        throw new IllegalArgumentException(); //1이나 2가 아닌 값을 입력하면 예외를 발생시킨다.
    }
    private static int[] requestNums() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();

        //입력값 길이 검증
        if (input.length() != 3) throw new IllegalArgumentException();
        //숫자 이외의 값 포함 검증
        if (!input.matches("\\d+")) throw new IllegalArgumentException();
        //중복값 검증
        if (input.chars()
                .distinct()
                .count() != 3) throw new IllegalArgumentException();

        return  input.chars()
                .map(Character::getNumericValue)
                .toArray();
    }
    private static void judge(long ball, long strike) {
        //볼, 스트라이크가 모두 없는 경우
       if (strike + ball == 0) {System.out.print("낫싱");}
       //볼이 존재하는 경우
       if (ball > 0) {System.out.print(ball + "볼 ");}
       //스트라이크가 존재하는 경우
       if (strike > 0) {System.out.print(strike + "스트라이크");}

       System.out.println();
    }
    private static List<Integer> setNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}