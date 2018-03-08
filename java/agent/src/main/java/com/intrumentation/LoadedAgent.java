package com.intrumentation;

import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Comparator;

public class LoadedAgent {
    public static void agentmain(String args, Instrumentation inst) {
        Class<?>[] classes = inst.getAllLoadedClasses();

        Arrays.sort(classes, new Comparator<Class<?>>() {
            @Override
            public int compare(Class<?> x, Class<?> y) {
                return x.getName().compareTo(y.getName());
            }
        });

        System.out.println("class                path                loader");
        System.out.println("-----------------------------------------------");
        for (Class<?> c : classes) {
            System.out.printf("%s, %s, %s\n",
                    c.getName(),
                    getPathFromClass(c),
                    getClassLoaderStringFrom(c));
        }
    }

    static String getPathFromClass(Class<?> c) {
        ProtectionDomain domain = c.getProtectionDomain();
        if (domain == null) {return null;}

        CodeSource source = domain.getCodeSource();
        if (source == null) {return null;}

        URL location = source.getLocation();
        if (location == null) {return null;}

        return location.getPath();
    }

    private static String getClassLoaderStringFrom(Class<?> c) {
        ClassLoader loader = c.getClassLoader();
        return loader != null
                ? loader.toString()
                : "<bootstrap>";
    }
}
