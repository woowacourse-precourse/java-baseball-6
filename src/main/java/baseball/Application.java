package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IOException {
        playGame();
    }

    //1~9까지의 임의의 수 세 개 추출 메서드
    private static List<Integer> makeNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //게임 진행 메서드
    private static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restartButton = 0;
        while (restartButton != 2) {
            List<Integer> computer = makeNum(); //임의의 세 개 값 만들기
            printScore(computer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String IsEnd = Console.readLine();
            if (!IsEnd.equals("1") && !IsEnd.equals("2")) {
                throw new IllegalArgumentException("1 혹은 2가 아닌 값을 입력했습니다. 에러 발생");
            }
            restartButton = Integer.parseInt(IsEnd);
        }
    }

    //사용자에게 입력값을 받고 각종 예외처리를 하는 메서드
    private static List<Integer> receiveInput() {
        String s;
        List<Integer> inputs = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userLine = Console.readLine();
        String[] LineArr = userLine.split("");

        //사용자가 세 개 미만 혹은 초과의 숫자를 입력할 경우 오류 표시
        if (LineArr.length != 3) {
            throw new IllegalArgumentException("3개가 아닌 값을 입력했습니다. 에러 발생");
        }

        // 입력한 세 개의 값이 1~9 사이의 숫자가 아닐 경우 오류 표시
        for (int i = 0; i < LineArr.length; i++) {

            if (!Pattern.matches("[1-9]", LineArr[i])) {
                throw new IllegalArgumentException("1~9사이의 숫자가 아닙니다. 에러 발생");
            }
            inputs.add(Integer.parseInt(LineArr[i]));
        }

        //사용자가 입력한 값 중 중복의 숫자가 있을 경우 에러 발생
        if (inputs.get(0).equals(inputs.get(1)) || inputs.get(0).equals(inputs.get(2)) || inputs.get(1).equals(inputs.get(2))) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다. 에러 발생");
        }
        return inputs;
    }

    //사용자에게 입력 받은 값으로 strike와 ball의 개수 계산하는 메서드
    public static Score getScore(List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        List<Integer> inputs = receiveInput();
        for (int j = 0; j < 3; j++) {
            if (computer.get(j).equals(inputs.get(j))) {
                strike += 1;
            } else if (!inputs.get(j).equals(computer.get(j)) && computer.contains(inputs.get(j))) {
                ball += 1;
            }
        }
        return new Score(strike, ball);
    }

    //계산된 strike와 ball의 값을 출력하는 메서드
    public static void printScore(List<Integer> computer) {
        while (true) {
            Score score = getScore(computer);
            int strike = score.strike;
            int ball = score.ball;
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0 && ball == 0 && strike != 3) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}


