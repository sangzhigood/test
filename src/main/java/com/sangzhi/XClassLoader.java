package com.sangzhi;

import java.net.URL;
import java.net.URLClassLoader;

public class XClassLoader extends URLClassLoader {

    public XClassLoader(URL[] urls) {
        super(urls);
    }

    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // First, check if the class has already been loaded
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (ClassNotFoundException e) {
                // ClassNotFoundException thrown if class not found
                // from the non-null parent class loader
            } catch (NoClassDefFoundError e) {
                // ClassNotFoundException thrown if class not found
                // from the non-null parent class loader
            }
            if (c == null) {
                return super.loadClass(name, resolve);
            }
        }
        return c;
    }
}
