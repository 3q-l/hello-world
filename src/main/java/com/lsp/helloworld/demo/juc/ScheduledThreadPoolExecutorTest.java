package com.lsp.helloworld.demo.juc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 周期线程池、定时任务
 *
 * @author lishuaipeng
 * @date 2020/9/9 4:22 下午
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(5);
        List<ScheduledFuture> list = new ArrayList<>();
        // 延时五秒执行
        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask(""+i);
            list.add(executor.schedule(task, 30L, TimeUnit.SECONDS));
        }
        for (ScheduledFuture scheduledFuture : list) {
            String future = (String) scheduledFuture.get();
            System.out.println("结果：----->" + future);
        }
        System.in.read();
    }
}

class MyTask implements Callable<String>{

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + "执行开始");
        try {
            Thread.sleep(1000L);
        }catch (Exception e){
            System.err.println(name + "执行异常");
        }
        System.out.println(name + "执行完成");
        return name;
    }
}
