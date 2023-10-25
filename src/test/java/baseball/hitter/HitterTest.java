package baseball.hitter;

import baseball.AppConfig;
import baseball.game.hitter.Hitter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HitterTest {

    Hitter hitter;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig = new AppConfig();
        hitter = appConfig.hitter();
    }

    @Test
    void hitterSwingTest(){
        //given
        String bat = "";
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        bat = hitter.swing();
        //then
        Assertions.assertThat(bat).isEqualTo(input);
    }

    @Test
    void hitterSwingIllegalArgumentTest(){
        //given
        String bat = "";
        String input = "1233";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Assertions.assertThatThrownBy(() -> hitter.swing())
                .isInstanceOf(IllegalArgumentException.class);
        //then
        //sucess
    }

    @Test
    void hitterSwingIllegalArgumentTest2(){
        //given
        String bat = "";
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Assertions.assertThatThrownBy(() -> hitter.swing())
                .isInstanceOf(IllegalArgumentException.class);
        //then
        //sucess
    }
}
