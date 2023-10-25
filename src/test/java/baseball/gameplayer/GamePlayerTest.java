package baseball.gameplayer;

import baseball.gameplayer.GamePlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

class GamePlayerTest {
    GamePlayer gamePlayer = new GamePlayer();
    @Test
    public void resultPrintTest(){
        Map<String,Integer> result = new HashMap<>();
        result.put("strike",1);
        result.put("ball",1);
        gamePlayer.printScore(result);
    }

    @Test
    public void oneTurnTest() {
        List<Integer> computerSelect = new ArrayList<>(Arrays.asList(1, 2, 4));

        ByteArrayInputStream testIn = new ByteArrayInputStream("124".getBytes());
        System.setIn(testIn);
        Map<String, Integer> oneTurnResult = gamePlayer.oneTurn(computerSelect);

        Assertions.assertThat(oneTurnResult.get("strike")).isEqualTo(3);
    }

}