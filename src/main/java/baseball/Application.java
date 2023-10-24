package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 맞춰야하는 수 생성 = target
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeRandomNum();
    }

    static List<Integer> randomNumber() { // 랜덤 넘버를 만드는 함수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void makeRandomNum() { // 랜덤 수를 만드는 메서드를 호출해 랜덤 수를 만들고 야구게임 시작
        List<Integer> target = randomNumber();
        // 야구 게임 시작
        baseballGame(target);
    }

    static String removeDuplicatesInString(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char singleCharacter : str.toCharArray()) {
            if (set.add(singleCharacter)) {
                sb.append(singleCharacter);
            }
        }
        return sb.toString();
    }

    static Integer userInput() { // 사용자 입력 받기
        // 사용자 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        String uniqueString = removeDuplicatesInString(input);
        if (uniqueString.length() != 3) {
            throw new IllegalArgumentException("입력은 서로 다른 3자리 숫자여야 합니다.");
        }
        int intInput; // intInput = 354
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println("입력이 정수가 아닙니다.");
            throw new IllegalArgumentException("입력은 정수만 가능합니다.");
        }


        return intInput;
    }

    static List<String> judgeWhatItIs(List<Integer> targetNumList, int userInput) {
        // 스트라이크, 볼, 낫싱 판단
        //
        List<String> result = new ArrayList<>(); // ex) result = ["1볼", "2스트라이크"]

        int cntStrike = 0;
        int cntBall = 0;

        for (int i = 0; i < 3; i++) {
            int n = userInput % 10;
            userInput = userInput / 10;
            // 스트라이크 갯수 세기
            boolean isStrike = targetNumList.get(2 - i) == n;
            if (isStrike) {
                cntStrike ++;
            }
            // 볼도 판단..
            if (!isStrike && targetNumList.contains(n)) {
                cntBall++;
            }
        }

        if (cntBall > 0) result.add(cntBall+"볼");
        if (cntStrike > 0) result.add(cntStrike+"스트라이크");
        if (cntBall == 0 && cntStrike == 0) result.add("낫싱");

        return result;
    }

    static int finishOrNot(String strikeInfo) {
        int restartOrNot;
        if (strikeInfo.equals("3스트라이크")) {
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try{
                String inputString = Console.readLine();
                restartOrNot = Integer.parseInt(inputString);
                if (restartOrNot == 1 || restartOrNot == 2) {
                    return restartOrNot;
                }
                throw new IllegalArgumentException("입력은 1 또는 2만 가능합니다.");
            } catch (NumberFormatException e) {
                System.out.println("error = " + e);
                throw new IllegalArgumentException("입력은 정수만 가능합니다.");
            }
        }
        return 0;
    }

    static void baseballGame(List<Integer> targetNum) {
        while (true) {
            int userNum = userInput();
            List<String> results = judgeWhatItIs(targetNum, userNum); //result = ["1스트라이크", "2볼"]

            int restartGameNum = 0;
            for (String result: results) {
                System.out.print(result+" ");
                restartGameNum = finishOrNot(result);
            }
            System.out.println();
            if (restartGameNum == 1) {
                makeRandomNum();
                break;
            }
            if (restartGameNum == 2) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}

