package baseball;

import baseball.core.CheckGameResult;
import baseball.core.CompareNumber;
import baseball.core.GenerateNumberList;
import baseball.property.GameCondition;
import baseball.property.GameScore;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CoreTest extends NsTest {

    @Test
    void 컴퓨터_랜덤_숫자_생성_옳바른_개수만큼_생성하는지_테스트(){
        //given
        int generate_cnt = 3;
        //when
        List<Integer> computer = generateNumberListMethodCall(generate_cnt);

        //then
        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    void 사용자_입력_값_리스트_변경_테스트(){
        //given
        String user_input_value="123";

        //when
        List<Integer> user = GenerateNumberList.generateInputValueToUser(user_input_value);

        //then
        assertThat(user.size()).isEqualTo(3);
        assertThat(user).isInstanceOf(List.class);
    }

    private List<Integer> generateNumberListMethodCall(int generate_cnt){
        return GenerateNumberList.generateRandomNumberToComputer(generate_cnt);
    }

    @Test
    void 유저_리스트와_컴퓨터_리스트_값_비교_볼_테스트(){
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(3, 1, 2);

        //when
        GameScore game_score = CompareNumber.compareNumberList(user, computer);

        //then
        assertThat(game_score.getBall_count()).isEqualTo(3);
        assertThat(game_score.getStrike_count()).isEqualTo(0);
    }

    @Test
    void 유저_리스트와_컴퓨터_리스트_값_비교_볼_스트라이크_테스트(){
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 3, 2);

        //when
        GameScore game_score = CompareNumber.compareNumberList(user, computer);

        //then
        assertThat(game_score.getBall_count()).isEqualTo(2);
        assertThat(game_score.getStrike_count()).isEqualTo(1);
    }

    @Test
    void 유저_3스트라이크_시_게임종료_테스트(){
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 2, 3);
        GameCondition game_coin=GameCondition.CONTINUE;

        //when
        GameScore game_score = CompareNumber.compareNumberList(user, computer);
        game_coin = CheckGameResult.checkGameScore(game_score, game_coin);
        //then
        assertThat(game_coin).isEqualTo(GameCondition.FINISH);
    }

    @Test
    void 유저_리스트와_컴퓨터_리스트_값_비교_스트라이크_테스트(){
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 2, 3);

        //when
        GameScore game_score = CompareNumber.compareNumberList(user, computer);

        //then
        assertThat(game_score.getBall_count()).isEqualTo(0);
        assertThat(game_score.getStrike_count()).isEqualTo(3);
    }

    @Override
    protected void runMain() {

    }
}
