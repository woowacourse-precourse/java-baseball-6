package baseball;

<<<<<<< HEAD
=======
import camp.nextstep.edu.missionutils.Console;
>>>>>>> parent of 57b5d2f (refactor. mvc 패턴 적용 시도)
import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public List<Integer> playerNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNum = new ArrayList<>();
        String inputNum = Console.readLine();

        checkSize(inputNum);

        for (String number : inputNum.split("")) {
            if (playerNum.contains(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }

    private void checkSize(String inputNum) throws IllegalArgumentException {
        if (inputNum.length() != ConstantVO.SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
