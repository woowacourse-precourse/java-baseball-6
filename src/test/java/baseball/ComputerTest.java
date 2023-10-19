package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.ComputerController;

/**
 * packageName    : baseball
 * fileName       : ComputerTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class ComputerTest extends NsTest {
    ComputerController computerController = new ComputerController();

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
