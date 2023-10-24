package baseball;

import java.util.List;
import java.util.stream.Stream;

public enum Type {
  BALL("볼"),
  STRIKE("스트라이크");

  private final String type;

  Type(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public static List<String> getAllKinds() {
    return Stream.of(Type.values())
        .map(Type::getType)
        .toList();
  }

}
