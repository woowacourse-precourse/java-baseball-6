package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    /**
     * 게임 시작
     * @param computer
     * @throws IOException
     */
    public void startGame(Computer computer) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int restart = 1;
        while (restart == 1) {
            //컴퓨터 무작위 3자리 숫자를 생성
            List<Integer> answer = computer.createAnswer();
            System.out.println("숫자 야구 게임을 시작합니다.");


            playGame(br, answer);
            restart = restartOrExitGame(br);
        }
        System.out.println("게임종료");

    }

    /**
     * 게임을 재시작하거나 종료
     * @param br
     * @return
     * @throws IOException
     */
    public int restartOrExitGame(BufferedReader br) throws IOException {
        int restart;
        String inputRestart = choiceRestartOrEndGame(br);
        restart = Integer.parseInt(inputRestart);
        return restart;
    }

    /**
     * 게임을 재시작할지, 종료할지 선택 (1-재시작, 2-종료)
     * @param br
     * @return
     * @throws IOException
     */
    private String choiceRestartOrEndGame(BufferedReader br) throws IOException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputRestart = br.readLine();

        if (!isValidRestart(inputRestart)) {
            throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
        }
        return inputRestart;
    }

    /**
     * 컴퓨터에게 숫자를 재시하면, 힌트 재시 또는 정답 여부 확인
     * @param br
     * @param answer
     * @throws IOException
     */
    public void playGame(BufferedReader br, List<Integer> answer) throws IOException {

        while (true) {
            List<Integer> trial = new ArrayList<>();
            Umpire umpire = new Umpire();
            inputTrial(br, trial);

            umpire.judge(answer, trial);

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
     * 숫자야구 정답에 대한 시도를 입력
     * @param br
     * @param trial
     * @throws IOException
     */
    private void inputTrial(BufferedReader br, List<Integer> trial) throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputTrialValue = br.readLine();

        if (!isValidTrial(inputTrialValue)) {
            throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
        }

        for (Character c : inputTrialValue.toCharArray()) {
            trial.add(Character.getNumericValue(c));
        }

    }

    private boolean isValidTrial(String input) {
        return input.matches("\\d{3}");
    }

    private boolean isValidRestart(String input) {
        return input.matches("[1-2]");
    }


}
