package com.kais.crazy_java.chapter07.summary_7_5;

import lombok.var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kais
 * @date 2022.08.18. 17:39
 */
public class MatchesTest {
    public static void main(String[] args) {
        String[] mails =
                {
                        "kongyeeku@163.com",
                        "kongyeeku@gmail.com",
                        "ligang@crazyit.org",
                        "wawa@abc.xx"
                };
        var mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        var mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (var mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                // reset()：将现有的Matcher对象应用于一个新的字符序列
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址！";
            System.out.println(result);
        }
    }
}
