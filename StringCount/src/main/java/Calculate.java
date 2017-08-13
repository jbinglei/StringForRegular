import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JBL on 2017/8/13.
 */
public class Calculate
{
    public Map<String,Integer> calculateRes(String str)
    {
        Map<String,Integer> map = new HashMap<String, Integer>();
        boolean res = IsLegal(str);
        if(!res)
        {
            return null;
        }else
        {
            return calculateNum(str);
        }
    }

    private boolean IsLegal(String str)
    {
        //数字
        String IsNumber = ".*\\d+.*";
        boolean isNumber = Pattern.matches(IsNumber, str);
        //空格
        String IsBlank = ".*\\s+.*";
        boolean isBlank = Pattern.matches(IsBlank,str);
        //大写字母
        String IsUpperCharacter = ".*[A-Z]+.*";
        boolean isUpperCharacter = Pattern.matches(IsUpperCharacter,str);
        //小写字母
        String IsLowerCharacter = ".*[a-z]+.*";
        boolean isLowerCharacter = Pattern.matches(IsLowerCharacter,str);
        //汉字
        String IsChinese = ".*[\u4e00-\u9fa5]+.*";
        boolean isChinese = Pattern.matches(IsChinese,str);
        //结果
        boolean res = isNumber & isBlank & isUpperCharacter & isLowerCharacter & isChinese;
        return res;
    }

    private Map<String,Integer> calculateNum(String str)
    {
        Map<String,Integer> map = new HashMap<String, Integer>();
        int blankNum = num(str,"[\\s]");
        map.put("blankNum:",blankNum);
        int numberNum = num(str,"[0-9]");
        map.put("numberNum:",numberNum);
        int upperNum = num(str,"[A-Z]");
        map.put("upperNum:", upperNum);
        int lowerNum = num(str,"[a-z]");
        map.put("lowerNum:", lowerNum);
        int chineseNum = num(str,"[\u4e00-\u9fa5]");
        map.put("chineseNum:",chineseNum);
        int otherNum = str.length()-blankNum-numberNum-upperNum-lowerNum-chineseNum;
        map.put("otherNum:",otherNum);
        return map;
    }

    private int num(String str, String pattern)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        int i = 0;
        while (m.find()) {
            i++;
        }
        return i;
    }
}
