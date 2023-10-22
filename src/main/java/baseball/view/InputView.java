package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private int terminate = 0;

    public List<Integer> scanNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String player = readLine();
        return Arrays.stream(player.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public void close() {
        Console.close();
    }

    public void scanIfTerminate() {
        int scanTerminate = -1;
        while (scanTerminate != 1 && scanTerminate != 2) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            scanTerminate = Integer.parseInt(readLine());
        }
        terminate = scanTerminate;
    }

    public boolean isTerminate() {
        return terminate == 2;
    }
}

