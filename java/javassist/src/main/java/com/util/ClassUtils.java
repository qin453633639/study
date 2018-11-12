package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinwei on 2018/11/12.
 */
public class ClassUtils {
    public static List<Class<?>> getAllInterfaces(Class<?> clazz){
        if(clazz.isInterface()) {
            return Arrays.asList(new Class[]{clazz});
        } else {
            ArrayList interfaces;
            for(interfaces = new ArrayList(); clazz != null; clazz = clazz.getSuperclass()) {
                for(int i = 0; i < clazz.getInterfaces().length; ++i) {
                    Class ifc = clazz.getInterfaces()[i];
                    if(!interfaces.contains(ifc)) {
                        interfaces.add(ifc);
                    }
                }
            }

            return Arrays.asList(((Class[])interfaces.toArray(new Class[interfaces.size()])));
        }
    }


}
