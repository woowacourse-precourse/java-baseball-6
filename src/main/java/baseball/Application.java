package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        BaseBallGame game = new BaseBallGame();

        game.gameStart();

    }
}

class BaseBallGame {
    List<Integer> computerAnswer, userAnswer;
    String userInput = "";

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 상대방(컴퓨터)의 값을 ArrayList로 반환
        computerAnswer = getComputerAnswer();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();

            // 숫자가 아닌 값을 입력한 경우 IllegalArgumentException 발생시킴
            try {
                Integer.parseInt(userInput);
            }catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
            // 세자리가 아닌 값을 입력한 경우 IllegalArgumentException 발생시킴
            if (userInput.length() != 3)
                throw new IllegalArgumentException();

            // 사용자가 입력한 값을 ArrayList로 반환
            userAnswer = getUserAnswer(userInput);

            // 사용자가 입력한 값과 컴퓨터의 값을 비교함
            String result = checkAnswer(userAnswer, computerAnswer);
            System.out.println(result);
            if(result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userInput = Console.readLine();
                // 2를 입력하는 경우 게임 종료(반복문 탈출)
                if(Integer.parseInt(userInput) == 2) {
                    return;
                    // 1를 입력하는 경우 게임 재시작
                }else if (Integer.parseInt(userInput) == 1) {
                    computerAnswer = getComputerAnswer();
                    // 1과 2 아닌 값을 입력하는 경우 IllegalArgumentException 발생 시킴
                }else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    // camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 사용해 컴퓨터의 값 랜덤 추출
    private List<Integer> getComputerAnswer() {
        computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 : " + computerAnswer.toString());
        return computerAnswer;
    }
    // 사용자의 입력을 ArrayList로 반환함
    private List<Integer> getUserAnswer(String userInput) {
        userAnswer = new ArrayList<>();
        for(int i = 0; i < userInput.length(); i++) {
            char number = userInput.charAt(i);
            int num = Character.getNumericValue(number);
            // 중복된 값이 있는지 확인
            if(userAnswer.contains(num))
                throw new IllegalArgumentException();
            else
                userAnswer.add(Character.getNumericValue(number));
        }
        return userAnswer;
    }
    // 사용자 입력 값과 컴퓨터의 값을 비교해 답을 맞췄는지 아닌지 확인함
    // 답을 맞춘 경우 문자열 W 반환, 틀린 경우 힌트 문자열(예. 1볼 1스트라이크) 반환
    public String checkAnswer(List<Integer> userAnswer, List<Integer> computerAnswer) {
        String resultAnswer = "";
        int count = 0; // 사용자 입력 값과 컴퓨터 입력 값중 몇 개가 같은 수인지 카운트
        int ballcount = 0; // 볼 카운트
        int strikecount = 0; // 스트라이크 카운트

        for (int i = 0; i < 3 ; i++) {
            // 사용자 입력 값이 컴퓨터의 값 중에 동일한게 있다면
            if(userAnswer.contains(computerAnswer.get(i))) {
                count += 1;
                // 그 값의 index 반환
                int index = userAnswer.indexOf(computerAnswer.get(i));
                // index가 서로 같다면 스트라이크 카운트
                if (index == i) {
                    strikecount += 1;
                    // 다르다면 볼 카운트
                }else {
                    ballcount += 1;
                }
            }
        }
        // 서로 같은 값이 하나도 없다면 힌트 문자열(낫싱) 반환
        if (count == 0) {
            resultAnswer = "낫싱";
        }else if (ballcount == 0) {
            resultAnswer = strikecount + "스트라이크";
        }else if(strikecount == 0) {
            resultAnswer = ballcount + "볼";
        }else {
            resultAnswer = ballcount + "볼 " + strikecount + "스트라이크";
        }
        return resultAnswer;
    }
}