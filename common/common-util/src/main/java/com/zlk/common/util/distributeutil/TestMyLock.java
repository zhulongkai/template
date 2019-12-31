package com.zlk.common.util.distributeutil;

import com.zlk.common.util.util.SpringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

@Api
@RestController()
public class TestMyLock {

    public Integer a = 20;

    private CountDownLatch countDownLatch;

    @ApiOperation(value = "sss", notes = "dsds")
    @RequestMapping(method = RequestMethod.GET, path = "aaa")
    public String aaa() {
        a = 20;
        countDownLatch = new CountDownLatch(5);
        MyThread myThread1 = SpringUtil.getBean("myThread");
        myThread1.start();
        MyThread myThread2 = SpringUtil.getBean("myThread");
        myThread2.start();
        MyThread myThread3 = SpringUtil.getBean("myThread");
        myThread3.start();
        MyThread myThread4 = SpringUtil.getBean("myThread");
        myThread4.start();
        MyThread myThread5 = SpringUtil.getBean("myThread");
        myThread5.start();
        return null;
    }

    @Component("myThread")
    @Scope("prototype")
    public class MyThread extends Thread {
        @Autowired
        Mylock mylock;
        public int s = 0;

        public void run() {
            countDownLatch.countDown();

            if (countDownLatch.getCount() == 0) {
                System.out.println("-------开始----------");
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (a > 0) {
                try {
                    mylock.lock();
                    if (a > 0) {
                        a--;
                        s++;
                    }
                } finally {
                    mylock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + "+++++++" + s);
        }
    }

    @ApiOperation(value = "eee", notes = "ttt")
    @RequestMapping(method = RequestMethod.GET, path = "bbb")
    public String re() {
        this.a = 20;
        return null;
    }
}
