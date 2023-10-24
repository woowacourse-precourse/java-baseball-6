## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


## 🚀 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.<br>
1. 같은 수가 같은 자리에 있으면 "스트라이크" <br> 
2. 다른 자리에 있으면 "볼" <br>
3. 같은 수가 전혀 없으면 "낫싱"<br>
4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
5. 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
6. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## ✏️ 필요기능 
1. 사용자가 숫자를 입력하는 기능.
2. 입력받은 숫자를 검증하는 기능.
3. 상대방의 숫자를 설정하는 기능.
4. 상대방의 숫자를 검증하는 기능.
5. 사용자의 숫자와 상대방의 숫자를 비교하며 결과를 확인하는 기능.
6. 정답을 맞추면 재시작 또는 종료하는 기능.





