package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        boolean isFinish = false;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isFinish) {
            isFinish = startGame();
        }
    }

    private static boolean startGame() {
        String computerNum = makeRandomNumber();
        boolean isFinish = false;

        while (!isFinish) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = getInput(InputType.FIND);

            isFinish = checkFinish(input, computerNum);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean isRestart = askRestart();
        if (isRestart) {
            return false;
        } else {
            return true;
        }
    }

    private static String getInput(InputType type) {
        String input = Console.readLine().strip();

        if (type == InputType.FIND) {
            checkFindInput(input);
        } else {
            checkRestartInput(input);
        }

        return input;
    }

    private enum InputType { FIND, RESTART }

    private static boolean askRestart() {
        String restartInput = getInput(InputType.RESTART);

        if (restartInput.equals("1")) {
            return true;
        }

        return false;
    }

    private static boolean checkFinish(String input, String computerNum) {
        Map<String, Integer> cnt = compare(input, computerNum);

        if (cnt.get("strike") == 3) {
            printFinish();
            return true;
        }

        printResult(cnt);
        System.out.println(computerNum); //TODO 확인용, 나중에 삭제
        return false;
    }

    private static void printResult(Map<String, Integer> cnt) {
        StringBuilder sb = new StringBuilder();
        if (cnt.get("ball")==0 && cnt.get("strike")==0) {
            sb.append("낫싱");
        } else {
            if (cnt.get("ball")!=0) {
                sb.append(cnt.get("ball") + "볼 ");
            }

            if (cnt.get("strike")!=0) {
                sb.append(cnt.get("strike") + "스트라이크");
            }
        }

        System.out.println(sb);
    }

    private static void printFinish() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Map<String, Integer> compare(String input, String computerNum) {
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

        Map<String, Integer> map = new HashMap<>();
        map.put("strike", strikeCnt);
        map.put("ball", ballCnt);

        return map;
    }

    private static String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }

    private static void checkRestartInput(String input) {
        //한 글자인지 확인
        if (input.length() != 1) {
            throw new IllegalArgumentException("한 글자가 아닙니다");
        }

        //1-2 사이 숫자인지 확인
        if (!input.matches("[1-2]+")) {
            throw new IllegalArgumentException("1이나 2가 아닙니다");
        }
    }

    private static void checkFindInput(String input) {
        //세 글자인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 글자가 아닙니다");
        }

        //1-9 사이 숫자인지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9사이 숫자가 아닙니다");
        }
        
        //셋 다 다른 숫자인지 확인
        if (hasSameNumber(input.charAt(0), input.charAt(1), input.charAt(2))) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
        }
    }

    private static boolean hasSameNumber(char c1, char c2, char c3) {
        if (c1==c2) {
            return true;
        }

        if (c2==c3) {
            return true;
        }

        if (c3==c1) {
            return true;
        }

        return false;
    }
}
