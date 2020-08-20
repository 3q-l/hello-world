package com.lsp.helloworld.framework.rpc.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

/**
 * @author lishuaipeng
 * @date 2020/8/10/5:19 下午
 */
public class IpUtils {

    private static String ip = null;
    private static InetAddress ia = null;
    static {
        try {
            ia = getLocalHost();
            ip = ia.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static String getIp(){
        return ip;
    }


    public static void main(String[] args) {
        System.out.println(getIp());
    }
}
