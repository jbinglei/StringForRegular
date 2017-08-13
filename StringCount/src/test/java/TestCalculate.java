import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JBL on 2017/8/13.
 */
public class TestCalculate
{
    @Test
    public void test01_calculateRes()
    {
        Calculate calculate = new Calculate();
        Map<String,Integer> result =  calculate.calculateRes("123abcABC中文");
        Assert.assertEquals(null,result); //预期值与程序输出不一样
    }

    @Test
    public void test02_calculateRes()
    {
        Calculate calculate = new Calculate();
        Map<String,Integer> result =  calculate.calculateRes("123abcABC 中文");
        Map<String,Integer> compare = new HashMap<String, Integer>();
        compare.put("numberNum:",3);
        compare.put("chineseNum:",2);
        compare.put("blankNum:",1);
        compare.put("otherNum:",0);
        compare.put("lowerNum:",3);
        compare.put("upperNum:",3);
        Assert.assertEquals(compare,result); //预期值与程序输出不一样
    }

    @Test
    public void test03_calculateRes()
    {
        Calculate calculate = new Calculate();
        Map<String,Integer> result =  calculate.calculateRes("12345旺季 abcABC %&中文");
        Map<String,Integer> compare = new HashMap<String, Integer>();
        compare.put("numberNum:",5);
        compare.put("chineseNum:",4);
        compare.put("blankNum:",2);
        compare.put("otherNum:",2);
        compare.put("lowerNum:",3);
        compare.put("upperNum:",3);
        Assert.assertEquals(compare,result); //预期值与程序输出不一样
    }
}
