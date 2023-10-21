# 숫자야구  
## 기능 요구 사항
- 컴퓨터
  - 1~9까지의 숫자 중 임의의 3개의 수를 선택한다.
  - 사용자에게 입력을 받은 숫자에 대한 결과를 출력한다.
    - 스트라이크 : 숫자와 숫자의 자리가 일치하는 경우
    - 볼 : 스트라이크가 아니면서 수가 포함 되는 경우
    - 낫싱 : 스트라이크와 볼이 0개인 경우
- 사용자
  - 사용자는 서로다른 3개의 숫자를 입력한다.
  - 입력하는 숫자는 1~9까지의 숫자이다.
- 3개의 숫자를 모두 맞추면 종료된다.
  - 스트라이크가 3개인 경우
- 잘못된 입력일 경우 `IllegalArgumentException`을 발생시킨 후 종료되어야 한다.
  - 입력은 1~9까지의 서로 다른 3개의 수이다.
- 게임을 다시 시작하거나 종료할 수 있다.
  - 게임이 종료된 경우 재시작 - 1, 종료 - 2
---
## 프로그래밍 요구 사항
- JDK17
- 프로그램의 시작은 main()
- 외부 라이브러리 사용 금지 및 build.gradle 파일 변경 금지
- System.exit() 호출 불가
- 모든 테스트 코드가 성공 해야 한다.
- Random 및 Console API를 구현
  ### camp.nextstep.edu.missionutils.Console.pickNumberInRange()
    ```java
    public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
    }
    ```
    - 해당 메소드는 시작과 끝 범위를 파라미터로 받는다.
    ```java
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    ```
    - 이후 다음과 같은 조건 검사를 한다.
      1. 시작 수가 끝나는 수보다 작은가?
      2. 끝 값이 int의 범위인가?
      3. 범위가 int의 범위인가?
    - 이후 Random 객체의 nextInt()로 범위 내의 숫자를 랜덤으로 생성한다.

  ### camp.nextstep.edu.missionutils.Console.readLine()
  - 다음 Console은 싱글톤 패턴의 Scanner를 가지고 있는 객체이다.
  - Scanner의 nextLine()을 사용해 개행문 전까지 입력을 받아온다.
  ```
  싱글톤 패턴?
  싱글톤 패턴은 실제로 생성되는 객체는 하나로 최초 생성 이후 호출된 생성자는 최초에 생성된 객체를 리턴한다.
  ```
---
[1주차](https://actually-enquiry-3f3.notion.site/1-0c3c1d3989c4424c886eb74f6c332195?pvs=4)