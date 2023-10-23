package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerUtilTest {

    private ComputerUtil computerUtil = new ComputerUtil();
    @Test
    void 컴퓨터_숫자_생성() {
        List<Integer> computerNumber = computerUtil.generateComputerNumber();
        System.out.println(computerNumber);
    }
}