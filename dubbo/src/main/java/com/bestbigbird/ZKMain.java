package com.bestbigbird;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

/**
 * Created by qinwei on 2018/9/20.
 */
public class ZKMain {
    private static final String ZK_ADDRESS = "119.23.36.49:2181";
    private static final String ZK_PATH = "/zktest";
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();
        System.out.println("zk client start successfully!");
        String data1 = "hello";

        client.create().
                creatingParentsIfNeeded().
                forPath( "/user/car/bmx", "12w".getBytes());




    }
}
