우아한 테크 코스 1주차 - 숫자 야구 게임 구현

Array 클래스
- checkArrayContains 메서드 : 입력 숫자와 랜덤으로 설정된 숫자(답) 비교
- getArrayFromStr 메서드 : char 배열에 str을 하나씩 저장
- getIndexFromValue 메서드 : 입력 숫자와 랜덤 숫자가 일치하는 인덱스 번호 반환

Game 클래스
- Game() : 입력 받은 값을 num 배열에 저장
- getRandomNum : picNumberInRange 메서드를 사용하여 1부터 9까지의 난수 생성
- init : 게임을 시작하기 위한 세팅
- getAnswer : 사용자로부터 숫자를 입력받음
- checkNewGameStart : 정답을 맞춘 후, 게임을 다시 시작할지 종료할지 확인
- getNewGameAnswer : 입력받은 문자열이 정수로 바꿀 수 있는지 확인
- checkException : 조건에 대한 예외처리
- checkInput : 입력 문자열을 char 문자열로 바꾼 결과에 대한 boolean 반환
- equalInput : 입력 문자열과 랜덤 숫자가 같은지에 대한 참, 거짓을 저장하는 배열 생성 및 참, 거짓 반환

Hint 클래스
- ballCount : 볼의 갯수 증가
- strikeCount : 스크라이크 갯수 증가
- comapreAns : 입력 숫자가 랜덤 숫자에 포함되어 있는지, 같은 위치인지 확인하여 볼, 스크라이크 증가
- printResult : 결과 출력