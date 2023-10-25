package baseball;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        int strike;
        int ball;
        boolean contine = true;
        String answer;
        Scanner sc = new Scanner(System.in);

        while (contine){
            strike = 0;
            ball = 0;
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (strike != 3){
                strike = 0;
                ball =0;
                int i = 0;
                System.out.print("숫자를 입력해 주세요. : ");
                try{
                    answer = sc.nextBigInteger().toString();
                }catch (InputMismatchException e) {
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                }

                if(answer.length() != 3){
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                }

                String[] answerLetters = answer.split("");
                for(Integer coputerNum : computer){
                    if(answer.contains(coputerNum.toString())){
                        ball++;
                    }
                    if(answerLetters[i].equals(coputerNum.toString())){
                        strike++;
                        ball--;
                    }
                    i++;
                }
                System.out.println((ball == 0 ? "" : ball + "볼 ") + (strike == 0 ? ball == 0 ? "낫싱" : "" : strike + "스트라이크"));
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int tmp = sc.nextInt();

            if(tmp != 1 && tmp !=2){
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }

            contine = tmp == 1;

        }
    }
}
