package com.company.Task1;

import java.lang.reflect.*;

public class Task1 {
    String result = "";

    public static String getInfo(String className) throws ClassNotFoundException, NoSuchFieldException {
        String result = "";
        Class c = Class.forName(className);
        if (!c.isPrimitive() && !c.isInterface()) {
            result += c.getPackage() + "\n";
            int modifiers = c.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                result += "public ";
            }
            if (Modifier.isPrivate(modifiers)) {
                result += "private ";
            }
            if (Modifier.isProtected(modifiers)) {
                result += "protected ";
            }
            if (Modifier.isNative(modifiers)) {
                result += "native ";
            }
            if (Modifier.isAbstract(modifiers)) {
                result += "abstract ";
            }
            if (Modifier.isFinal(modifiers)) {
                result += "final ";
            }
            result += c.getName() + "\n" + "extends " + c.getSuperclass() + ";\n\n" + "implements ";
            for (Class o : c.getInterfaces()) {
                result += o.getName() + " ";
            }
            result += ";\n\n//Поля\n";
            Field[] fields = c.getDeclaredFields();
            for (Field o : fields) {
                int modifier = o.getModifiers();
                result += (Modifier.isPublic(modifier) ? "public " : Modifier.isPrivate(modifier) ?
                        "private " : Modifier.isStatic(modifier) ? "static " : "") + (Modifier.isFinal(modifier) ? "final " : "")
                        + (Modifier.isAbstract(modifier) ? "abstract " : "") + (Modifier.isTransient(modifier) ? "transient " : "")
                        + o.getType() + " " + o.getName() + ";\n";
            }
            result += "//Конструкторы\n";
            Constructor[] constructors = c.getDeclaredConstructors();
            for (Constructor cn : constructors) {
                int cModifiers = cn.getModifiers();
                Parameter[] parameters = cn.getParameters();
                result += (Modifier.isPublic(cModifiers) ? "public " : Modifier.isPrivate(cModifiers) ? "private " : "") + cn.getName() + "(";
                for (int i = 0; i < parameters.length; i++) {
                    result += parameters[i].getType().getName() + " " + parameters[i].getName() + (i + 1 != parameters.length ? ", " : "");
                }
                result += ");\n";
            }
            result += "//Методы\n";
            Method[] methods = c.getMethods();
            for (Method m : methods) {
                int mModifiers = c.getModifiers();
                Parameter[] parameters = m.getParameters();
                result += (Modifier.isPublic(mModifiers) ? "public " : (Modifier.isPrivate(mModifiers)) ?
                        "private " : (Modifier.isProtected(mModifiers) ? "protected " : "")) + m.getName() + "(";
                for (int i = 0; i < parameters.length; i++) {
                    result += parameters[i].getType().getName() + " " + parameters[i].getName() + (i + 1 != parameters.length ? ", " : "");
                }
                result += ");\n";
            }
        } else if (c.isInterface()) {
                result += c.getPackage() + "\n";
                int modifiers = c.getModifiers();
                if (Modifier.isPublic(modifiers)) {
                    result += "public ";
                }
                if (Modifier.isPrivate(modifiers)) {
                    result += "private ";
                }
                if (Modifier.isProtected(modifiers)) {
                    result += "protected ";
                }
                if (Modifier.isNative(modifiers)) {
                    result += "native ";
                }
                if (Modifier.isAbstract(modifiers)) {
                    result += "abstract ";
                }
                if (Modifier.isFinal(modifiers)) {
                    result += "final ";
                }
                result += ";\n\n//Поля\n";
                Field[] fields = c.getDeclaredFields();
                for (Field o : fields) {
                    int modifier = o.getModifiers();
                    result += (Modifier.isPublic(modifier) ? "public " : Modifier.isPrivate(modifier) ?
                            "private " : Modifier.isStatic(modifier) ? "static " : "") + (Modifier.isFinal(modifier) ? "final " : "")
                            + (Modifier.isAbstract(modifier) ? "abstract " : "") + (Modifier.isTransient(modifier) ? "transient " : "")
                            + o.getType() + " " + o.getName() + ";\n";
                }
                result += "//Методы\n";
                Method[] methods = c.getMethods();
                for (Method m : methods) {
                    int mModifiers = c.getModifiers();
                    Parameter[] parameters = m.getParameters();
                    result += (Modifier.isPublic(mModifiers) ? "public " : (Modifier.isPrivate(mModifiers)) ?
                            "private " : (Modifier.isProtected(mModifiers) ? "protected " : "")) + (Modifier.isAbstract(mModifiers) ?
                            "abstract" : "") + m.getName() + "(";
                    for (int i = 0; i < parameters.length; i++) {
                        result += parameters[i].getType().getName() + " " + parameters[i].getName() + (i + 1 != parameters.length ? ", " : "");
                    }
                    result += ");\n";
                }
            }
        return result;
    }

    }

