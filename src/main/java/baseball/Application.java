package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private static List<Integer> createRandomBaseballNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static String evaluateBaseballGuess(List<Integer> answer, int guess) throws IllegalArgumentException{
        int num_of_strikes = 0, num_of_balls = 0;
        List<Integer> guess_arr = new ArrayList<>(3);
        guess_arr.add(guess / 100);
        guess_arr.add((guess % 100) / 10);
        guess_arr.add(guess % 10);
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (Objects.equals(guess_arr.get(i), answer.get(j)))
                {
                    if (i == j) num_of_strikes++;
                    else if (i != j) num_of_balls++;
                }
            }
        }
        if (num_of_balls == 0 && num_of_strikes == 0) return "낫싱";
        if (num_of_strikes == 0) return num_of_balls + "볼";
        if (num_of_balls == 0) return num_of_strikes + "스트라이크";
        return num_of_balls + "볼" + num_of_strikes + "스트라이크";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String evaluate_result;
        // TODO: 숫자야구 시작 메시지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: computer 의 임의 숫자 생성
        List<Integer> baseball_num = createRandomBaseballNumber();
        List<Integer> baseball_guess = new ArrayList<Integer>();
        //System.out.println(baseball_num);
        // TODO: while 로 exception 또는 게임 종료 시까지 guess 진행
        while (true)
        {
            try
            {
                System.out.print("숫자를 입력해주세요 : ");
                evaluate_result = evaluateBaseballGuess(baseball_num, scanner.nextInt());
                System.out.println(evaluate_result);
                if (Objects.equals(evaluate_result, "3스트라이크"))
                {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int restart_selection = scanner.nextInt();
                    if (restart_selection == 1) /* */;
                    else if (restart_selection == 2) break;
                }
            }
            catch (IllegalArgumentException e)
            {
                break;
            }
            catch (Exception e)
            {
                break;
            }
        }

        scanner.close();
    }
}
