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

}