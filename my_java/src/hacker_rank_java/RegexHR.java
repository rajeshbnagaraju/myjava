package hacker_rank_java;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.Scanner;

public class RegexHR{

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String IP = in.next();
            System.out.println(IP.matches(new myRegex().pattern));
        }
        in.close();
    }
}
class myRegex {
	//public static String pattern = "/[[0-9]{1,3}.]{3}[0-9]{1,3}./";
	public String pattern = "[0-9].";
}
