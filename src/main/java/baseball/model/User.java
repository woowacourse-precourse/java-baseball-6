package baseball.model;

import baseball.Message;
import baseball.NumberLimits;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final List<Integer> userNumberList;

    public User(String userNumber) {
        userNumberList = new ArrayList<>();
        String[] userNumberArray = userNumber.split("");
        for (String str : userNumberArray) {
            try {
                userNumberList.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                // 예외 처리: 유효하지 않은 숫자 형식의 문자열일 경우
                throw new IllegalArgumentException(Message.INVALID_VALUE.getMessage());
            }
        }
        validateInput();
    }

    private void validateInput() {
        //set을 이용한 중복검사
        Set<Integer> set = new HashSet<Integer>(userNumberList);
        if (userNumberList.size() > NumberLimits.NUM_LIST_LENGTH.getValue()
                || userNumberList.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException(Message.THREE_NUMBERS_REQUIRED.getMessage());
        }
        for (Integer num : userNumberList) {
            if (num < NumberLimits.MIN_VALUE.getValue() || num > NumberLimits.MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(Message.NUMBER_RANGE.getMessage());
            }
        }
        if (set.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException(Message.UNIQUE_NUMBERS.getMessage());
        }
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

}
