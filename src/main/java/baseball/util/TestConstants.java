package baseball.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestConstants {

    // Valid constants
    public static final String NULL_STRING = null;
    public static final String EMPTY_STRING = "";
    public static final String FIRST_SUCCESS_STRING = "123";
    public static final String EXPECTED_TWO_BALL_ONE_STRIKE = "654";
    public static final String SECOND_SUCCESS_STRING = "456";
    public static final List<Integer> FIRST_LIST = List.of(1, 2, 3);
    public static final List<Integer> SECOND_LIST = List.of(4, 5, 6);
    public static final List<Integer> FULL_LIST = Stream.concat(FIRST_LIST.stream(), SECOND_LIST.stream())
            .collect(Collectors.toList());

    public static final String FIRST_LIST_TO_STRING = FIRST_LIST.toString();
    public static final int FULL_LIST_SIZE = FULL_LIST.size();
    public static final int FULL_LIST_FIRST_ELEMENT = FULL_LIST.get(0);
    public static final Integer[] FULL_LIST_REMAINING_ELEMENTS =
            FULL_LIST.subList(1, FULL_LIST_SIZE)
                    .toArray(new Integer[FULL_LIST_SIZE - 1]);
    public static final String RESTART = "1";
    public static final String TERMINATE = "2";

    // Invalid constants making exception
    public static final String NOT_NUMBER_STRING = "ABC";
    public static final String OUT_OF_RANGE_NUMBER = "012";
    public static final String SHORTER_THAN_NUMBER_LENGTH_LIMIT = "12";
    public static final String LONGER_THAN_NUMBER_LENGTH_LIMIT = "1234";
    public static final String DUPLICATE_NUMBER_STRING = "112";
    public static final String NOT_BOTH_RESTART_AND_TERMINATE = "3";


}
