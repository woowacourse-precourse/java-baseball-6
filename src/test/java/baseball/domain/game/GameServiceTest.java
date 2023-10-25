package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private GameService gameService;

    @Test
    @DisplayName("동일한 싱글톤 인스턴스를 반환합니다.")
    void getInstance() {
        // GIVEN
        GameService instance1 = GameService.getInstance();

        // WHEN
        GameService instance2 = GameService.getInstance();

        // THEN
        assertThat(instance1).isEqualTo(instance2);
    }

    @BeforeEach
    void setUp() {
        gameService = GameService.getInstance();
    }

    @AfterEach
    void tearDown() {
        // 게임 서비스 초기화
        GameService.clearInstance();
        // Console 초기화
        Console.close();
    }

    @Test
    @DisplayName("게임을 시작하고, 정답이라면 true를 반환합니다")
    void endsGameIfAnswer() {
        // GIVEN
        // randomNumbers 생성
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);
        // 정답 문자열 입력
        String userAnswer = "123";
        InputStream answerStream = new ByteArrayInputStream(userAnswer.getBytes());
        System.setIn(answerStream);

        // WHEN
        boolean isGameEnded = gameService.hasGameEnded(randomNumbers);

        // THEN
        assertThat(isGameEnded).isTrue();
    }

    @Test
    @DisplayName("사용자로부터 입력을 받고, 종료를 선택했는지 판별합니다.")
    void hasSelectedEndGame() {
        // GIVEN
        // 종료 문자열 입력
        String userOption = "2";
        InputStream answerStream = new ByteArrayInputStream(userOption.getBytes());
        System.setIn(answerStream);

        // WHEN
        boolean isEndGame = gameService.hasSelectedEndGame();

        // THEN
        assertThat(isEndGame).isTrue();
    }

    @Test
    @DisplayName("사용자로부터 입력을 받고, 재시작을 선택했는지 판별합니다.")
    void hasSelectedRestartGame() {
        // GIVEN
        // 종료 문자열 입력
        String userOption = "1";
        InputStream answerStream = new ByteArrayInputStream(userOption.getBytes());
        System.setIn(answerStream);

        // WHEN
        boolean isRestartGame = gameService.hasSelectedEndGame();

        // THEN
        assertThat(isRestartGame).isFalse();
    }

    @Test
    @DisplayName("사용자로부터 입력을 받고, 종료와 재시작이 아닌 옵션을 선택한 경우 예외처리합니다.")
    void throwExceptionWhenNotValidOption() {
        // GIVEN
        // 종료 문자열 입력
        String userOption = "4";
        InputStream answerStream = new ByteArrayInputStream(userOption.getBytes());
        System.setIn(answerStream);

        // WHEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            boolean isRestartGame = gameService.hasSelectedEndGame();
        });

        // THEN
        assertThat(thrown.getMessage()).isEqualTo("재시작 여부는 1(재시작)과 2(종료) 중 하나만 입력해주세요.");
    }

    @Test
    @DisplayName("야구게임을 시작하고, 정답이라면 true를 반환합니다.")
    void doBaseballGame() {
        // GIVEN
        // 정답 리스트 생성
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);
        // 정답 문자열 입력
        String userAnswer = "123";
        InputStream answerStream = new ByteArrayInputStream(userAnswer.getBytes());
        System.setIn(answerStream);

        // WHEN
        boolean result = gameService.doBaseballGame(randomNumbers);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("게임종료를 선택하면 true를 반환합니다.")
    void doesRestartGame() {
        // GIVEN
        // 게임종료 문자열 입력
        String userOption = "2";
        InputStream answerStream = new ByteArrayInputStream(userOption.getBytes());
        System.setIn(answerStream);

        // WHEN
        boolean endOption = gameService.isEndOption(userOption);

        // THEN
        assertThat(endOption).isTrue();
    }

    @Test
    @DisplayName("주어진 랜덤값과 사용자 입력값 비교 후, 정답이라면 true를 반환합니다")
    void hasRightAnswer() {
        // GIVEN
        // 정답 리스트 생성
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);
        // 사용자 입력 생성
        List<Integer> userAnswers = new ArrayList<>();
        userAnswers.add(1);
        userAnswers.add(2);
        userAnswers.add(3);

        // WHEN
        boolean result = gameService.hasRightAnswer(userAnswers, randomNumbers);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("주어진 랜덤값과 사용자 입력값 비교 후, 오답이라면 false를 반환합니다")
    void hasBadAnswer() {
        // GIVEN
        // 정답 리스트 생성
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);
        // 사용자 입력 생성 :: 오답
        List<Integer> userAnswers = new ArrayList<>();
        userAnswers.add(7);
        userAnswers.add(8);
        userAnswers.add(9);

        // WHEN
        boolean result = gameService.hasRightAnswer(userAnswers, randomNumbers);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("사용자 입력을 검증하고, 리스트로 변환합니다.")
    void getUserAnswerInputs() {
        // GIVEN
        // 사용자 입력
        String userAnswer = "123";
        InputStream answerStream = new ByteArrayInputStream(userAnswer.getBytes());
        System.setIn(answerStream);

        // WHEN
        List<Integer> userAnswerInputs = gameService.getUserAnswerInputs();

        // THEN
        String collectedAnswer = userAnswerInputs.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        assertThat(collectedAnswer).isEqualTo(userAnswer);
    }
}