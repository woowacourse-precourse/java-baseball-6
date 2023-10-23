package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> answer = generateRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> input = getInputNumber();

            boolean isCorrect = check(answer, input);
            if (isCorrect) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = readLine();
                if(restart.equals("1")){
                    answer = generateRandomNumber();
                } else if (restart.equals("2")) {
                   break;
                }
                else throw new IllegalArgumentException();
            }
        }
    }

    private static boolean check(List<Integer> answer, List<Integer> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(input.get(i))) {
                strike++;
            } else if (answer.contains(input.get(i))) {
                ball++;
            }
        }
        // 결과 출력
        if(strike==0 && ball==0){
            System.out.print("낫싱");
        }
        if(ball>0){
            System.out.print(ball+"볼 ");
        }
        if(strike>0){
            System.out.print(strike+"스트라이크");
        }
        System.out.println("\n");

        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static List<Integer> getInputNumber() throws IllegalArgumentException {
        List<Integer> input = new ArrayList<>();
        // 입력 검증
        try {
            int number = Integer.parseInt(readLine());
            int first = number / 100;
            int second = (number % 100) / 10;
            int third = number % 10;

            // 1. 서로 다른지
            if(first == second || second == third || first == third){
                throw new Exception();
            }
            // 2. 3자리 숫자인지
            if (number < 100 || number > 999) {
                throw new Exception();
            }
            // 3. 각 자리수가 0이 아닌 숫자인지
            if (first == 0 || second == 0 || third == 0) {
                throw new Exception();
            }
            input.addAll(List.of(first, second, third));

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return input;
    }


    private static List<Integer> generateRandomNumber() {
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
