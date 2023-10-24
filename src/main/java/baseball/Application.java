package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean type = true;

        while (type) {

            System.out.println("게임을 시작합니다.");

            RandomNum randomNum = new RandomNum();
            List<Integer> randomNumList = randomNum.createRandomNum();

            while (type) {
                InputNum inputNum = new InputNum();

                List<Integer> inputNumList = inputNum.inputNum();

                // 입력받은 값을 비교하는 로직이 들어가야함
                ChoiceNum choiceNum = new ChoiceNum(randomNumList, inputNumList);

                String result = choiceNum.ChoiceNumResult(randomNumList, inputNumList);

                System.out.println(result);

                // 만약 스트라이크가 3이면 게임 종료 -> 게임 종료 여부 묻기 -> 1이면 여기 와일문 나가기(break), 2이면 type을 false로 변경
                if (choiceNum.strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    RestartOrEnd restartOrEnd = new RestartOrEnd();

                    int restartOrEndNum = restartOrEnd.RestartOrEnd();

                    if (restartOrEndNum == 1) {
                        break;
                    } else if (restartOrEndNum == 2) {
                        type = false;
                    }
                }
            }
        }
    }
}



