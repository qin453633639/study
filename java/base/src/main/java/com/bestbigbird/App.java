package com.bestbigbird;

import javax.management.*;
import javax.management.openmbean.CompositeDataSupport;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.Iterator;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IntrospectionException, InstanceNotFoundException, ReflectionException, MalformedObjectNameException, AttributeNotFoundException, MBeanException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        Set MBeanset = server.queryMBeans(null, null);
        Iterator MBeansetIterator = MBeanset.iterator();
        while (MBeansetIterator.hasNext()) {
            ObjectInstance objectInstance = (ObjectInstance) MBeansetIterator
                    .next();
            ObjectName objectName = objectInstance.getObjectName();
            MBeanInfo objectInfo = server.getMBeanInfo(objectName);
            System.out.print("ObjectName:" + objectName.getCanonicalName()
                    + ".");
            System.out.print("mehtodName:");
            for (int i = 0; i < objectInfo.getAttributes().length; i++) {
                System.out.print(objectInfo.getAttributes()[i].getName() + ",");
            }
            System.out.println();
        }

        ObjectName heapObjName = new ObjectName("java.lang:type=Memory");
        //堆内存
        MemoryUsage heapMemoryUsage = MemoryUsage
                .from((CompositeDataSupport) server.getAttribute(heapObjName,
                        "HeapMemoryUsage"));
        long commitMemory = heapMemoryUsage.getCommitted();// 堆当前分配
        long usedMemory = heapMemoryUsage.getUsed();
        System.out.print("堆内存总量:" + heapMemoryUsage.getMax() / 1024 + "KB,当前分配量:" + commitMemory / 1024 + "KB,当前使用率:" + usedMemory / 1024 + "KB,");
        System.out.println("堆内存使用率:" + (int) usedMemory * 100
                / commitMemory + "%");// 堆使用率

        //栈内存
        MemoryUsage nonheapMemoryUsage = MemoryUsage
                .from((CompositeDataSupport) server.getAttribute(heapObjName,
                        "NonHeapMemoryUsage"));
        long noncommitMemory = nonheapMemoryUsage.getCommitted();
        long nonusedMemory = heapMemoryUsage.getUsed();

        System.out.println("栈内存使用率:" + (int) nonusedMemory * 100
                / noncommitMemory + "%");



    }
}
