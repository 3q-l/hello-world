package com.lsp.helloworld.demo.guava.basic;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * @author lishuaipeng
 * @date 2020/12/8 下午3:58
 */
public class StringUtil {

    public static void main(String[] args) {
        String symbol = ",";
        String[] obj = {"Harry", null, "Ron", "Hermione"};
        String[] objUnNull = {"Harry", "Ron", "Hermione"};
        System.out.println("拼接："+joinUnNUll(symbol,obj));
        System.out.println("拼接："+joinNUll(symbol,objUnNull));
        // "Harry", null, "Ron", "Hermione"
        System.out.println("拆分："+split(symbol,joinUnNUll(symbol,obj)));
        String obj1 = "   \\\\p{Cntrl}  12345    abc ABC   ";
        mapping(obj1);
    }
    /** 拼接 **/
    public static String joinUnNUll(String joint, String... obj){
        return Joiner.on(joint).skipNulls().join(obj);
    }
    /** 拼接 **/
    public static String joinNUll(String joint, String... obj){
        return Joiner.on(joint).join(obj);
    }
    /** 拆分 **/
    public static List<String> split(String symbol, String obj){
        return Splitter.on(symbol).splitToList(obj);
    }
    /** 匹配 **/
    public static void mapping(String obj){
        //移除control字符
        String noControl = CharMatcher.javaIsoControl().removeFrom(obj);
        System.out.println("移除control字符:"+noControl);
        //只保留数字字符
        String theDigits = CharMatcher.digit().retainFrom(obj);
        System.out.println("只保留数字字符:"+theDigits);
        //去除两端的空格，并把中间的连续空格替换成单个空格
        String spaced = CharMatcher.whitespace().trimAndCollapseFrom(obj, ' ');
        System.out.println("去除两端的空格，并把中间的连续空格替换成单个空格:"+spaced);
        //用*号替换所有数字
        String noDigits = CharMatcher.javaDigit().replaceFrom(obj, "*");
        System.out.println("用*号替换所有数字:"+noDigits);
        // 只保留数字和小写字母
        String lowerAndDigit = CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom(obj);
        System.out.println("只保留数字和小写字母:"+lowerAndDigit);
    }
}
