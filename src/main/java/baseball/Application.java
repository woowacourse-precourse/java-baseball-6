package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (gameStart()) {

        }
    }

    public static boolean gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 컴퓨터의 랜덤 수 얻기
        List<Integer> computerList = new ArrayList<>();
        pickAnswerNumbers(computerList);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();  // user 입력
            // 잘못된 입력에 대한 판단
            if (UserInputError(userInput)) {
                throw new IllegalArgumentException();
            }

            // 사용자의 입력을 숫자로 변환
            List<Integer> userList = pickUserNumbers(userInput);

            // 몇 개 맞추었는지 판단
            GameResult gameResult = new GameResult();
            showResult(gameResult, computerList, userList);

            int strike = gameResult.getStrike();
            int ball = gameResult.getBall();
            // 3스트라이크 여부 판단
            if (gameResult.getBall() == 0 && gameResult.getStrike() == 3) {
                // 3스트라이크
                int isMoreGame = showResultStrike();
                if (isMoreGame == 1) {
                    return true;
                } else if (isMoreGame == 2) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                // 3스트라이크가 아니라면
                showResultNormal(gameResult);
            }
        }
    }

    private static void showResultNormal(GameResult gameResult) {
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            System.out.println("낫싱");
        } else if (gameResult.getStrike() == 0) {
            System.out.println(gameResult.getBall() + "볼");
        } else if (gameResult.getBall() == 0) {
            System.out.println(gameResult.getStrike() + "스트라이크");
        } else {
            System.out.println(gameResult.getBall() + "볼 " + gameResult.getStrike() + "스트라이크");
        }
    }

    private static int showResultStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        // 사용자 입력 확인
        if (UserInputCntError(userInput, 1)) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void showResult(GameResult gameResult, List<Integer> computerList, List<Integer> userList) {
        for (int i = 0; i < 3; i++) {
            // 스트라이크
            if (computerList.get(i) == userList.get(i)) {
                gameResult.setStrike(gameResult.getStrike() + 1);
            } else {
                // 볼
                if (computerList.contains(userList.get(i))) {
                    gameResult.setBall(gameResult.getBall() + 1);
                }
            }
        }
    }

    private static class GameResult {
        private int ball = 0, strike = 0;

        public int getBall() {
            return ball;
        }

        public int getStrike() {
            return strike;
        }

        public void setBall(int ball) {
            if (ball >= 0) {
                this.ball = ball;
            }
        }

        public void setStrike(int strike) {
            if (strike >= 0) {
                this.strike = strike;
            }
        }
    }

    private static List<Integer> pickUserNumbers(String userInput) {
        List<Integer> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userList.add(userInput.charAt(i) - '0');
        }
        return userList;
    }


    // 사용자가 맞추어야할 3개 숫자를 뽑습니다.
    public static void pickAnswerNumbers(List<Integer> computerList) {
        while (computerList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(num)) {
                computerList.add(num);
            }
        }
    }

    public static boolean UserInputError(String userInput) {
        // TODO : 3자리가 아님 | Integer 타입이 아님 | 중복이 있음 판단
        if (UserInputCntError(userInput, 3) || IntegerError(userInput) || checkDuplication(userInput)) {
            return true;
        }
        return false;
    }

    public static boolean UserInputCntError(String userInput, int cnt) {
        if (userInput.length() != cnt) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean IntegerError(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            int userInputToChar = userInput.charAt(i);
            if (userInputToChar - '0' < 0 || userInputToChar - '0' > 9) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDuplication(String userInput) {
        char firstChar = userInput.charAt(0);
        char middleChar = userInput.charAt(1);
        char lastChar = userInput.charAt(2);

        if (firstChar == middleChar || middleChar == lastChar || firstChar == lastChar) {
            return true;
        }
        return false;
    }


}
