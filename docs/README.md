# 1주차 기능 구현 목록

</br>

## 🖥️기능 목록

### 1. 야구 게임 시작: `void` `playBaseballGame()`

야구 게임을 실행하는 메소드  `runGame()`를 호출한다.

### 2. **게임 실행 기능: `void` `runGame()`**

핵심 비즈니스 로직을 컨트롤 하는 역할로 야구 게임 실행에 필요한 요구사항을 토대로 Model와 View가 상호작용하는 공간

### 3. 사용자에게 메세지 보여주기: `void` `print(String message)`

사용자에게 야구게임의 메세지를 표출하는 메소드

### 4. 게임 메세지 고르기: `void` `getGameMessage(MessageType messageType)`

게임의 여러 메세지 중 `messageType`에 따라 다른 메세지가 반환된다.

### 5. 컴퓨터 1~9 중 **서로 다른 임의의 수 3개** 선택: `String` `createRandomNumber()`

게임을 시작했을 때 컴퓨터는 게임의 목표인 서로 다른 랜덤 수 3자리를 반환한다.

- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` API 사용한다.
- 선택한 수는 중복되지 않는다.

### 6. 회원의 입력 값 저장하기: `void` `setUserNumber()`

회원의 입력을 받아온 후 값을 초기화한다.

### 7. 사용자 입력 수 **유효성 검사: `boolean` `isUserNumber(String number)`**

사용자가 입력한 값이 적절한지 아래의 조건에 따라 유효성 검사를 한다.

- 공백제거, 숫자인지 판단, 3자리수 판단
- 잘못된 값 입력 시 `IllegalArgumentException`예외 발생

### 8. **볼, 스트라이크, 낫싱 판단**하기: `List<String>` `createBaseballScoreList(String computerNumber, String userNumber)`

사용자 입력 수를 하나씩 컴퓨터 수와 비교해서 볼,스트라이크,낫싱을 판단한 후 점수 목록을 반환한다.

- 경우의 수: 3스트라이크, 2볼 1스트라이크, 3볼, 2볼, 1볼, 낫싱
- 사용자의 입력 수를 하나씩 비교해서 컴퓨터 수에 ****포함되어 있다면 **볼**
    - 포함되어 있고, 컴퓨터수와 자릿수도 같다면 **스트라이크**

### 9. **볼, 스트라이크, 낫싱 갯수 계산**하기: `String` `printBaseBallCalculation(List<String> baseballScoreList)`

**볼, 스트라이크, 낫싱 판단하기**에서 반환한 점수 목록을 사용자가 보기 편한 문구로 가공한다.

- [”스트라이크”,”스트라이크”,”스트라이크”] → “3스트라이크”
- [”볼”,”스트라이크”,”볼”] → “2볼 1스트라이크”
- [”볼”,”볼”,”볼”] →”3볼”
- [] → “낫싱”
- 순서는 볼 > 스트라이크 또는 단독으로 낫싱

</br>

## 👾아키텍처 설계

### 목표

- MVC 패턴을 사용하자
    - 모델과 뷰 사이에 강력한 결합을 피하고 모델과 뷰의 역할을 분리하는 것
- 단일 책임 원칙을 지키자
- 개방 폐쇄 원칙을 지키자

### Main

Controller를 초기화한 후 `playBaseballGame()`를 호출한다.

### Model

기능 구현 리스트를 정리 한 후 Model의 역할에 맞는 기능을 배치한다.

```java
public Class User{
	사용자가 입력한 값을 저장하는 맴버변수
	setUserNumber
}
```

```java
public Class Computer{
	컴퓨터의 랜덤 수를 저장하는 맴버변수
	createRandomNumber
}
```

```java
public Class Game{
	isUserNumber
	createBaseballScoreList
}
```

### View

사용자에게 게임 메세지를 보여주는 역할로 model에서 처리된 데이터를 표시한다.

`getGameMessage`

`printBaseBallCalculation`

`print`

### Controller

`playBaseballGame`호출을 통해 야구 게임을 시작하는 곳으로 복잡한 비즈니스 로직은 Service 클래스에 책임을 위임하고, 서비스가 필요한 정보(Model,View)만 전달하는 역할을 한다.

### Service

Controller와 Model, View 사이의 중간 계층 역할로 핵심 비즈니스 로직을 처리한다.

사용자가 입력한 값을 model에게 전달하여 model이 적절한 행동(랜덤숫자 반환, 점수 판단하기 등)을 취하도록 하고, View에게 사용자가 원하는 화면(야구게임 시작, 종료 등)을 볼 수 있도록 명령한다. 

**목적**

- Model에서 데이터를 다루는 주요 비즈니스 로직을 모두 Controller에서 처리할 경우 복잡해질 수 있기 때문에 중간 다리를 할 수 있는 Service 계층을 추가 하였다.

**장점**

- 핵심 로직을 서비스 클래스에 위임함으로써 컨트롤러와 모델을 더 간결하게 유지할 수 있다.
- 비즈니스 로직에 대한 테스트가 용이하다
