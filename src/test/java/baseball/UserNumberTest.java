package baseball;

import org.junit.jupiter.api.Test;

class UserNumberTest {

  @Test
  void isUserNumberSetByTest() {
    UserNumber user = new UserNumber(123);
    System.out.println(user.getUserNumber());
  }

}
