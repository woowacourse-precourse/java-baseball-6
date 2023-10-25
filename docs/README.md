상대방(컴퓨터)의 수를 정하는 상수값

### Input
1. 상대방의 수를 예측하는 3자리 상수값
- 서로 다른 3자리의 수여야함 (Validate Check)
- 유효성 실패의 경우 IllegalArgumentException 발생 후 종료
2. 게임이 끝난 경우 재시작/종료를 구분하는 1과 2
- 1, 2 구분하는 기능 (Validate Check)
- 각 분기별로 로직 구성
- System.exit() 사용금지


### Output
1. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
   1볼 1스트라이크
2. 맞는 수가 하나도 없는 경우
   낫싱
   -> 이 경우 힌트 제공이 되어야함.
3. 3개의 숫자를 모두 맞힐 경우
   3스트라이크
   3개의 숫자를 모두 맞히셨습니다! 게임 종료
4. 게임 시작 문구 출력
   숫자 야구 게임을 시작합니다.

****
## 프로그램 구조
### Exception Directory
- 예외처리에 관련된 클래스들
1. userInputValidation
   -> 입력값이 정수인지
   -> 입력값이 1~9 사이의 값인지
   -> 3자리의 수가 서로다른 수인지
2. afterValidation
   -> 입력값이 정수인지
   -> 입력값이 1 또는 2 중 하나의 수인지
3. createNumValidation
   -> 생성된 컴퓨터의 3자리 수가 서로 다른 수인지

### Application Class
-> GameManager Class 객체 생성 및 게임생성

### GameManager Class
-> camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용해서 컴퓨터(상대방)의 수를 생성
-> 생성자를 통해 PlayGame Class 객체 생성 및 게임 시작.
-> 게임이 종료될 경우

### PlayGame Class
1. PlayGame(int Computer)
   -> 생성자를 통해 컴퓨터의 수를 받고 gameStart()를 호출
2. gameStart()
   -> while문을 통해 사용자 입력 및 유효성 체크를 통한 게임 실행 로직
3. isBall(int userInput)
   -> 사용자 입력값 N번째 자리 수를 입력으로 받고, 볼체크를 해주는 메서드
4. isStrike(int userInput)
   -> 사용자 입력값 N번째 자리 수를 입력으로 받고, 스트라이크 체크를 해주는 메서드

***
## Game Logic

1. 게임 생성 시 상대방(컴퓨터)의 수를 생성
2. 유저에게 세 자리의 서로다른 수를 입력받음.
3. 각 자리수 별로 ball인지, Strike인지 개수 체크
4. Ball, Strike의 합이 0일 시 낫싱
5. Strike가 3일 시 정답
6. 그 외는 각 변수의 개수를 출력형식에 맞게 출력
7. Game종료 시 1 또는 2의 수 중 하나를 입력받음.
8. 입력값이 1일 시 1번 ~ 7번 반복
9. 입력값이 2일 시 return으로 게임 종료.