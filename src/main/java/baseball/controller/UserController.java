package baseball.controller;

import baseball.dto.NumDto;
import baseball.dto.StrikeBallDto;
import baseball.service.CompareService;
import camp.nextstep.edu.missionutils.Console;

public class UserController {

    private final CompareService compareService = new CompareService();

    public void guessNumber(NumDto numDto) {

        int len = numDto.numList().size();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String readStr = Console.readLine();

            // 유효성 검사 >> 3자리, 1-9
            if (readStr.length() != len || !readStr.matches("[1-9]+")) {
                throw new IllegalArgumentException();
            }
            // 중복 유무 유효성 검사
            boolean[] checkNum = new boolean[9];
            for (char n : readStr.toCharArray()) {
                int a = n - '1';
                if (checkNum[a]) {
                    throw new IllegalArgumentException();
                }
                checkNum[a] = true;
            }

            if (viewSBNum(compareService.calSB(readStr, numDto), len)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }

    }

    public boolean isOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String readStr = Console.readLine();

        // 유효성 검사
        if (!readStr.equals("1") && !readStr.equals("2")) {
            throw new IllegalArgumentException();
        }

        if (readStr.equals("1")) { // 재시작
            return false;
        }
        // 종료
        return true;
    }

    private boolean viewSBNum(StrikeBallDto strikeBallDto, int len) {
        int sN = strikeBallDto.strikeNum();
        int bN = strikeBallDto.ballNum();

        if (sN == len) {
            System.out.println(String.format("%d스트라이크", sN));
            return true;
        } else if (sN + bN == 0) {
            System.out.println("낫싱");
        } else if (sN == 0) {
            System.out.println(String.format("%d볼", bN));
        } else if (bN == 0) {
            System.out.println(String.format("%d스트라이크", sN));
        } else {
            System.out.println(String.format("%d볼 %d스트라이크", bN, sN));
        }
        return false;
    }
}
