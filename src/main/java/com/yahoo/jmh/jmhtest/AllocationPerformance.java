package com.yahoo.jmh.jmhtest;


import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.CommandLineOptions;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.ProfilerConfig;

import com.yahoo.jmh.jmhtest.jni.AllocationJNI;
import com.yahoo.jmh.jmhtest.jni.JniLibraryLoader;
import com.yahoo.wildwest.MUnsafe;

@State(Scope.Benchmark)
public class AllocationPerformance {

    @SuppressWarnings("boxing")
    public static void setup(ChainedOptionsBuilder opt, CommandLineOptions cmdOptions) {
        if (cmdOptions.getWarmupMode().hasValue()) {
            opt.warmupMode(cmdOptions.getWarmupMode().get());
        }

        if (cmdOptions.getJvm().hasValue()) {
            opt.jvm(cmdOptions.getJvm().get());
        }

        if (!cmdOptions.getProfilers().isEmpty()) {
            for (ProfilerConfig p : cmdOptions.getProfilers()) {
                opt.addProfiler(p.getKlass(), p.getOpts());
            }
        }

        // if (cmdOptions.getJvmArgs().hasValue()) {
        // opt.jvmArgs(cmdOptions.getJvmArgs().get());
        // }

        if (cmdOptions.getJvmArgsAppend().hasValue()) {
            opt.jvmArgsAppend(cmdOptions.getJvmArgsAppend().get().toArray(new String[] {}));
        }

        if (cmdOptions.getJvmArgsPrepend().hasValue()) {
            opt.jvmArgsPrepend(cmdOptions.getJvmArgsPrepend().get().toArray(new String[] {}));
        }

        if (cmdOptions.getForkCount().hasValue()) {
            // opt.forkCount(cmdOptions.getForkCount().get());
            opt.forks(cmdOptions.getForkCount().get());
        }

        if (cmdOptions.getWarmupForkCount().hasValue()) {
            // opt.warmupForkCount(cmdOptions.getWarmupForkCount().get());
            opt.warmupForks(cmdOptions.getWarmupForkCount().get());
        }

        if (cmdOptions.getOutput().hasValue()) {
            opt.output(cmdOptions.getOutput().get());
        }

        if (cmdOptions.getResultFormat().hasValue()) {
            opt.resultFormat(cmdOptions.getResultFormat().get());
        }

        if (cmdOptions.getResult().hasValue()) {
            opt.result(cmdOptions.getResult().get());
        }

        if (cmdOptions.getMeasurementIterations().hasValue()) {
            opt.measurementIterations(cmdOptions.getMeasurementIterations().get());
        }

        if (cmdOptions.getMeasurementBatchSize().hasValue()) {
            opt.measurementBatchSize(cmdOptions.getMeasurementBatchSize().get());
        }

        if (cmdOptions.getMeasurementTime().hasValue()) {
            opt.measurementTime(cmdOptions.getMeasurementTime().get());
        }

        if (cmdOptions.getWarmupTime().hasValue()) {
            opt.warmupTime(cmdOptions.getWarmupTime().get());
        }

        if (cmdOptions.getWarmupIterations().hasValue()) {
            opt.warmupIterations(cmdOptions.getWarmupIterations().get());
        }

        if (cmdOptions.getWarmupBatchSize().hasValue()) {
            opt.warmupBatchSize(cmdOptions.getWarmupBatchSize().get());
        }

        if (cmdOptions.getThreads().hasValue()) {
            opt.threads(cmdOptions.getThreads().get());
        }

        if (cmdOptions.getThreadGroups().hasValue()) {
            opt.threadGroups(cmdOptions.getThreadGroups().get());
        }

        if (cmdOptions.shouldDoGC().hasValue()) {
            opt.shouldDoGC(cmdOptions.shouldDoGC().get());
        }

        if (cmdOptions.shouldSyncIterations().hasValue()) {
            opt.syncIterations(cmdOptions.shouldSyncIterations().get());
        }

        if (cmdOptions.verbosity().hasValue()) {
            opt.verbosity(cmdOptions.verbosity().get());
        }

        if (cmdOptions.getTimeUnit().hasValue()) {
            opt.timeUnit(cmdOptions.getTimeUnit().get());
        }

        if (cmdOptions.getOperationsPerInvocation().hasValue()) {
            opt.operationsPerInvocation(cmdOptions.getOperationsPerInvocation().get());
        }

        if (cmdOptions.shouldFailOnError().hasValue()) {
            opt.shouldFailOnError(cmdOptions.shouldFailOnError().get());
        }

        if (cmdOptions.getTimeout().hasValue()) {
            opt.timeout(cmdOptions.getTimeout().get());
        }
    }

