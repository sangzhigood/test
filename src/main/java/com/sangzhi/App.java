package com.sangzhi;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.thoughtworks.xstream.XStream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, InstantiationException,
                                          IllegalAccessException, ClassNotFoundException {
        URL url112 = new URL("file:///home/sangzhi/test/resources/xstream-1.1.2.jar");
        URL[] url112s = new URL[] { url112 };
        URLClassLoader url1 = new URLClassLoader(url112s);
        XStream xStream = (XStream) url1.loadClass("com.thoughtworks.xstream.XStream").newInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("sang");
        sb.append("dddd");
        System.out.println(xStream.toXML(sb));
        URL url141 = new URL("file:///home/sangzhi/test/resources/xstream-1.4.1.jar");
        URL[] url141s = new URL[] { url141 };
        URLClassLoader url2 = new URLClassLoader(url141s);
        XStream xStream141 = (XStream) url2.loadClass("com.thoughtworks.xstream.XStream").newInstance();
        StringBuilder sb1 = new StringBuilder();
        sb1.append("sang");
        sb1.append("dddd");
        System.out.println(xStream141.toXML(sb1));
        StringBuilder sb141 = (StringBuilder) xStream141.fromXML(xStream.toXML(sb));
        System.out.println(sb141.toString());

    }
}
