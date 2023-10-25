package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class GameNumbers {
    private int[] numsList;

    private int getRandomNumbers() {
        return Randoms.pickNumberInRange(1,9);
    }

    // Set의 정수 값 배열 형태로 변환
    private int[] intToArray (Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void setNumsList(String input) {
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        this.numsList = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private boolean isValidString(String str) {
        if(!isCorrectLength(str) || !isInNumRange(str) || !isNotDuplicate(str)) {
            return false;
        }
        return true;
    }

    private boolean isCorrectLength(String input) {
        return input.length() == 3;
    }

    private boolean isInNumRange(String input) {
        Pattern numberPattern = Pattern.compile("^["+1+"-"+9+"]*$");
        return numberPattern.matcher(input).matches();
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for(char s: input.toCharArray()) {
            set.add(s);
        }
        return input.length() == set.size();
    }

    public int[] getNumsList() {
        return this.numsList;
    }

    public void setRandomNumbers() {
        Set<Integer> numsListSet = new HashSet<>();

        while(numsListSet.size() < 3) {
            numsListSet.add(getRandomNumbers());
        }
        this.numsList = intToArray(numsListSet);

    }

    public void inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        setNumsList(input);
    }

    public void inputAnswer(String str) {
        setNumsList(str);
    }
}
