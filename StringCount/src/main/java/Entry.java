import java.util.Map;
import java.util.Scanner;

/**
 * Created by JBL on 2017/8/13.
 */
public class Entry
{
    public static void main(String[] args) {
        System.out.print("please input a string :");
        Map<String,Integer> map = null;
        try{
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            Calculate calculate = new Calculate();
            map = calculate.calculateRes(str);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        if(map == null)
        {
            System.out.println("input inlegal !");
        }else
        {
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + entry.getValue());
            }
        }

    }
}
