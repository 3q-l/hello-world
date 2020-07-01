package com.lsp.helloworld.jmh;

import com.lsp.helloworld.demo.jmh.PS;
import org.openjdk.jmh.annotations.*;

/**
 * Created by lisp on 2020/5/27/下午4:12.
 */
public class PSTest {
    @Benchmark
    @Warmup(iterations = 1,time = 5)
    @Timeout(time = 5)
    @Threads(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1,time = 5)
    public void testForEach(){
        PS.foreach();
    }

    @Benchmark
    @Warmup(iterations = 1,time = 5)
    @Timeout(time = 5)
    @Threads(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1,time = 5)
    public void testParallel(){
        PS.parallel();
    }
}
