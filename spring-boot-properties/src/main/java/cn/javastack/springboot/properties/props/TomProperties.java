package cn.javastack.springboot.properties.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 微信公众号：Java技术栈
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "tom")
public class TomProperties {

    private String name;
    private String sex;
    private int age;
    private String country;
    private Date entryTime;

    public TomProperties(String name,
                         String sex,
                         int age,
                         @DefaultValue("China") String country,
                         @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date entryTime) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
        this.entryTime = entryTime;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "TomProperties{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }

}