## 🚀 구현 기능 목록

#### 숫자야구 규칙
- Computer가 입력한 수와 User가 입력한 수를 비교한다.
- 위치와 수가 일치하면 > "스트라이크"
- 위치는 일치하지 않고 수만 일치하면  > "볼"
- 전부 일치하지 않으면 > "낫싱"
- 3 스트라이크가 나올 때 까지 사용자 입력을 반복.
- 3 스트라이크가 나오면 사용자 입력 여부에 따라 재시작 및 종료한다.

#### 핵심 기능 클래스
- ✅ StartGame.java : 게임시작
- [x] InputContrast.java : 입력데이터 비교
- [x] OutputResult.java : 결과값 출력
- ✅ Counter.java : 스트라이크, 볼 카운팅
- ✅ ExceptionResult.java : 예외처리
- ✅ GameMessage : 게임 메세지

#### Exception
1. 사용자가 3개의 수를 입력할 때
- [x] 숫자가 아닌 문자를 입력한 경우 (Ex : 12a) >> IllegalArgumentException 발생
- [x] 숫자를 3개 초과로 입력한 경우 (Ex : 1234) >> IllegalArgumentException 발생
- [x] 중복이 존재하는 경우 (Ex : 223) >> IllegalArgumentException 발생
- [x] 1 ~ 9에 해당하지 않는 수가 있을 경우 (Ex : 012) >> IllegalArgumentException 발생

2. 재시작/종료 여부를 입력할 때
- [x] 숫자가 아닌 문자를 입력한 경우
- [x] 1 or 2를 제외한 수를 입력한 경우
- [x] 입력을 하지 않은 경우



