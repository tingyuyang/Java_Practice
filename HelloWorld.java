/* 
dir1                                                                                                                                                                            
 dir12                                                                                                                                                                          
  s1.png3                                                                                                                                                                       
  dir3333                                                                                                                                                                       
len=32
*/
import java.util.*;
import java.io.File;

public class dir {
  static int length = 0;
  static int depth = 0;
  
  public static void main(String[] args) throws Exception {
    File root = new File("."); // current folder
    showAllFiles(root);
    System.out.println("len="+length);
  }

  final static void showAllFiles(File dir) throws Exception {
    File[] fs = dir.listFiles();
    
    depth++;    
    for (int i = 0; i < fs.length; i++) {
      //for indent purpose  
      if (depth > 1) {
        for (int j = 0; j < depth - 1; j++) {
          System.out.print(" ");
        }
      } 
        
      length = length + solution(fs[i].getAbsolutePath());
      System.out.println(fs[i].getName());
      if (fs[i].isDirectory()) {
        try {
          showAllFiles(fs[i]);
        } catch (Exception e) {
        }
      }
    }
    depth--;    
  }

  static public int solution(String S) {
    if (S.isEmpty()) {
      return 0;
    }
    int sumPath = 0;
    int currentLen = 0;
    Stack<String> sta = new Stack<String>();
    String[] lines = S.split("\n");
    int len = lines.length; //# of directories and files
    for (int i = 0; i < len; i++) {
      while (!sta.isEmpty() &&
             (numOfSpace(lines[i]) <= numOfSpace(sta.peek()))) {
        currentLen -= (sta.peek().length() - numOfSpace(sta.peek()) + 1);
        sta.pop();
      }
      currentLen += (lines[i].length() - numOfSpace(lines[i]) + 1);
      sta.push(lines[i]);
      if (isImage(lines[i])) {
        System.out.println("debug:path="+S);
        sumPath = S.length();
      }
    }
    return sumPath;
  }

  static public int numOfSpace(String str) {
    int num = 0;
    int len = str.length();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == ' ') {
        num += 1;
      }
    }
    return num;
  }

  static boolean isImage(String str) {
    if (str.endsWith(".jpeg") || str.endsWith(".png") || str.endsWith(".gif")) {
      return true;
    } else {
      return false;
    }
  }
}

