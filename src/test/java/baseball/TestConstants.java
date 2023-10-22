package baseball;

import java.util.List;

public class TestConstants {

    // Valid constants
    public static final String NULL_STRING = null;
    public static final String EMPTY_STRING = "";
    public static final String SUCCESS_STRING = "123";
    public static final List<Integer> SUCCESS_LIST = List.of(1, 2, 3);
    public static final int SUCCESS_STRING_SIZE = SUCCESS_LIST.size();
    public static final String SUCCESS_LIST_TO_STRING = SUCCESS_LIST.toString();
    public static final int SUCCESS_LIST_FIRST_ELEMENT = SUCCESS_LIST.get(0);
    public static final Integer[] SUCCESS_LIST_REMAINING_ELEMENTS =
            SUCCESS_LIST.subList(1,SUCCESS_STRING_SIZE)
                    .toArray(new Integer[SUCCESS_STRING_SIZE-1]);
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
