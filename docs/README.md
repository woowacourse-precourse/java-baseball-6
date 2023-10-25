
# 미션 - 숫자 야구
## 🎯 요구 사항
### 프로그래밍 요구 사항
- [x] 프로그램 종료 시 `System.exit()` 호출하지 않는다.
- [x] `ApplicationTest` 모든 테스트 성공해야 한다.
- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


### 진행 요구 사항
- [x] 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.

## ⚙ 구현할 기능
### 📮 패키지 구조
-  📁baseball
    - 📁 controller
      - BaseballGameController.java
    - 📁 domain
      - Computer.java
      - User.java
    - 📁 domain
      - BaseballGameService.java 
    - 📁 service
      - BaseballGameService.java
    - 📁 validation
      - BaseballGameValidation.java
    - 📁 view
      - BaseballGameView.java
    - Application.java

### 🚀 기능 
- [x] 컴퓨터가 1 ~ 9 범위 내 서로 다른 랜덤한 생성
  - [x] 라이브러리에서 제공하는 API를 사용하여 랜덤한 번호 생성
  
- [x] 시작 문자열 출력 (숫자 야구 게임을 시작합니다.)

- [x] 입력을 받을려는 문자열 출력 (숫자를 입력해주세요 : )

- [x] 사용자에게 값을 입력 받는 기능
  - [x] 입력받은 값을 숫자 배열로 변환 후 저장
  - [x] 잘못된 값을 입력하였을 경우 IllegalArgumentException 발생 후 애플리케이션 종료

- [x] 사용자의 입력 값과 컴퓨터의 생성한 값 비교
  - [x] 모든 값이 일치 -> 게임 종료
  - [x] 같은 수가 같은 자리 위치 -> 스트라이크
  - [x] 같은 수가 다른 자리 위치 -> 볼 
  - [x] 같은 수가 전혀 없다 -> 낫싱

- [x] 게임 종료 후 기능
  - [x] 게임 종료 문자열 출력
  - [x] 사용자가 값을 입력 (1 or 2)
    - [x] 1 -> 게임 재시작
    - [x] 2 -> 게임 종료
  - [x] 잘못된 값을 입력하였을 경우 IllegalArgumentException 발생 후 애플리케이션 종료

- [x] 보여주는 출력 화면
  - [x] 시작 화면 출력
  - [x] 입력 화면 출력
  - [x] 재시작하는 화면 출력
  - [x] 볼, 스트라이크 결과 출력

### 🎫테스트 
- [x] 도메인 테스트
  - [x] 유저 테스트
    - [x] 유저 입력 테스트
  - [x] 컴퓨터(상대방) 테스트
    - [x] 서로 다른 3개의 수를 생성하는 지 테스트
- [x] 서비스 테스트
  - [x] 숫자 야구 서비스 테스트
    - [x] 재시작 테스트
    - [x] 값 유효성 검증 테스트
    - [x] 값 비교 테스트
