# 구현할 기능 목록

### 1. BaseballGameManager: 게임 진행 정책에 대한 정보를 가지고 BaseballGame을 생성하여 게임을 진행하는 클래스.

    [객체 변수]
    private final int computerNumberCount: 
        게임에서 사용할 숫자의 자리수를 설정. ex) 3이면 3자리

    [메소드]
    1. public void startGame(): 
        BaseballGame 객체를 생성하고 전체 게임을 시작하고 진행한다.

    2. private boolean startOneGame(BaseballGame baseballGame): 
        한 게임을 시작한다.
        숫자를 입력받고 결과를 출력한다. 
        한 게임이 끝났을 때 다음 게임의 시작 여부를 boolean 플래그로 반환한다.

    3. private boolean hasNextGame(String nextGameInputString): 
        한 게임이 종료된 후 다음 게임의 시작여부를 결정하는 입력을 인자로 받아 해당하는 boolean으로 리턴.

### 2. BaseballGame: 게임 클래스, 게임을 진행하면서 사용할 컴퓨터의 숫자를 생성자의 인자로 받는다.

    [객체 변수]
    private final int computerNumber:
        해당 게임의 컴퓨터의 숫자 즉 사용자가 맞춰야 할 정답.        

    [메소드]
    1. public BaseballGameResult play(int inputNumber): 
        사용자가 입력한 숫자와 컴퓨터의 숫자를 비교하여 결과를 BaseballGameResult 객체로 리턴하는 메소드.
        입력이 정답인 경우 getBaseBallGameResult()을 거치지 않고 바로 결과를 반환한다.
    
    2. private BaseballGameResult getBaseBallGameResult(int inputNumber):
        사용자의 입력이 정답이 아닌 경우에 그에 맞는 BaseballGameResult 객체를 생성해 반환한다.

    3. private boolean isBall(int[] computerNumberArray, int[] inputNumberArray, int i):
        사용자가 입력한 숫자 중 한 자리에 대해 볼인지 검사한다.

    4. private boolean isStrike(int[] computerNumberArray, int[] inputNumberArray, int i):
        사용자가 입력한 숫자 중 한 자리에 대해 스트라이크인지 검사한다.

### 3. BaseballGameResult: 게임의 결과를 나타내는 클래스.

    [객체 변수]
    private final int strike
    private final int ball

    [메소드]
    1. public boolean isWin(int computerNumberCount):
        해당 게임이 이겼는지 검사한다.
    
    2. @Override public String toString():
        해당 게임의 결과를 스트링으로 반환환다.
        ex) strike가 1, ball이 1인 경우 "1볼 1스트라이크"를 반환한다.

### 4. Util: 유틸리티 클래스.

    [스태틱 메소드]
    1. public static int[] split(int number):
        숫자를 각 자리수로 분리하고 배열로 만들어 반환한다.
    
    2. public static List<Integer> removeByIndex(int[] intArray, int index):
        배열에서 해당하는 인덱스의 값을 삭제하고 리스트의 형태로 반환한다.

    3. public static int getNonOverlappingNumber(int numberCount):
        서로 겹치지 않는 최대 9자리 숫자를 만들어 반환한다.

    4. public static int pickNumberInRangeWithoutList(List<Integer> withoutList):
        리스트에 존재하지 않는 1~9 사이의 숫자 하나를 뽑아 반환한다.

    5. public static int getJoinNumber(List<Integer> numberList):
        리스트의 각 숫자들을 합쳐 하나의 숫자로 반환한다.
        ex) [1, 2, 3] -> 123
    
    6. public static boolean validateInputNumber(String inputString, int numberCount):
        사용자의 입력이 게임에 대한 입력으로 알맞은지 검증하는 메소드.
        검증에 성공하면 true를 실패하면 false를 반환한다.
