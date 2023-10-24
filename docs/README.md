## 기능

### 난수 생성
 - 1~9 숫자
 - 3자리 자연수
 - 중복 안됨

### 입력
 - **[예외처리]** IllegalArgumentException을 발생시켜야 하는 경우 (System.exit()을 사용하지 말것)
   - 3자리 이상 자연수 입력
   - 문자 입력
   - 중복 입력
   - 음수 입력

### 출력
 - 숫자를 맞추면 "3스트라이크 / 3개의 숫자를 모두 맞히셨습니다! 게임 종료" 라는 문구와 함께 종료
 - 각 hint인 스트라이크, 볼, 낫싱을 출력
 - 3 스트라이크 출력 후 재시작 문구 출력

### 재시작
 - 게임이 끝난 후 게임을 새로 시작하려면 1, 종료하려면 2 입력


## 설계 방법
 - MVC 모델을 이용한 설계
   - Contorller
     - BaseballController
   - Model
     - Computer
     - Restart
     - User
   - view
     - Input
     - Output
   - 추후 추가 예정