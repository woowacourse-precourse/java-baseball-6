## 프리코스 1주차 - 숫자 야구 미션

### 진행방식
1. 게임이 시작되었다는 출력
2. 게임이 시작하기 전에 BaseBallGame 객체를 생성하고 생성자에 중복되지 않은 랜덤한 1~9 숫자 3자리 값 저장
    - 중복되지 않은 숫자여야 하므로 Set 자료구조 사용하여 문자열을 생성할지 고민 중
3. 이후 야구 게임이 3스트라이크가 될 때까지 3자리 숫자 입력값을 받아와서 결과를 출력
    - 3자리 숫자인지 유효성 검사
    - 생성해둔 랜덤 값과 숫자가 일치하는 알고리즘을 구현
4. 야구 게임이 끝났다면 다시 게임을 진행할지 종료할지 선택
    - '1', '2'인지 유효성 검사
    - '1' 입력시 다시 BaseBallGame 새로 생성하여 진행
    - '2' 입력시 프로그램 종료

<br>

### 예외처리
- 잘못된 입력 예외처리는 모두 IllegalArgumentException 발생시키기
- 야구게임 진행 중 입력시 3자리 숫자가 아닐경우
- 게임을 완료한 후 다시 게임을 진행하는 입력에 '1'이나 '2'가 아닐경우

<br>

### 요구사항
- JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

<br>

### 라이브러리 요구사항
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 사용 예시는 다음과 같음

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

<br>

### 야구게임 진행 알고리즘
- 