# 🔎 게임 순서도
1. 랜덤 번호 선택
2. 번호 입력 받기
3. 스트라이크/볼/낫싱 여부 판단
4. 사용자에게 판단 결과 출력
5. 3스트라이크일시 게임 재시작/종료 여부 입력받기
6. 게임 재시작 or 종료

# 🔎 구현 클래스
## 💻 `Computer` 클래스
### 필드
- `target`: 사용자가 맞춰야할 숫자 3개를 저장하고 있는 리스트
- `solved`: 사용자가 숫자를 맞췄는지 못맞췄는지 확인하기 위한 bool값

### 메소드
- `public Computer(List<Integer> target)`
  - target을 입력받기 위한 생성자
  - solved는 false로 초기화
- `getTarget(), getSolved()`
  - target, solved 값을 가져오기 위한 getter
- `public void makeSolved()`
  - 3스트라이크일 경우, solved값을 true로 바꿔주기 위한 메소드
- `private List<Integer> guessNumbers(List<Integer> guess)`
  - 입력받는 리스트와 컴퓨터의 리스트를 비교해서 스트라이크/볼/낫싱 판단
  - [스트라이크 개수, 볼 개수] 형태로 리턴
- `public String getGuessResult(List<Integer> guess)`
  - 스트라이크, 볼 개수 확인 후, String 형태로 결과 리턴
- `public void changeTarget(List<Integer> target)`
  - 만약 게임 재시작시, target 리스트 변경 코드


# 🔎 구현할 기능 목록

## 📋 랜덤 번호 선택
### 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
- ~~Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.~~
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`함수를 활용한다.


## 📋 번호 입력 받기
### 사용자는 1~9 중 서로 다른 수 3개를 제시한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 사용자가 입력을 받는 경우는 크게 2가지 경우의 수가 있다.
  - 숫자 3가지를 제시하는 경우
  - 게임 종료 후, 게임 재시작 or 종료를 위해 1, 2를 입력받는 경우
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 📋 스트라이크/볼/낫싱 여부 판단 결과 출력
- 스트라이크: 같은 수가 같은 자리에 있는 경우
- 볼: 같은 수가 다른 자리에 있는 경우
- 낫싱: 같은 수가 전혀 없는 경우
- `Computer` 클래스의 `getGuessResult` 메소드 사용

## 📋 게임 재시작 or 종료
- 입력받은 3자리 수가 정답인 경우, 게임을 재시작할지 종료할지 여부를 결정하는 수를 입력받는다.
- 1: 재시작 / 2: 종료
```
...
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```
