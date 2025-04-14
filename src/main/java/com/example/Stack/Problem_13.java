package com.example.Stack;

//  문제를 처음 풀 때는 인형을 담는 바구니를 ArrayList를 통해 인형을 모두 담아 연속하는 인형을 인덱스로 참조해 제거하는 방식을 사용하고자 했는데,
//  잘 생각해보니 인형이 1,2,2,1과 같은 순으로 들어갔다면 2번 인형들이 지워지고 그 자리에 1번이 내려와 또 다시 1번 인형들이 지워져야 하는 점을 만족시킬 수 없었다.

import java.util.Stack;

//결국 바구니를 모두 채운 뒤 인형을 제거하는 것이 아니라, 채우면서 제거해야 위와 같은 상황이 발생하지 않는다는 것을 알 수 있었다.
// LIFO 자료구조인 Stack의 peek()메소드를 적절히 이용하면 가능할 것 같았다.
public class Problem_13 {
    public int solution(int[][] board, int[] moves) {
        // 1. 연속된 인형들이 제거된 횟수.
        int answer = 0;
        // 2. 인형을 담을 stack 바구니.
        Stack<Integer> stack = new Stack<>();

        // 3. moves의 크기는 크레인의 총 이동횟수.
        for(int i =0;i<moves.length;i++){
            // 3-1. j 인덱스를 이용해 보드의 행을 탐색. 열은 moves의 원소를 이용해 탐색.
            for(int j=0;j<board.length;j++){
                // 3-2. j행의 moves의 크레인위치 열에 해당하는 값에 인형이 존재한다면.
                if(board[j][moves[i]-1] != 0 ) {
                    // 3-3. stack이 비어있지 않고, 현재 스택의 최상단에 있는 인형과 크레인으로 뽑은 인형이 같다면
                    if(!stack.empty() && stack.peek() == board[j][moves[i]-1]){
                        // 인형들을 제거하는 횟수 증가.
                        answer++;
                        // 바구니에 있는 인형을 제거.
                        stack.pop();
                        // 크레인으로 뽑은 인형을 0으로 만들어 없애준다.
                        board[j][moves[i]-1] = 0;
                        break;
                        // 3-4. 그 외의 경우는 인형을 바구니에 담은 후 0으로 없애준다.
                    }else{
                        stack.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }
            }
        }


        // 4. 없앤 인형의 수 = 인형을 없앤 수 * 2.
        return answer*2;
    }
}
