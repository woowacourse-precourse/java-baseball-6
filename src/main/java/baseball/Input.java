package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {

    private final List<Integer> inputs;

    Input(){
        this.inputs = new ArrayList<>();
    }

    void setRandomNumber() {
        while (inputs.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!inputs.contains(randomNumber)) {
                inputs.add(randomNumber);
            }
        }
    }

    void setPlayerNumber (String s) throws IllegalArgumentException { //입력 과정에서 들어올 수 있는 모든 경우를 체크해서 예외가 발생하도록 해야 한다.
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)){
                throw new IllegalArgumentException();
            }
            inputs.add(Character.getNumericValue(c));
        }
        if (inputs.size() != 3 || hasDuplicateElements(inputs) || inputs.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    boolean hasDuplicateElements(List<Integer> list) {
        Map<Object, Integer> elementCounts = new HashMap<>();

        for (Object element : list) {
            elementCounts.put(element, elementCounts.getOrDefault(element, 0) + 1);
            if (elementCounts.get(element) > 1) {
                return true;
            }
        }

        return false;
    }

    List<Integer> getNumber() { //get 말고 다른 방법이 있진 않았을까?
        return inputs;
    }

    static boolean isEnd(String d) throws IllegalArgumentException { //여기서는 허용되는 입력값이 1, 2 밖에 없으므로 if문 대신 switch/case를 활용해보자.
        int endNumber = Integer.parseInt(d);

        return switch (endNumber) {
            case 1 -> false;
            case 2 -> {
                System.out.println("게임이 종료 되었습니다.");
                yield true;
            }
            default -> throw new IllegalArgumentException();
        };
    }
}