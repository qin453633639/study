package com.intrumentation;

import java.lang.instrument.Instrumentation;

public class MyAgent {

    public static void premain(String agentArgs,Instrumentation inst){

        //加入ClassFileTransfomer
        inst.addTransformer(new MyClassFileTransformer());

    }


}
