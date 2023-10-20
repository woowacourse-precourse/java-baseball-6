# 미션 - 숫자 야구

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

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

## 🚀 기능 요구 사항 분석하기 

[프로그램의 목표] 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- 같은 수와 같은 자리면 -> 스트라이크
- 같은 수, 다른 자리면 -> 볼
- 같은 수가 전혀 없는 경우 -> 낫싱
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱

- Number(자리, 수)
- DifferentTrippleNumbers : Number 3개를 가진 Collection 클래스 
- 스트라이크, 볼, 낫싱은 enum으로 관리하자 

- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다 : Computer#generateThreeRandomNumbers()
- 플레이어는 컴퓨터가 생각하는 서로 다른 3개의 숫자를 입력한다 : InputView#inputThreeNumbers()
- 컴퓨터는 입력한 숫자에 대한 결과를 출력한다 : OutputView#displayGameResult()

- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임의 종료 조건은 컴퓨터가 선택한 서로 다른 3개의 숫자를 모두 맞힌 경우이다
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 종료한 이후 게임을 다시 시작할 수 있거나 혹은 완전히 종료할 수 있다 InputView#chooseStartOrTerminate()

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- [**예외**] 사용자가 잘못된 값을 입력한 경우 (ex. 3자리 서로 다른 숫자를 만족하지 못한 상황)
  - [**예외 처리**] `IllegalArgumentException`을 발생하고, 애플리케이션을 종료한다 
  
### Skeleton 작성하기

#### 숫자 야구 게임을 시작하는 메세지를 출력합니다 
- 숫자를 입력하라는 메세지를 출력하고 사용자로부터 입력을 받습니다 
  - [x] 사용자는 서로 다른 세 가지의 수를 입력합니다
    - [x] [**예외**] 아무것도 입력하지 않은 경우
    - [x] [**예외**] 3가지를 지키지 않은 경우 
        - [x] 1,2가지로 적게 입력한 경우 혹은 4,5가지 수를 입력한 경우
    - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다 
      
  - [x] [**예외**] 3가지의 숫자 중 중복된 숫자가 존재하는 경우
  - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다
    
  - [x] 숫자가 아닌 문자를 입력한 경우 
  - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다

#### 입력한 숫자에 대한 결과를 출력합니다
- 입력한 숫자에 대한 결과를 출력합니다 
  - [x] 컴퓨터의 숫자를 모두 만족할 때 까지 입력과 결과 출력을 반복합니다
    - [x] 사용자로부터 입력을 받습니다 
      - [x] [**예외**] 1-9 사이의 서로 다른 세 가지의 수를 입력하지 않은 경우
      - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다 
        - [x] 같은 숫자, 같은 자리인 경우에는 STRIKE
        - [x] 같은 숫자, 다른 자리인 경우에는 BALL
        - [x] 포함되지 않은 숫자면 NOTHING
      
    - [x] 3스트라이크가 아닌 경우 다시 입력을 받습니다
      - [x] [**예외**] 1-9 사이의 서로 다른 세 가지의 수를 입력하지 않은 경우
      - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다
      - [x] 사용자로부터 입력을 받습니다
      - [x] 결과를 출력합니다
    
    - [x] 3스트라이크인 경우 게임을 종료합니다
      - [x] 게임을 종료하는 문구를 작성합니다
    - [x] 재시작 할 것인지 혹은 종료할 것인지에 대한 입력을 받습니다
      - [x] [**예외**] 1 혹은 2 이외의 문자를 입력한 경우
      - [x] [**예외 처리**] IllegalArgumentException을 throw 하고 어플리케이션을 종료합니다
      - [x] 1을 입력한 경우 게임을 재시작합니다
      - [x] 2를 입력한 경우 게임을 종료합니다 



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
