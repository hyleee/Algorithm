import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str) {
        
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            q.add(str.charAt(i));
        }
        
        int answer = 0;
        for(int i=0; i<str.length(); i++){
            if(isPossible(new LinkedList<>(q))){
                answer++;
            }
            char c = q.poll();
            q.add(c);
        }
        return answer;
    }
    
    static boolean isPossible(Queue<Character> q){
        Stack<Character> stack = new Stack<>();
        while(!q.isEmpty()){
            char c =  q.poll();
            if(c=='{' || c=='[' || c=='('){
                stack.push(c);
            } else if(c=='}'){
                if(stack.isEmpty() || stack.peek()!='{') return false;
                else stack.pop();
            } else if(c==')'){
                if(stack.isEmpty() || stack.peek()!='(') return false;
                else stack.pop();
            } else if(c==']'){
                if(stack.isEmpty() || stack.peek()!='[') return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}