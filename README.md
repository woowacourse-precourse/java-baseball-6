# 미션 - 숫자 야구

## 🚀 프로젝트 설치 및 실행 방법:

1. 해당 코드를 실행하고 싶으면 깃허브 Clone or download 녹색 버튼을 누른 후
2. 깃허브 URL을 복사한다
3. 프로젝트를 저장하고 싶은 폴더를 지정해준 후 해당 폴더 경로로 IDE를 연다.(본인이 IntelliJ를 사용하고 있으면 IntelliJ를 사용하면 된다.)
4. IDE 터미널에 아래 와 같은 코드를 처주면 된다.(이때 PowerShell이 아닌 command Promt에 치는 것이 좋다)

```bash
$ git clone <복사했던 URL>
```

5. 터미널에 제대로 코드가 실행 되었다면 IDE에 새로운 폴더가 생겼을 것이다.
6. 경우에 따라서 run 버튼이 활성화가 안 되었을 수도 있다. 이때는 본 파일에 src-main 다음에 있는 java 파일을 우클릭 후, Mark directory as를 클릭한다.
7. Mark directory as에 Source Root을 클릭한다. 이렇게 진행될 시 run을 진행시킬 수 있는 상태가 될 것이다.
8. 터미널 창에

```bash
gradlew.bat clean test
```
을 친다.

## 📮 문제 설명:

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### ✏️입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

---

## 🎯 요구사항 명세서:

- (Main)

- 1. baseball 패키지를 만든다.
- 2. baseball 패키지 안에 프로젝트 main 함수가 들어있는 Application 클래스를 만든다.
- 3. 게임 전반적인 흐름 및 기능(게임의 시작부터 진행, 그리고 끝에 다시 진행할 것인지 물어보는 단계)을 담은 Controller 클래스를 만든다.
- 4. 게임 진행을 담은 클래스가 들어있는 service 페키지를 만든다. 
- 5. 전체적인 게임의 결과 값(스트라이크 수 및 볼 수 )을 가지고 있는 Game 클래스와 사용자의 입력값을 저장하는 클래스가 담긴 domain 패키지를 만든다
- 6. 랜덤으로 숫자를 생성하는 RandomUtils 클래스와 사용자가 입력한 값이 숫자가 되돌고 만드는 Validator 클래스가 있는 Utils 패키지를 만든다.
- 7. 사용자의 의사를 묻는 RequestInput 클래스와 시스템의 결과값을 출력 해내는 SystemMessage 클래스가 담긴 view 패키지를 만든다.

- (정리) 
    - domain 패키지는 게임 및 사용자의 데이터를 저장할 수 있는 객체를 담고 있다
    - service 패키지는 게임 진행 시 스트라이크/ 볼 등을 구하는 객체를 담고 있다
    - utils 패키지는 매 게임마다 생성되는 서로 다른 랜덤 숫자를 생성하는 객체와 사용자가 입력하는 값이 숫자가 되도록 하는 값을 담고 있다.
    - view 패키지는 입출력과 관련된 객체들을 담고 있다.

- 8. game 클래스는 매 경기마다 스트라이크 및 볼 수를 저장하는 클래스이다.
- 9. User 클래스는 사용자가 입력한 값을 저장하는 클래스이다.

- 10. GameService 클래스는 스트라이크가 3개가 되어 숫자 게임이 끝날때까지 과정을 담은 클래스이다.
- 11. RandomUtils 클래스는 매 경기마다 숫자가 무작위로 서로 다른 숫자 조합이 되도록 하는 클래스이다.
- 12. Validator 클래스는 사용자가 입력한 값이 정수 및 제약 조건을 만족하는 지 확인하는 클래스이다.

- 13. RequestInput 클래스는 사용자의 입력을 요구하는 클래스이다
- 14. SystemMessage 클래스 같은 경우 게임의 결과 값에 대한 출력값을 출력하는 클래스이다.

- (Test)

- 

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항




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

#### 사용 예시

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