    public static void main(String[] args) throws Exception {

        CommandLineOptions cmdOptions = new CommandLineOptions(args);

        if (cmdOptions.shouldHelp() || cmdOptions.shouldList() || cmdOptions.shouldListProfilers()
                        || cmdOptions.shouldListResultFormats() || cmdOptions.shouldListWithParams()) {
            Main.main(args);
            return;
        }


        OptionsBuilder opt = new OptionsBuilder();
        // first, set all the command line options
        setup(opt, cmdOptions);

        // set heap size or things explode.
        opt
                        // include this test
                        .include("com.yahoo.jmh.jmhtest.AllocationPerformance")
                        // use the jvm args passed to us.
                        .detectJvmArgs();

        if (!opt.getWarmupForkCount().hasValue()) {
            // 10 warmup forks
            opt.warmupForks(10);
        }

        if (!opt.getForkCount().hasValue()) {
            // 10 forks
            opt.forks(10);
        }

        if (!opt.getWarmupIterations().hasValue()) {
            // 20 warmup iteration
            opt.warmupIterations(20);
        }

        if (opt.getBenchModes().isEmpty()) {
            // we want average time
            opt.mode(Mode.AverageTime);
        }

        if (!opt.getMeasurementIterations().hasValue()) {
            // we want average time
            opt.measurementIterations(200);
        }

        if (!opt.getTimeUnit().hasValue()) {
            // we want average time
            opt.timeUnit(TimeUnit.MICROSECONDS);
        }

        if (!opt.getThreads().hasValue()) {
            // we want average time
            opt.threads(5);
        }
        //
        // .build();

        new Runner(opt.build()).run();
    }

    @Param({"1", "10", "100", "1000"})
    public int arg;

    @Setup
    public void setup() {
        JniLibraryLoader.load();
    }

    @Benchmark
    public void jniAllocateAndFree(Blackhole bh) {
        long address = AllocationJNI.allocate(arg);
        bh.consume(address);
        AllocationJNI.release(address);
    }

    @Benchmark
    public void unsafeAllocateAndFree(Blackhole bh) {
        long address = MUnsafe.allocateMemory(arg);
        bh.consume(address);
        MUnsafe.freeMemory(address);
    }

    @Benchmark
    public int jniCopy(Blackhole bh) {
        // usage: jni allocates, we copy and then release.
        byte[] from = new byte[arg];
        long destAddress = AllocationJNI.allocate(arg);
        MUnsafe.copyMemory(destAddress, from);

        try {
            return AllocationJNI.doSomething(destAddress, arg);
        } finally {
            AllocationJNI.release(destAddress);
        }
    }

    @Benchmark
    public int unsafeCopy(Blackhole bh) {
        // usage: jni allocates, we copy and then release.
        byte[] from = new byte[arg];
        long destAddress = MUnsafe.allocateMemory(arg);
        MUnsafe.copyMemory(destAddress, from);

        try {
            return AllocationJNI.doSomething(destAddress, arg);
        } finally {
            MUnsafe.freeMemory(destAddress);
        }
    }
}
