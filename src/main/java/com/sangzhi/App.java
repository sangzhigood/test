package com.sangzhi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, InstantiationException,
                                          IllegalAccessException, ClassNotFoundException, SecurityException,
                                          NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        // 生成文本
        URL url112 = new URL("file:///home/sangzhi/test/resources/xstream-1.1.2.jar");
        URL[] url112s = new URL[] { url112 };
        XClassLoader url1 = new XClassLoader(url112s);
        Class class112 = url1.loadClass("com.thoughtworks.xstream.XStream");
        Method m = class112.getMethod("toXML", Object.class);

        TransferDO transferDO = new TransferDO();
        StringBuilder sb = new StringBuilder();
        sb.append("sang");
        sb.append("dddd");
        transferDO.setSb(sb);
        Object object = m.invoke(class112.newInstance(), transferDO);
        System.out.println(object);
        Method m121s = class112.getMethod("fromXML", String.class);
        Object object121 = m121s.invoke(class112.newInstance(), object.toString());
        URL url141 = new URL("file:///home/sangzhi/test/resources/xstream-1.4.1.jar");
        URL[] url141s = new URL[] { url141 };
        XClassLoader url2 = new XClassLoader(url141s);
        Class class141 = url2.loadClass("com.thoughtworks.xstream.XStream");
        Method m1412 = class141.getMethod("toXML", Object.class);
        String sb141 = (String) m1412.invoke(class141.newInstance(), object121);
        System.out.println(sb141);

    }
}
