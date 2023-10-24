## ✏️ 과제 진행 요구 사항

- ## 🚀 기능 요구 사항

0. 컴퓨터는 1~9 사이의 중복되지 않는 3자리 숫자를 랜덤으로 생성한다.
1. 사용자로부터 서로 다른 3자리 숫자를 입력받는다.
2. 만약 사용자가 아래와 같이 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료된다.
   - 입력받은 숫자가 3자리 숫자가 아닌 경우
   - 입력받은 숫자에 중복된 숫자가 있는 경우
   - 입력받은 숫자가 숫자가 아닌 경우
   - 입력받는 숫자가 1~9가 아닌 경우
   - 입력받는 숫자가 공백인 경우
4. 생성한 숫자와 입력받은 숫자를 비교한다.
5. 비교한 결과를 볼, 스트라이크라는 힌트와 개수로 출력한다. 
   - 같은 수가 같은 자리에 있으면 스트라이크
   - 같은 수가 다른 자리에 있으면 볼
   - 같은 수가 전혀 없으면 낫싱
   - {숫자}{힌트} {숫자}{힌트} 형식으로 출력한다. ex) 1볼 1스트라이크
6. 비교한 결과가 3스트라이크라면, 게임을 종료한다.
7. 비교한 결과가 3스트라이크가 아니라면, 1번부터 다시 시작한다.
8. 게임이 끝난 경우 재시작/종료를 1과 2중 하나의 수로 입력 받는다.
   - 입력받은 숫자가 1, 2가 아닌 경우 모두 `IllegalArgumentException` 예외 발생

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.

- 라이브러리
  - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
