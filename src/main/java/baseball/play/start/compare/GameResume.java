package baseball.play.start.compare;

public sealed interface GameResume permits Nothing, OneBall, OneBallOneStrike, OneBallTwoStrike,
    OneStrike, TwoStrike, ThreeBall, TwoBall, TwoBallOneStrike {

  String randomNums();

  String getResumeMessage();
}

record Nothing(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "낫싱";
  }
}

record OneBall(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "1볼";
  }
}

record OneStrike(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "1스트라이크";
  }
}

record OneBallOneStrike(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "1볼 1스트라이크";
  }
}

record TwoStrike(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "2스트라이크";
  }
}

record OneBallTwoStrike(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "1볼 2스트라이크";
  }
}

record TwoBall(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "2볼";
  }
}

record TwoBallOneStrike(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "2볼 1스트라이크";
  }
}

record ThreeBall(String randomNums) implements GameResume {

  @Override
  public String getResumeMessage() {
    return "3볼";
  }
}

