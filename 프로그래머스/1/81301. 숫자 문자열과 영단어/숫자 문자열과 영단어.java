class Solution {
    public int solution(String s) {
        
    	//영단어를 담는 배열 
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        //반복문을 사용해 배열 안의 모든 영단어를 검사
        for(int i=0;i<arr.length;i++) {
        	if(s.contains(arr[i])) {
        		s = s.replace(arr[i], Integer.toString(i));
        	}
        }
        return Integer.parseInt(s);
    }
}