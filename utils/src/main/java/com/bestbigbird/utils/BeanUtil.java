package com.bestbigbird.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 获取类路径下的class信息
 */
public class BeanUtil {


    public static List<Class> getClasses(String packageName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");

        Enumeration<URL> resources = classLoader.getResources(path);
        List<Class> classes = new ArrayList();
        ArrayList dirs = new ArrayList();

        while(resources.hasMoreElements()) {
            URL urlResource = (URL)resources.nextElement();
            String type = urlResource.getProtocol();

            if (type.equals("file")) {
                dirs.add(new File(urlResource.getFile()));
            } else if (type.equals("jar")) {
                classes.addAll(getClassNameByJar(urlResource.getPath()));
            }
        }

        Iterator var8 = dirs.iterator();

        while(var8.hasNext()) {
            File directory = (File)var8.next();
            classes.addAll(findClasses(directory, packageName));
        }


        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) {
        List<Class> classes = new ArrayList();
        if (!directory.isDirectory()) {
            return classes;
        } else {
            File[] files = directory.listFiles();
            File[] var4 = files;
            int var5 = files.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                File file = var4[var6];
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);

                    try {

                        classes.add(Class.forName(className));

                    } catch (ClassNotFoundException var10) {
                        var10.printStackTrace();
                    } catch (ExceptionInInitializerError var11) {
                        var11.printStackTrace();

                    } catch (Throwable var12) {
                        var12.printStackTrace();

                    }
                }
            }

            return classes;
        }
    }

    public static List<Class> getClassNameByJar(String jarPath) {
        List myClassName = new ArrayList();
        String[] jarInfo = jarPath.split("!");
        String jarFilePath = null;

        try {
            jarFilePath = URLDecoder.decode(jarInfo[0].substring(jarInfo[0].indexOf("/")), "UTF-8");
        } catch (UnsupportedEncodingException var25) {
            var25.printStackTrace();
        }

        String packagePath = jarInfo[1].substring(1);
        JarFile jarFile = null;

        try {
            jarFile = new JarFile(jarFilePath);
            Enumeration entrys = jarFile.entries();

            while(entrys.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry)entrys.nextElement();
                String entryName = jarEntry.getName();
                if (entryName.endsWith(".class") && entryName.startsWith(packagePath)) {
                    entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));

                    try {
                        myClassName.add(Class.forName(entryName));

                    } catch (ClassNotFoundException var22) {
                        var22.printStackTrace();
                    } catch (ExceptionInInitializerError var23) {
                        var23.printStackTrace();

                    } catch (Throwable var24) {
                        var24.printStackTrace();

                    }
                }
            }
        } catch (Exception var26) {
            var26.printStackTrace();
        } finally {
            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (IOException var21) {
                    var21.printStackTrace();
                }
            }

        }

        return myClassName;
    }
}
