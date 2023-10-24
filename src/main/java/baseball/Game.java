package baseball;

import baseball.enums.GameProgressFlag;
import baseball.enums.GameStatus;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 게임. 답과 실행메서드(play())를 가지고 있다.
 */
public class Game {

    private String computerNum; // 컴퓨터가 선택한 숫자(답)

    /**
     * 게임 시작에 필요한 정보 세팅
     */
    private void init() {
        makeComputerNum(); // 컴퓨터의 숫자 결정
    }

    /**
     * 게임 실행
     */
    public void play() {
        init();

        System.out.println("숫자 야구 게임을 시작합니다.");

        GameStatus gameStatus = GameStatus.PLAYING;

        while (GameStatus.PLAYING.equals(gameStatus)
                || GameStatus.RESTART.equals(gameStatus)) {

            // 게임을 다시 시작한 경우, 컴퓨터의 숫자 새로 생성하고 게임 결과 코드를 PLAYING으로 변경
            if (GameStatus.RESTART.equals(gameStatus)) {
                makeComputerNum();
                gameStatus = GameStatus.PLAYING;
            }

            // 사용자의 값 입력
            System.out.print("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();

            // 사용자가 입력한 값에 대한 검증
            if (!isValidUserNum(userNum)) {
                gameStatus = GameStatus.INVALID_USER_INPUT;
            }

            if (!GameStatus.INVALID_USER_INPUT.equals(gameStatus)) {
                // 사용자가 입력한 값과 컴퓨터가 생성한 값을 비교하고 결과 출력
                GameResult gameResult = compareUserNumAndComputerNum(userNum);
                System.out.println(gameResult.returnResultToString());
                if (gameResult.isEnd()) {
                    gameStatus = GameStatus.END;
                }
            }

            // 게임이 ALL STRIKE인 경우
            if (GameStatus.END.equals(gameStatus)) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", GameDetail.NUM_COUNT);
            }

            // 사용자가 입력한 값이 유효하지 않거나, 게임이 ALL STRIKE인 경우 => 게임 종료
            if (GameStatus.INVALID_USER_INPUT.equals(gameStatus)
                    || GameStatus.END.equals(gameStatus)) {
                // 게임을 새로 시작할지 종료할지 사용자로부터 입력받아서 게임 종료할 경우 while문 종료
                if (restartGame()) {
                    gameStatus = GameStatus.RESTART;
                }
            }
        }
    }

    /**
     * 게임 종료 후 restart 또는 end 입력받기
     * @return restart 입력 시 true, end 입력 시 false
     */
    private boolean restartGame() {
        while (true) {
            System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n",
                    GameProgressFlag.RESTART.getFlagValue(), GameProgressFlag.END.getFlagValue());
            String restartOrEnd = Console.readLine();
            if (isValidRestartOrEndAnswer(restartOrEnd)) {
                return GameProgressFlag.RESTART.getFlagValue().equals(restartOrEnd);
            }
        }
    }

    /**
     * 사용자가 입력한 값이 restart 또는 end인지 검증
     * @param input 사용자가 입력한 값
     * @return restart 또는 end인 경우 true, 그렇지 않은 경우 false
     */
    private boolean isValidRestartOrEndAnswer(String input) {
        return input.equals(GameProgressFlag.RESTART.getFlagValue())
                || input.equals(GameProgressFlag.END.getFlagValue());
    }

    /**
     * 사용자가 입력한 값에 대한 검증
     * @param userNum 사용자가 입력한 값
     * @return 사용자가 입력한 값이 유효한 경우 true
     * @throws IllegalArgumentException 사용자가 입력한 값이 유효하지 않은 경우
     */
    private boolean isValidUserNum(String userNum) throws IllegalArgumentException {
        if (!isPositiveNumber(userNum)) {
            throw new IllegalArgumentException(String.format("양수가 아닌 입력값 = %s", userNum));
        }

        if (userNum.length() != GameDetail.NUM_COUNT) {
            throw new IllegalArgumentException(String.format("3자리가 아닌 입력값 = %s", userNum));
        }

        if (hasDuplicateNum(userNum)) {
            throw new IllegalArgumentException(String.format("중복된 숫자가 존재하는 입력값 = %s", userNum));
        }

        if (userNum.contains("0")) {
            throw new IllegalArgumentException(String.format("0이 포함된 입력값(1부터 9까지 가능) = %s", userNum));
        }

        return true;
    }

    /**
     * String이 양수인지 검증
     * @param input 검증대상 String
     * @return 양수인 경우 true, 그렇지 않은 경우 false
     */
    private boolean isPositiveNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return num > 0;
    }

    /**
     * 사용자가 입력한 값에 중복이 존재하는지 검증
     * @param userNum 사용자가 입력한 값
     * @return 중복이 존재하는 경우 true, 그렇지 않은 경우 false
     */
    private boolean hasDuplicateNum(String userNum) {
        for (int i = 0; i < userNum.length(); i++) {
            if (userNum.lastIndexOf(userNum.charAt(i)) != i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 컴퓨터의 숫자 결정(답 결정)
     */
    private void makeComputerNum() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < GameDetail.NUM_COUNT) {
            String randomNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (sb.indexOf(randomNum) == -1) {
                sb.append(randomNum);
            }
        }
        computerNum = sb.toString();
    }

    /**
     * 사용자가 입력한 값과 컴퓨터가 생성한 값을 비교하고 볼 카운트와 스트라이크 카운트 담은 GameResult 반환
     * @param userNum 사용자가 입력한 값
     * @return 게임결과
     */
    private GameResult compareUserNumAndComputerNum(String userNum) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < userNum.length(); i++) {
            int indexFromComputerNum = computerNum.indexOf(userNum.charAt(i));
            if (indexFromComputerNum == i) { // 같은 위치에 같은 숫자가 있는 경우
                gameResult.plusStrikeCount();
            } else if (indexFromComputerNum > -1) { // 같은 위치는 아니지만 존재는 하는 경우
                gameResult.plusBallCount();
            }
        }
        return gameResult;
    }

}
