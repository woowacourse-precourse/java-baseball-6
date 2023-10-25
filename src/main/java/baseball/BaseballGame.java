package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private String computerAnswer; // 정답 숫자 문자열
    private String playerAnswer; // 사용자가 입력한 숫자 문자열
    private boolean gameClearCheck = false; // 게임 진행 상태 true(진행), false(종료)
    private boolean replayCheck = false; // 재게임 의사

    final int INPUT_ANSWER_RANGE_MIN = 1;
    final int INPUT_ANSWER_RANGE_MAX = 9;
    final int INPUT_ANSWER_LENGTH = 3;

    public void initGame() { //
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            setGame(); // 관련 설정 초기화 세팅
            gameStart(); // 게임 루프 시작
        } while (this.replayCheck);
        // 위 루프가 끝난다는 것은 게임이 끝났다는 것
    }

    public void setGame() { // 관련 설정 초기화 세팅
        createRandomNumber(); // 정답 랜덤 번호 생성
        this.gameClearCheck = false; // 게임 클리어 상태
    }

    public void gameStart() { // 게임 시작
        String result = "";
        do {
            getPlayerGuess(); // 입력받기
            result = checkStrikeAndBall(playerAnswer);
            System.out.println(result);
            checkAnswer();
        } while (this.gameClearCheck == false); // 게임 클리어할때까지 반복
    }

    public void checkAnswer() {
        if (playerAnswer.equals(computerAnswer)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            askRestart(); // 다시 할 것인지 물어보기
        }
    }

    public String checkStrikeAndBall(String input) {
        int countBall = 0;
        int countStrike = 0;
        String messageScore = "";
        String messageBall = "";
        String messageStrike = "";
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (inputChar == computerAnswer.charAt(i)) {
                countStrike++;
            } else if (computerAnswer.contains(String.valueOf(inputChar))) {
                countBall++;
            }
        }
        if (countBall > 0) {
            messageBall = String.valueOf(countBall) + "볼 ";
        }
        if (countStrike > 0) {
            messageStrike = String.valueOf(countStrike) + "스트라이크";
        }
        if (countBall + countStrike > 0) {
            messageScore = messageBall + messageStrike;
        }
        if (countBall == 0 && countStrike == 0) {
            messageScore = "낫싱";
        }
        return messageScore;
    }

    public void askRestart() { // 게임 재시작 의사 묻기
        String playerChoice = "";
        this.gameClearCheck = true; // 여기까지 왔다는건 클리어 했다는 뜻
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        playerChoice = Console.readLine();
        if (playerChoice.equals("1")) { // 재시작
            this.replayCheck = true;
        }
        if (playerChoice.equals("2")) { // 게임종료
            this.replayCheck = false;
        }
    }

    public void createRandomNumber() { // 정답 랜덤 번호 생성
        List<Integer> computer = new ArrayList<>();
        StringBuilder answerString = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                answerString.append(Integer.toString(randomNumber));
            }
        }
        this.computerAnswer = answerString.toString();
        System.out.println("정답 숫자: " + this.computerAnswer);
    }

    // 2. 사용자 입력 받기
    public void getPlayerGuess() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        checkInteger(input);
        checkLength(input);
        checkSameNumber(input);
        checkRange(input);
        this.playerAnswer = input;
    }

    public void checkInteger(String input) { // 사용자가 입력한 값이 정수가 아닌경우 체크
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("입력값은 반드시 정수여야 합니다.");
            }
        }
    }

    public void checkSameNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("입력값은 서로 다른 숫자로 이루어져야 합니다.");
                }
            }
        }
    }

    public void checkLength(String input) {
        if (input.length() != INPUT_ANSWER_LENGTH) {
            throw new IllegalArgumentException("입력값의 길이는 " + INPUT_ANSWER_LENGTH + "자리 이어야합니다.");
        }
    }

    public void checkRange(String input) {
        int eachDigit;
        for (int i = 0; i < input.length(); i++) {
            eachDigit = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (eachDigit < INPUT_ANSWER_RANGE_MIN || INPUT_ANSWER_RANGE_MAX < eachDigit) {
                throw new IllegalArgumentException(
                        "입력값은 " + INPUT_ANSWER_RANGE_MIN + " 이상" + INPUT_ANSWER_RANGE_MAX + " 이하여야 합니다.");
            }
        }
    }
}