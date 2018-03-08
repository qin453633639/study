package com.intrumentation;

import com.sun.tools.attach.VirtualMachine;
import org.springframework.context.SmartLifecycle;

/**
 * demo
 */
public class Demo implements SmartLifecycle {
    public static void main(String[] args) throws Exception {
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent("F:/idea/source/agent/target/agent-1.0-SNAPSHOT.jar");
    }

    @Override
    public boolean isAutoStartup() {
        return false;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
