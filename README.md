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

## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

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

## ✅ 기능 구현 목록

### 게임 준비

- [x] 컴퓨터의 숫자를 랜덤하게 정한다.

### 게임 진행

- [x] 플레이어의 숫자를 입력받는다.
    - [x] 숫자를 입력받는다.
    - [x] 문자열 타입의 숫자를 리스트로 변환한다.
    - [x] 입력값을 검증한다.
        - [x] 입력된 문자열이 비어있지 않은지 검증한다.
        - [x] 입력된 문자열의 길이가 3인지 검증한다.
        - [x] 입력된 문자열이 정수인지 검증한다.
        - [x] 입력된 문자열이 양의 정수인지 검증한다.
        - [x] 입력된 정수들의 범위가 1부터 9인지 검증한다.
        - [x] 입력된 정수들이 서로 다른 수인지 검증한다.
    - [x] 입력값이 부적절한 경우, 예외를 반환한다.


- [x] 플레이어가 입력한 숫자와 컴퓨터의 숫자를 비교한다.
    - [x] 플레이어가 입력한 각 숫자가 컴퓨터의 숫자에 있는지 확인한다.
        - [x] 플레이어가 입력한 숫자와 위치를 비교한다.
        - [x] 숫자 비교에 따라 힌트를 결정한다.


- [x] 결정된 힌트를 출력한다.
- [x] 플레이어가 숫자를 맞추지 못한 경우, 다시 `게임 준비`로 돌아가 숫자를 입력받는다.
- [x] 플레이어가 3개의 숫자를 모두 맞췄다면 게임을 다시 시작할 지, 종료할 지 결정한다.
    - [x] "1"을 누르면 게임을 다시 시작, "2"를 누르면 게임을 종료한다.

---

## 🛠️ 리팩토링 목록

### 실행 로직 간소화 및 성능 향상

- [ ] 숫자 비교에 따른 힌트 설정 로직을 간소화하고 성능을 향상시킨다.
- [ ] for문을 stream 메소드를 사용하여 간소화한다.

### 일부 변수들의 상수 변환

- [ ] Hint 클래스 관련 힌트 목록을 Enum으로 분리한다.
- [ ] 입력값 검증 시 발생하는 예외의 목록을 Enum으로 분리한다.
- [ ] View 계층에서 출력하는 메시지의 목록을 Enum으로 분리한다.

### getter 및 setter 제거

- [ ] Player 클래스의 getter 및 setter를 제거하고 비즈니스 로직을 도메인 내에 구현한다.

### 기타

- [ ] ViewService의 기능을 InputView와 OutputView로 각각 분리한다.

---

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
List<Integer> computer=new ArrayList<>();
        while(computer.size()< 3){
        int randomNumber=Randoms.pickNumberInRange(1,9);
        if(!computer.contains(randomNumber)){
        computer.add(randomNumber);
        }
        }
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
