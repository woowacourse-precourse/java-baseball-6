package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomLists =  app.makeRandomLists();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = readLine();

            boolean isCorrect = app.checkInput(input);

            if (isCorrect) {
                int[] gameResult = app.ballOrStrike(input, randomLists);
                int ballCount = gameResult[0];
                int strikeCount = gameResult[1];

                System.out.println(app.showResult(ballCount, strikeCount));

                if (strikeCount == 3) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String regameOrExit = readLine();

                    if (!regameOrExit.equals("1") && !regameOrExit.equals("2")) {
                        throw new IllegalArgumentException("잘못된 수를 입력하셨습니다.");
                    }

                    if(regameOrExit.equals("1")) randomLists = app.makeRandomLists();

                    if(regameOrExit.equals("2")) break;

                }
            }
        }
    }

    private List<Integer> makeRandomLists(){
        List<Integer> randomLists = new ArrayList<>();

        while (randomLists.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);

            if (!randomLists.contains(randomNumber)) {
                randomLists.add(randomNumber);
            }
        }

        return randomLists;
    }

    private boolean checkInput(String input) {
        char one = input.charAt(0);
        char two = input.charAt(1);
        char three = input.charAt(2);

        if (input.length() == 3 && (one!='0' && two !='0' && three !='0')) {

            if (one != two && two != three && three != one) {
                return true;
            }
        }

        throw new IllegalArgumentException("조건에 부합하지 않는 형식입니다.");

    }

    private int[] ballOrStrike(String input, List<Integer> randomLists) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < randomLists.size(); i++) {

            int inputToInt = Integer.parseInt(String.valueOf(input.charAt(i)));
            Integer randomList = randomLists.get(i);

            if (!randomList.equals(inputToInt) && randomLists.contains(inputToInt)) {
                ballCount++;
            }

            if (randomList.equals(inputToInt)) {
                strikeCount++;
            }
        }

        return new int[]{ballCount, strikeCount};
    }

    private String showResult(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        }

        if (ballCount == 0 && strikeCount != 0) {

            if (strikeCount == 3) {
                return strikeCount + "스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }

            return strikeCount + "스트라이크";
        }

        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + "볼" + " " + strikeCount + "스트라이크";
        }

        return "낫싱";
    }

}
