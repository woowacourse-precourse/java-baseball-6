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

    @Test
    void 볼만_맞춘경우_출력_값_테스트(){
        //given
        GameScore game_score = onlyBallGameScore();

        //when
        CheckGameResult.checkGameScore(game_score,game_coin);

        //then
        assertThat(output()).isEqualTo("3볼");
    }

    @Override
    protected void runMain() {

    }
}
