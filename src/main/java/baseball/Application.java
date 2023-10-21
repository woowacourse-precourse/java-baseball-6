package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame game = new BaseBallGame();
        game.gameStart();
    }
}

class BaseBallGame {
    List<Integer> computerAnswer, userAnswer;
    String resultAnswer = "";
    String userInput = "";

    public void gameStart() {
        while(true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();

            userAnswer = getUserAnswer(userInput);
            computerAnswer = getComputerAnswer();

            String result = checkAnswer(userAnswer, computerAnswer);
            if(result.equals("W")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userInput = Console.readLine();
                if(Integer.parseInt(userInput) == 2) {
                    return;
                }
            }else {
                System.out.println(result);
            }
        }
    }

    private List<Integer> getComputerAnswer() {
        computerAnswer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
        computerAnswer.add(1);
        computerAnswer.add(2);
        computerAnswer.add(3);
        return computerAnswer;
    }
    private List<Integer> getUserAnswer(String userInput) {
        userAnswer = new ArrayList<>();
        for(int i = 0; i < userInput.length(); i++) {
            char number = userInput.charAt(i);
            userAnswer.add(Character.getNumericValue(number));
        }
        return userAnswer;
    }
    public String checkAnswer(List<Integer> userAnswer, List<Integer> computerAnswer) {
        int count = 0;
        int ballcount = 0;
        int strikecount = 0;

        for (int i = 0; i < 3 ; i++) {
            if(userAnswer.contains(computerAnswer.get(i))) {
                count += 1;
                int index = userAnswer.indexOf(computerAnswer.get(i));
                if (index == i) {
                    strikecount += 1;
                }else {
                    ballcount += 1;
                }
            }
        }

        if (strikecount == 3)
            return "W";

        if (count == 0) {
            resultAnswer = "낫싱";
        } else {
            if(ballcount == 0)
                resultAnswer = strikecount + "스트라이크";
            else if(strikecount == 0)
                resultAnswer = ballcount + "볼";
            else
                resultAnswer = ballcount + "볼" + strikecount + "스트라이크";
        }

        return resultAnswer;
    }
}
