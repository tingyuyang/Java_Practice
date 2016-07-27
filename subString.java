//subString: http://www.tutorialspoint.com/java/java_string_substring.htm
public class HelloWorld{

     public static void main(String []args){
        int X = 1234;
        String s = String.valueOf(X);
        System.out.println(s.substring(0,2));// will print out 12 here
        String a = new String("One Two");
        System.out.println(a.substring(2,4));//print out: e  here
     }

}

// how to compile in "http://www.tutorialspoint.com/compile_java_online.php"
// Compile then Excute.
// number: 1234
// indent: 0123
// Output is 12, "s.substring(0,2)" so it will be before indent 2

//For the "One Two"
//coz: One_Two
//i:   0123456
//"a.substring(2,4)" so will print out s[2]to s[4-1]. s[3]is '_', so none
