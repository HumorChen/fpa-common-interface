package cn.freeprogramming.util;

import lombok.Getter;

/**
 * 常用正则匹配类
 * @Author humorchen
 * @Date 2021/12/7
 */
public interface CommonPatterns {
    String REGEX_USERNAME = "^.{1,12}$";
    String DESC_USERNAME = "用户名为1-12位字符串";

    String REGEX_PASSWORD = "^[0-9A-Za-z]{8,20}$";
    String DESC_PASSWORD = "密码为8-20位数字、字母";
}
