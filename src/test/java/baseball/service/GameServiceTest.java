package baseball.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.config.AppConfig;
import baseball.dto.HintDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 3 Strike의 경우")
    void isAllStrike() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{1, 2, 3};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isTrue();
        assertThat(hintDTO.getMessage()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 3 Ball의 경우")
    void is3Ball() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{3, 1, 2};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : Nothing의 경우")
    void isNothing() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{4, 5, 6};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 1볼 1스트라이크의 경우")
    void is1Ball1Strike() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{3, 2, 4};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 2볼 1스트라이크의 경우")
    void is2Ball1Strike() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{3, 2, 1};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 2스트라이크의 경우")
    void is2Strike() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{4, 2, 3};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("입력 값에 따른 상태 값이 잘 설정되는지 확인 : 2볼의 경우")
    void is2Ball() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.gameService();

        List<Integer> baseballNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] inputNumbers = new int[]{4, 3, 1};
        HintDTO hintDTO = gameService.process(baseballNumbers, inputNumbers);

        assertThat(hintDTO.isAllStrike()).isFalse();
        assertThat(hintDTO.getMessage()).isEqualTo("2볼");
    }

}