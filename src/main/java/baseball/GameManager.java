package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    /**
     * 게임 시작
     * @throws IOException
     */
    public List<Integer> startGame( ){
        Computer computer = new Computer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        //컴퓨터 무작위 3자리 숫자를 생성
        return computer.createAnswer();
    }

    /**
     * 컴퓨터에게 숫자를 재시하면, 힌트 재시 또는 정답 여부 확인
     * @param answer
     * @throws IOException
     */
    public void playGame(List<Integer> answer) {

        while (true) {

            Umpire umpire = new Umpire();
            umpire.judge(answer, inputTrial());

            if (umpire.isNothing()) {
                System.out.println("낫싱");
            } else {
                int ball = umpire.getBall();
                int strike = umpire.getStrike();

                if (ball != 0 && strike != 0) {
                    System.out.println(ball + "볼" + " " + strike + "스트라이크");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");

                    if (strike == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }
            }
        }
    }

    /**
     * 게임을 재시작할지, 종료할지 선택 (1-재시작, 2-종료)
     * @return
     * @throws IOException
     */
    public int choiceRestartOrEndGame() {
        int choice = -1;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        try {

            String inputChoice = br.readLine();

            if (!isValidRestart(inputChoice)) {
                throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
            }
            choice = Integer.parseInt(inputChoice);

        } catch (IOException e) {
            throw new IllegalArgumentException("입력처리중 오류가 발생했습니다.");
        }

        return choice;

    }


    /**
     * 숫자야구 정답에 대한 시도를 입력
     *
     * @throws IOException
     */
    private List<Integer> inputTrial() {

        List<Integer> trial = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        try {
            String inputTrialValue = br.readLine();

            if (!isValidTrial(inputTrialValue)) {
                throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
            }

            for (Character c : inputTrialValue.toCharArray()) {
                trial.add(Character.getNumericValue(c));
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("입력처리중 오류가 발생했습니다.");
        }

        return trial;
    }

    /**
     * 사용자의 숫자야구 시도입력이 정수 3자리숫자여야함
     * @param input
     * @return
     */
    private boolean isValidTrial(String input) {
        return input.matches("\\d{3}");
    }

    /**
     * 게임 재시작 혹은 종료를 선택할 때 입력은 1 또는 2여야함
     * @param input
     * @return
     */
    private boolean isValidRestart(String input) {
        return input.matches("[1-2]");
    }


}
