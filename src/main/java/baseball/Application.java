package baseball;

public class Application {

  public static void main(String[] args) {
    while (true) {
      Printer.start();

      if (!Game.play()) {
        break;
      }
    }
  }
}
