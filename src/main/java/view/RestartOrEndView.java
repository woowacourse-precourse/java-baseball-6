/*
 * <pre>
 * Class : RestartOrEndView
 * Comment: 사용자로부터 재시작 여부를 입력받는다.
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           매직넘버 상수 대체
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package view;

import camp.nextstep.edu.missionutils.Console;

public class RestartOrEndView {
    public static final int RESTART_MISSION = 1;
    public static final int END_MISSION = 2;

    public static boolean userInput() {
        int restartOrEnd = Integer.parseInt(Console.readLine());
        if (restartOrEnd == RESTART_MISSION) {
            return true;
        } else if (restartOrEnd == END_MISSION) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
