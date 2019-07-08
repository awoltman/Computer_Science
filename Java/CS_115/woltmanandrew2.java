import java.util.*;

public class woltmanandrew2
{

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String s = "hello=i am, the king of the world";
        int sum = 0;

        StringTokenizer t = new StringTokenizer(s, "=,;");
        while (t.hasMoreTokens()) {
            sum++;
            System.out.print(t.nextToken());
        }

        System.out.print("\n" + sum);
    }

}