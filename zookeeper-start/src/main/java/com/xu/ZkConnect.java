package com.xu;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author xuhongda on 2018/11/20
 * com.xu
 * zookeeper-coding
 */
public class ZkConnect implements Watcher {
    private final static String ZK_PATH = "192.168.1.18:2181";

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(ZK_PATH,5000,new ZkConnect());
        ZooKeeper.States state = zooKeeper.getState();
        System.out.println(state);
        Thread.sleep(100L);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watcher 事件"+watchedEvent);
    }
}
