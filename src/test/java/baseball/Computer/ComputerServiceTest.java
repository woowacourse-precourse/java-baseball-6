package baseball.Computer;

import baseball.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static baseball.Constant.*;

class ComputerServiceTest {

    private ComputerService computerService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        computerService = appConfig.computerService();
    }

    @Test
    @DisplayName("computer에 값이 올바르게 할당되는가 ")
    void checkSettingComputer() {
        // given
        List<Integer> computer = computerService.settingComputer();
        // when, then
        assertTrue(computer.size() == SIZE);
        assertTrue(computer.size() == computer.stream().distinct().count());
    }

}