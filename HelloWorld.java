import java.util.*;
public class HelloWorld{

    public static void main(String []args){
        System.out.println("Hello World");
     }

	public int solution(String S){
		if(S.isEmpty()){
			return 0;
		}
		int sumPath = 0;
		int currentLen = 0;
		Stack<String> sta = new Stack<String>();
		String[] lines = S.split("\n");
		int len = lines.length;//# of directories and files
		for(int i=0;i<len;i++){
			while(!sta.isEmpty() && (numOfSpace(lines[i]) <=
				numOfSpace(sta.peek()))){
				currentLen -= (sta.peek().length()-numOfSpace(sta.peek())+1);
				sta.pop();
			}
			currentLen +=(lines[i].length()-numOfSpace(lines[i])+1);
			sta.push(lines[i]);
			if(isImage(lines[i])){
				sumPath += currentLen;
			}
		}
		return sumPath;
	}

	public int numOfSpace(String str){
		int num =0;
		int len = str.length();
		for(int i =0; i<len;i++){
			if(str.charAt(i)==' '){
				num+=1;
			}
		}
		return num;
	}

	boolean isImage(String str){
		if(str.endsWith(".jpeg")|| str.endsWith(".png")||str.endsWith(".gif")){
			return true;
		}
		else{
			return false;
		}
	}


}
