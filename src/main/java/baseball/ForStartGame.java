package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ForStartGame {
    BallCountAlg ballCountAlg = new BallCountAlg();
    MyException myException = new MyException();
    public List<Integer> init(){ //랜덤 값 생성
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
    public void play(List<Integer> answer){
        boolean check = true;
        while (check) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            int[] ballCount = ballCountAlg.countAlg(input, answer);
            switch (ballCountAlg.isCorrect(ballCount)){
                case 1: //볼
                    System.out.println(ballCount[0] + "볼");
                    break;
                case 2: //스트라이크
                    System.out.println(ballCount[1] + "스트라이크");
                    break;
                case 3: //볼, 스트라이크
                    System.out.println(ballCount[0] + "볼 " + ballCount[1]+"스트라이크");
                    break;
                case 4: //3스트라이크
                    System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int n = Integer.parseInt(Console.readLine());
                    myException.endOrRestartException(n);

                    switch (n) {
                        case 1:
                            check = false;
                            answer = init();
                            play(answer);
                            break;
                        case 2:
                            check = false;
                            break;
                    }
                case 5: //낫싱
                    System.out.println("낫싱");
                    break;
            }
        }
    }
}
