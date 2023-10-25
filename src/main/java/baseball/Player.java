package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    PlayerNums playerNums;

    public boolean getRestart() {
        String restartStatus = Console.readLine();
        validateRestart(restartStatus);
        return restartStatus.equals("1");
    }

    private void validateRestart(String readLine) {
        if (!readLine.equals("1") && !readLine.equals("2")) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }

    public void setNums() {
        System.out.print("서로 다른 3자리의 수를 입력해주세요 : ");
        playerNums = new PlayerNums(convertStrPlayerNum(Console.readLine()));
    }

    private List<Integer> convertStrPlayerNum(String strPlayerNum) {
        List<String> stringList = Arrays.asList(strPlayerNum.split(""));
        try {
            return (stringList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }

    public List<Integer> getPlayerNums() {
        return playerNums.getNums();
    }
}
