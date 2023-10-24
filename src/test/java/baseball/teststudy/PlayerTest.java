//package baseball;
//
//import org.junit.jupiter.api.BeforeAll;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
//public class PlayerTest {
//
//    private static Player player;
//
//    @BeforeAll
//    public static void setup(){ player = new Player(); }
//
//    @Test
//    public void testNullNumber(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.inputNumbers(null);
//        });
//    }
//
//    @Test
//    public void testLongNumber(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.inputNumbers("1234");
//        });
//    }
//
//    @Test
//    public void testZeroNumber(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.inputNumbers("102");
//        });
//    }
//
//    @Test
//    public void testDuplicateNumber(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.inputNumbers("112");
//        });
//    }
//
//    @Test
//    public void testValidNumber(){ assertEquals("123", player.inputNumbers("123")); }
//
//    @Test
//    public void testNullFlag(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.conformGameRestart(null);
//        });
//    }
//
//    @Test
//    public void testMinusFlag(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.conformGameRestart("-1");
//        });
//    }
//
//    @Test
//    public void testOutRangeFlag(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            player.conformGameRestart("3");
//        });
//    }
//
//    @Test
//    public void testValidFlag(){
//        assertTrue(player.conformGameRestart("1"));
//        assertFalse(player.conformGameRestart("2"));
//    }
//}
