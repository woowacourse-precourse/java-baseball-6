package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class NumberBaseball {

    List<Integer> pcList = new ArrayList<>();
    List<Integer> userList = new ArrayList<>();
    int[] roundResultMap = new int[2];
    String roundResult;


    //중복없는 랜덤 숫자 만들기
    void makeUniqueList() {
        while (pcList.size() != 3) {
            int tmp = Randoms.pickNumberInRange(1, 9);

            if (!pcList.contains(tmp)) {
                pcList.add(tmp);
            }
        }
    }

    void checkNumberFormat(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException("wrong format");
        }
        if (input.contains("0") || input.contains("-")) {
            throw new IllegalArgumentException("wrong format");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("wrong format");
        }
    }

    //입력 처리
    void makeUserList(String input) {
        checkNumberFormat(input);

        for (int i = 0; i < input.length(); i++) {
            int tmp = Character.getNumericValue(input.charAt(i));

            if (userList.contains(tmp)) {
                throw new IllegalArgumentException("duplicated");
            }

            userList.add(tmp);
        }
    }

    //입력받은 값과 랜덤 숫자 비교
    void compareList() {
        roundResultMap[0] = 0;
        roundResultMap[1] = 0;

        for (int i = 0; i < userList.size(); i++) {
            int userTmp = userList.get(i);

            if (pcList.contains(userTmp)) {
                if (pcList.indexOf(userTmp) == i) {
                    roundResultMap[0]++;
                } else {
                    roundResultMap[1]++;
                }
            }
        }

        userList.clear();
    }

    //비교 결과 출력
    boolean makeRoundResult() {
        int strike = roundResultMap[0];
        int ball = roundResultMap[1];

        if (strike == 3) {
            roundResult = "3스트라이크";
            return true;
        }

        roundResult = ball + "볼 " + strike + "스트라이크";
        if (strike == 0 && ball == 0) {
            roundResult = "낫싱";
        }

        return false;
    }

    //게임 종료
    boolean endMenu(String input) {
        return switch (input) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    //실행기
    public boolean run() {
        makeUniqueList();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            makeUserList(input);

            compareList();

            boolean result = makeRoundResult();
            System.out.println(roundResult);

            if (result) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return endMenu(input);
    }
}
