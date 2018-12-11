package com.lsp.helloworld.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lsp
 * @date 2018/12/5/9:31 AM
 */
@Data
// 创建对象
@Component("user")
// 读取配置文件
@PropertySource("classpath:test.properties")
// 把哪些属性给赋值到该类上
@ConfigurationProperties(prefix = "com.lsp")
public class UserDTO {
//    @Value("${com.lsp.name}")
    private String name;
//    @Value("${com.lsp.value}")
    private String value;

    private Integer number;
}
