package constant;

import java.util.List;
import java.util.stream.Stream;

public class TestConstant {
    public static final String BASEBALL_GAME_TEST_DATA_1 = "456";
    public static final String BASEBALL_GAME_TEST_DATA_2 = "124";
    public static final String BASEBALL_GAME_TEST_DATA_3 = "123";
    public static final String BASEBALL_GAME_TEST_DATA_4 = "167";
    public static final String BASEBALL_GAME_TEST_DATA_5 = "356";
    public static final String BASEBALL_GAME_TEST_DATA_6 = "354";
    public static final String BASEBALL_GAME_TEST_DATA_7 = "456";
    public static final String RESTART_GAME_VALUE = "1";
    public static final String FINISH_GAME_VALUE = "2";
    public static final String NOTHING = "낫싱";
    public static final String TWO_STRIKE = "2스트라이크";
    public static final String THREE_STRIKE = "3스트라이크";
    public static final String ONE_BALL = "1볼";
    public static final String ONE_BALL_AND_ONE_STRIKE = "1볼 1스트라이크";
    public static final String FINISH_GAME = "게임 종료";

    public static final String FIRST_ANSWER = "123";
    public static final String SECOND_ANSWER = "456";
    public static final List<Integer> FIRST_ANSWER_SPLIT = List.of(1, 2, 3);
    public static final List<Integer> SECOND_ANSWER_SPLIT = List.of(4, 5, 6);
    public static final List<Integer> ANSWER_LIST = List.of(Integer.parseInt(FIRST_ANSWER),
            Integer.parseInt(SECOND_ANSWER));
    public static final List<Integer> ANSWER_LIST_SPLIT = Stream.concat(FIRST_ANSWER_SPLIT.stream(),
            SECOND_ANSWER_SPLIT.stream()).toList();
    public static final Integer ANSWER_LIST_FIRST_ELEM = ANSWER_LIST_SPLIT.get(0);
    public static final Integer[] ANSWER_LIST_OTHER_ELEM = ANSWER_LIST_SPLIT.subList(1, ANSWER_LIST_SPLIT.size())
            .stream()
            .toArray(Integer[]::new);

    public static final String NULL_TEST = null;
    public static final String EMPTY_TEST = "";
    public static final String PLAYER_INPUT_INVALID_TYPE_TEST = "1a2";
    public static final String PLAYER_INPUT_SHORT_LENGTH_TEST = "12";
    public static final String PLAYER_INPUT_EXCEED_LENGTH_TEST = "1234";
    public static final String PLAYER_INPUT_ZERO_TEST_1 = "012";
    public static final String PLAYER_INPUT_ZERO_TEST_2 = "102";
    public static final String PLAYER_INPUT_ZERO_TEST_3 = "120";
    public static final String PLAYER_INPUT_DUPLICATION_TEST = "112";

    public static final String RESTART_INVALID_TEST = "a";
    public static final String RESTART_INVALID_LENGTH_TEST = "12";
    public static final String RESTART_INVALID_ZERO_TEST = "0";
}
