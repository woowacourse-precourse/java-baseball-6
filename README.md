# 숫자 야구 게임 프로젝트 (박성찬)

## Application Class (Application.java)

- `main` 메소드
    - 게임 시작 메시지 출력
    - GameMaster 객체 생성
    - GM 게임 진행 (playGame 호출)
    - 정답일 경우 playGame 탈출
    - 입력값에 따라 게임 재시작 또는 종료 결정(resetOrExit 호출)

- `resetOrExit` 메소드
    - 1(재시작) 혹은 2(게임종료)를 입력받음
    - 다른 값일 경우 예외종료

## GameMaster Class (GameMaster.java)

- `playGame` 메소드
    - Computer 객체 생성
    - 랜덤생성된 List 호출 (getAnswer 호출)
    - 입력받은 뒤 정답 비교 (matchNums 호출)
    - 결과 출력 및 정답 여부 반환 (printResult 호출)

- `matchNums` 메소드
    - 사용자 입력값과 정답 비교
    - for문 돌면서 현재 값이 서로 일치하면 스트라이크++
    - 입력값이 존재만 한다면 볼++
    - 출력메소드에 스트라이크,볼 값을 넣고 리턴

- `printResult` 메소드
    - 스트라이크, 볼 값이 0 보다 크면 문자열에 추가
    - 중간 공백을 삭제 후 결과 문자열 반환
    - 스트라이크 == 3 > true 반환하여 matchNums 탈출

## Computer Class (Computer.java)

- `generateRandomNums` 메소드
    - 1에서 9까지 중복되지 않는 3개의 숫자를 생성하여 answerList에 추가

- `getAnswer` 메소드
    - answer 리스트의 복사본 반환

## Player Class (Player.java)

- `getNums` 메소드
    - nums 리스트의 복사본 반환

- `Player` 생성자
    - 사용자로부터 입력을 받음
    - 입력값 형식 검사 (validateInput 호출)
    - 입력값을 ArrayList로 변환하여 nums에 저장 (strToArrayList 호출)
    - 중복된 숫자 여부 확인 (isDuplicate 호출)

- `validateInput` 메소드
    - 정규표현식을 사용해 입력값이 "[1-9]{3}" 인지 확인
    - 일치하지않다면 예외종료

- `strToArrrayList` 메소드
    - 입력받은 문자열을 Integer형 ArrayList로 변환

- `isDuplicate` 메소드
    - 중복된 숫자 확인 (set 사이즈와 원본 사이즈 비교)
    - 중복일 경우 예외종료