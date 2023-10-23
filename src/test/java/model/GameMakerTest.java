package model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameMakerTest {

    @Test
    @DisplayName("문제 생성 테스트")
    public void createNewAnswer() {
        List<Integer> answer = GameMaker.createGameMaker();
        assertThat(answer.size()).isEqualTo(3);

        Set<Integer> answerSet = new HashSet<>(answer);
        assertThat(answerSet.size()).isEqualTo(3);
    }

}