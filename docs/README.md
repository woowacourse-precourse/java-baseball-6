## 숫자야구게임 - 구현 기능 목록

### ✔ UserNumbers 클래스
- 책임: 유저가 입력한 숫자를 관리
- 역할: 유저가 입력한 숫자를 검증(3개 이상의 수, 중복된 수 x) 후 저장
- 속성: int SIZE, ArrayList<Integer> userNumber
- 기능: <br>
  private void sizeValid(ArrayList<Integer> userNumber) <br>
  private void duplicateValid(ArrayList<Integer> userNumber)

### ✔ Computer 클래스
- 책임: 컴퓨터의 숫자를 관리
- 역할: 컴퓨터의 숫자를 랜덤으로 생성 후 저장
- 속성: ArrayList<Integer> computerNumber


### ✔ NumberCompare 클래스
- 책임: 유저의 숫자와 컴퓨터의 숫자를 비교
- 역할: 유저의 숫자와 컴퓨터의 숫자를 비교하여 볼,스트라이크,낫싱 중 해당하는 결과를 반환
- 속성: int SIZE, Computer computer, String result
- 기능: <br>
  public int getStrikes(UserNumbers userNumbers) <br>
  public int getBalls(UserNumbers userNumbers) <br>
  public String getResult(UserNumbers inputUserNumber)

### ✔ Game 클래스
- 책임: 숫자야구게임을 실행
- 역할: 게임을 진행하며 값을 입력받고 결과를 출력하는 역할
- 기능: <br>
  public UserNumbers getUserInput() <br>
  public void play() <br>
  private static boolean rePlay()
