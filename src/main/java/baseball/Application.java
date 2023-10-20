package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class BaseballGame {
    private String computerNum;
    private int strikeCnt;
    private int ballCnt;

    public BaseballGame() {
        this.computerNum = makeRandomNumber();
    }

    public boolean start() {
        boolean isFinish = false;

        while (!isFinish) {
            String input = getInput(InputType.FIND);
            isFinish = checkFinish(input);
        }

        boolean isRestart = askRestart();
        if (isRestart) {
            return false;
        } else {
            return true;
        }
    }

    private enum InputType { FIND, RESTART }

    private String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }

    private String getInput(InputType type) {
        String input;

        if (type == InputType.FIND) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine().strip();
            checkFindInput(input);
        } else {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine().strip();
            checkRestartInput(input);
        }

        return input;
    }

    private boolean askRestart() {
        String restartInput = getInput(InputType.RESTART);

        if (restartInput.equals("1")) {
            return true;
        }

        return false;
    }

    private boolean checkFinish(String input) {
        compare(input);

        if (strikeCnt == 3) {
            printFinish();
            return true;
        }

        printResult();
        System.out.println(computerNum); //TODO 확인용, 나중에 삭제
        return false;
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        if (ballCnt==0 && strikeCnt==0) {
            sb.append("낫싱");
        } else {
            if (ballCnt!=0) {
                sb.append(ballCnt + "볼 ");
            }

            if (strikeCnt!=0) {
                sb.append(strikeCnt + "스트라이크");
            }
        }

        System.out.println(sb);
    }

    private void printFinish() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void compare(String input) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i=0; i<input.length(); i++) {
            for (int j=0; j<computerNum.length(); j++) {
                if (input.charAt(i) == computerNum.charAt(j)) {
                    if (i == j) {
                        strikeCnt++;
                    } else {
                        ballCnt++;
                    }
                }
            }
        }

        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    private void checkRestartInput(String input) {
        //한 글자인지 확인
        if (input.length() != 1) {
            throw new IllegalArgumentException("한 글자가 아닙니다");
        }

        //1-2 사이 숫자인지 확인
        if (!input.matches("[1-2]+")) {
            throw new IllegalArgumentException("1이나 2가 아닙니다");
        }
    }

    private void checkFindInput(String input) {
        //세 글자인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 글자가 아닙니다");
        }

        //1-9 사이 숫자인지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9사이 숫자가 아닙니다");
        }

        //셋 다 다른 숫자인지 확인
        if (hasSameNumber(input)) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
        }
    }

    private boolean hasSameNumber(String input) {
        int c1 = input.charAt(0);
        int c2 = input.charAt(1);
        int c3 = input.charAt(2);

        if (c1==c2 || c2==c3 || c3==c1) {
            return true;
        }

        return false;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isFinish = false;

        while (!isFinish) {
            BaseballGame game = new BaseballGame();
            isFinish = game.start();
        }
    }
}
