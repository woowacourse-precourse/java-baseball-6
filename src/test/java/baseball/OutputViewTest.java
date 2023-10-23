package baseball;

import baseball.core.CheckGameResult;
import baseball.core.CompareNumber;
import baseball.property.GameCondition;
import baseball.property.GameScore;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OutputViewTest extends NsTest {

    private final List<Integer> computer_number=generateComputerNumberList();
    private final GameCondition game_coin=GameCondition.CONTINUE;

    private List<Integer> generateComputerNumberList(){
        return List.of(1,2,3);
    }

    private GameScore onlyBallGameScore(){
        List<Integer> user_number = List.of(3, 1, 2);
        return CompareNumber.compareNumberList(user_number, computer_number);
    }

    private GameScore onlyStrikeGameScore(){
        List<Integer> user_number = List.of(1, 2, 4);
        return CompareNumber.compareNumberList(user_number,computer_number);
    }

    private GameScore threeStrikeGameScore(){
        List<Integer> user_number = List.of(1, 2, 3);
        return CompareNumber.compareNumberList(user_number,computer_number);
    }

    private GameScore nothingGameScore(){
        List<Integer> user_number = List.of(4, 5, 6);
        return CompareNumber.compareNumberList(user_number,computer_number);
    }

    @Test
    void 볼만_맞춘경우_출력_값_테스트(){
        //given
        GameScore game_score = onlyBallGameScore();

        //when
        CheckGameResult.checkGameScore(game_score,game_coin);

        //then
        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    void 스트라이크만_맞춘경우_출력_값_테스트(){
        //given
        GameScore game_score = onlyStrikeGameScore();

        //when
        CheckGameResult.checkGameScore(game_score,game_coin);

        //then
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void 스트라이크_3개_맞춘경우_출력_값_테스트(){
        //given
        GameScore game_score = threeStrikeGameScore();

        //when
        CheckGameResult.checkGameScore(game_score,game_coin);

        //then
        assertThat(output()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void 아무것도_못_맞춘경우_출력_값_테스트(){
        //given
        GameScore game_score = nothingGameScore();

        //when
        CheckGameResult.checkGameScore(game_score,game_coin);

        //then
        assertThat(output()).isEqualTo("낫싱");
    }

    @Override
    protected void runMain() {

    }
}
