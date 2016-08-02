import java.lang.Math; // header stuff MUST go above the first class

// our main class becomes a file but the main method is still found
public class num
{
  public static void main(String[] args)
  {
    System.out.print(solution1(2233));
  }

  public static int solution1(int x){
    if(x<11 && x>1000000000){//if the input is out of range
      return -1;
    }
    String y = String.valueOf(x);//convert int to string
    int max = 0;
    char compare = y.charAt(0);
    for (int i = 1; i<y.length(); i++){
      char current = y.charAt(i);
      if (compare != current){
        compare=current;
      } else{
        String result = y.substring(0,i)+y.substring(i+1);
        max = Math.max(max, Integer.parseInt(result));
      }

    }
    return max;
  }
}
