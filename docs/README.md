# readme.md

## 목차

- 프로젝트 진행 상황
- 게임 방법
- 테스트
- 기타 정보

## **숫자야구 프로젝트 진행 상황**

### **기본 구현**
- 프로그램 실행과정 구상
  - 숫자생성 => 사용자 입력 => 판별 => 재시작혹은종료 / 에러처리
  - 위 5단계로 차례로 구현

- 기능 구현
  - 사용자 입력 (InputNumber) 
    - [x] 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
        - [x] 1부터 9까지 서로 다른수를 입력하는 기능 - Application.makeUserNumber()
  - 판별 (ConfirmNumber)
    - [ ] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를
      맞추면 승리한다.
        - [ ] 몇개가 일치하는지 확인 (갯수)
        - [ ] 자리 일치 확인
          - [ ] 같은 수가 같은 자리에 있으면 스트라이크
          - [ ] 다른 자리에 있으면 볼
          - [ ] 같은 수가 전혀 없으면 낫싱
  - 숫자 생성 (makeNumber)
    - [x] 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로
      다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
        - [x] 1~9까지 서로다른 임의의수 3개 생성 - RandomNumberMaker()
    
  - 판별
    - [ ]  이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
        - [ ] 같은 과정 반복
        - [ ] 숫자를 모두 맞히면 종료기능
  - 재시작/종료 (exit)
    - [ ] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
        - [ ] 게임 완전히 종료
        - [ ] 게임 재시작
  - 에러처리 (Error)
    - [ ] 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
        - [ ] 잘못된 입력시 `IllegalArgumentException` 예외 발생후 종료기능

### **추가 기능 (향후 구현 예정)**

- [ ] 

### **테스트**
- [x] RandomNumberMaker.maker() 단위테스트

### **문서화 및 배포**

- [ ] README.md 작성

- [ ] changelog.md 작성

- [ ] todo.md 작성

## 게임 방법

## 테스트

## 기타 정보

- JDK 17

- 프로그램 실행의 시작점은`Application`의`main()`이다.

- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)준수

- 프로그램 종료 시`System.exit()`를 호출하지 않음.

- `camp.nextstep.edu.missionutils`에서 제공하는`Randoms`및`Console`API를 사용하여 구현.
    - Random 값 추출은`camp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()`를 활용.
    - 사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용.