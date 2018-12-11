package com.lsp.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author lsp
 * @date 2018/12/5/4:24 PM
 */
@Slf4j
@Component("dBconnector")
@Profile("devdb")
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        log.info("DEV");
    }
}
