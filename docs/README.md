# 과제1 - 숫자야구

## ❗ 기본 제약

---

- 모든 변수는 private
  - 모든 변수는 SET/GET 으로 접근 가능
- 모든 메소드는 public


## 🛠 기능목록

---

### 💻 컴퓨터 기능 - `Class Computer`
- 변수
  - `List<integer> computerNum`
- 메소드
  - `selectComputerNum()` : 3자리 숫자를 무작위로 선택한다
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용 예시 (from READ.md)
```
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

### 👨‍💻 사용자 기능 `class Player`
- 변수
  - `List<Integer> playerNum`
- 메소드
  - `inputPlayerNum()` : 숫자 입력받기
    - `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.
      - `camp.nextstep.edu.missionutils.Console` : String 으로 반환
    - 예시
```
숫자를 입력해주세요 : 123
```

---

### ⚾ 심판 기능 `Class Umpire`

- 변수
  - `int all`
  - `int strike`
  - `String judgment`
  - `boolean coin;`
- 메소드
  - `void countAll(List<Integer> computerNum, List<Integer> playerNum)`
    - strike + ball 의 갯수
  - `void countStrike(List<Integer> computerNum,List<Integer> playerNum)`
    - strike 갯수 
  - `String Judge()`
    - 판정 결과 반환
  - `void onceAgain()`
    - 게임 재시작 여부 입력
      - 1 : 재시작
      - 2 : 종료
  - `void newGame()`
    - 게임 초기화

---

### 🃏 게임 진행 기능 `Class Application`

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
```


- 결과 출력
  - `umpire.getJudgment()`
  - 예시
```
1볼 1스트라이크
```
- 정답 & 게임 종료
```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```
- 게임 재시작&종료 선택 `umpire.onceAgain()`
```
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```
- 정답 맞출 때까지 반복해서 입력

## 📝 피드백

---

- 10/24
  - 모든 기능을 구현하고 테스트케이스를 통과했으나 `Application.java`에 모든 기능을 구현했기 때문에 'JAVA'를 사용해서 코딩 한 것 같지 않다.
    - 클래스를 만들어서 기능을 나누어볼것
  - 개선해야할 부분
    - 역할에 따라 class로 나누어서 객체지향적으로 구현하기
    - class마다의 기능에 대해서 테스트 케이스도 새로 시도해 보기

---
- 10/25
  - Computer, Player, Umpire 3가지 클래스로 나누고 전체적인 게임 진행을 Application에서 진행했다.
    - 기능을 나누어서 구현하니 훨씬 깔끔하고 객체지향적으로 구현하였다.
  - `CountAll()` 에서 for - for - if 순서가 규칙을 위반해서 `contins()` 를 통해서 해결하였다.
    -작성 규칙이 아직은 헷갈리는게 많아서 최대한 지키려고 했으나 기존 버릇을 고치기 힘들다...!

  - 개선해야할 부분
    - Class안의 기능마다 단위테스트를 해야한다.
      - Class마다 단위테스트를 어떻게 진행하는지 아직 잘 모르는 부분이라 공부해서 다음 과제에서는 기능별 단위 테스트를 해볼것

## 📖 소감

---

너무 재밌었다! 이렇게 제대로 계획 짜고, 작성하고, 계획 수정하고 다시 고쳐나가는게 너무 재밌었다.
README를 이렇게까지 시간을 투자한 적이 없는데 더 다듬고 투자해야겠다.
이쁘게 만드는것도 재밌고 나만의 README 작성 규칙을 정해놓고 틀에 맞춰서 써야겠다.
해야 할 일이 계속 만들어 지는 느낌이었다. 하지만 아직 부족한 점이 있기 떄문에 단위테스트와 더 JAVA 스러운 코드를 만들기 위해서 공부가 계속 필요할것 같다.

