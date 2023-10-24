# 1주차 숫자야구

### 설계

디자인 패턴 중 하나인 MVC 패턴을 채택하여 프로그램을 설계합니다.

- Controller
    - 유저에 대해서 입출력을 View와 Service에게 전달합니다.
    - 입력 값에 대해서 오류를 검증하고 예외를 던집니다.
- Service
    - 게임의 핵심로직에 대한 책임을 가집니다.
    - 볼과 스트라이트의 갯수를 확인하여 Controller에게 전달합니다.
- View
    - 사용자 화면에 게임 화면을 보여주는 책임을 가집니다.

### 구현

**기능 구현을 위해 계획부터!**

- [ ]  1.디자인 패턴 구상하기
- [ ]  2.게임 로직 코드 구현하기 (Service)
- [ ]  3.게임 로직 코드 검증 및 테스트
- [ ]  4.입출력 코드 구현하기 (Controller)
- [ ]  5.뷰 구현하기
- [ ]  6.입출력 코드 검증 및 테스트
- [ ]  7.리팩토링이 필요한 부분 찾아서 고치기

### 핵심 로직

```jsx
def checkBallAndStrike(ans, input):
	ansCharacterCounts = makeHashCount(ans) # 1232의 문자열이 들어가면 문자열이 등장한 횟수만큼 value가 되는 hashmap 생성{1:1, 2:2, 3:1}
  inputCharacterCounts = makeHashCount(input)
	balls = 0
	strikes = 0
	
	# 해시맵으로 중복되는 갯수만큼 볼수를 생성
	for (char key : ansCharacterCounts.keySet()) {
            if (inputCharacterCounts.containsKey(key)) {
                balls += Math.min(ansCharacterCounts.get(key), inputCharacterCounts.get(key));
            }
        }
	# 반복문을 돌면서 input과 ans의 값이 같은경우 ball에서 1을 빼고 strikes에서 1을 더한다
	for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == input.charAt(i)) {
                balls--;
                strikes++;
            }
        }
```