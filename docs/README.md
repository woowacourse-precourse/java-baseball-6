###Computer 클래스
- List<Integer> computerNumber();
  - computer의 숫자 세개를 랜덤으로 지정해 반환하는 함수입니다.
  - 우아한테크코스 문제 가이드에 있는 코드로 구현하였습니다.
###Player 클래스
- public List<Integer> playerNumber();
  - 플레이어의 숫자를 키보드로 입력받아 반환하는 함수입니다.
  - 키보드로 입력받는 값은 반드시 String 타입입니다.
  - 따라서 Integer 값으로 변환하기 위해 아스키코드 값을 응용하여 하나의 문자마다 '0'을 빼주어 숫자로 저장하였습니다.
###Game 클래스
- public void setGame(List<Integer> player, List<Integer> computer);
  - 플레이어와 computer의 숫자 리스트를 인자로 받아 게임을 세팅합니다.

- public boolean play();
  - 입력받은 숫자 리스트로 볼, 스트라이크 개수를 리턴합니다.
  - 먼저 플레이어의 숫자 리스트를 돌며 hashmap에 저장합니다.
    - key는 해당 숫자 리스트에서 하나의 값이고 value는 수의 자리입니다.
  - computer의 숫자 리스트를 돌며 hashmap에 해당 값이 있는 지 조회합니다.
  - 만약 없으면 아무것도 아니고 값이 있는데 자리 수가 다르면 ball, 자리 수까지 같으면 strike입니다.
  - 해당 조건에 맞는 결과를 리턴합니다.
  - true인 조건은 3strike일 때 뿐입니다.
###ErrorHandler 클래스
- public void checkPlayerNumber(List<Integer> userNumber);
  - 플레이어가 입력한 숫자가 유효한 지 확인합니다.
  - player가 입력받은 문자열이 유효한 숫자라면 문제가 없지만 문자열을 입력받거나 0을 입력받으면 1~9까지의 숫자가 아닌 다른 수자가 들어가게 됩니다.
  - 따라서 먼저 숫자의 리스트의 사이즈가 3인 지와 모든 원소가 1~9까지의 값인 지를 판단해서 유효한 값이 아니라면 에러를 throw합니다.
- public void checkReGame(String reGame);
  - reGame의 숫자가 1이나 2가 아닌 다른 값이 들어오면 에러를 throw합니다.
###Application
- ErrorHandler 클래스에 대한 객체를 생성합니다.
- while문 안에서 Player, Computer 클래스에 대한 객체를 생성합니다.
- 플레이어와 computer의 숫자리스트를 지정합니다.
- 처음에 생성한 ErrorHandler로 플레이어의 값에 대한 유효성 검사를 합니다.
- Game 클래스에 대한 객체를 생성하고 플레이어와 computer의 숫자리스트로 게임을 세팅합니다.
  - while문 안에서 game을 플레이합니다.
  - 만약 반환된 값이 true가 아니라면(3strike가 되지 않았다면) player의 숫자를 다시 입력받고 게임을 다시 세팅합니다.
  - true가 반환될 때까지 이를 반복합니다.
- 게임이 끝나면 1 혹은 2를 입력받아 게임을 다시할 지 이대로 끝낼 지 결정합니다.
- 입력에 대한 유효성을 검사합니다.