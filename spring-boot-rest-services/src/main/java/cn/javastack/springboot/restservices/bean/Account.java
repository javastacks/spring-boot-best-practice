package cn.javastack.springboot.restservices.bean;

/**
 * 微信公众号：Java技术栈
 */
public record Account(Long id, String name, String site, String version) {

    /**
     * 账户默认名称
     */
    public final static String ACCOUNT_DEFAULT_NAME = "公众号：Java技术栈";

    /**
     * 账户默认网站
     */
    public final static String ACCOUNT_DEFAULT_SITE = "https://www.javastack.cn";

}