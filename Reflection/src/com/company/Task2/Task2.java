package com.company.Task2;

import javax.security.auth.login.Configuration;
import java.lang.reflect.*;
import java.security.Policy;
import java.util.Scanner;

public class Task2 {
    public static void getState(Object obj) throws IllegalAccessException, InvocationTargetException {
        String result = "";
        Class c = obj.getClass();
        result += "Состояние объекта: \n";
        Field[] fields = c.getDeclaredFields();
        for (Field o : fields) {
            int modifier = o.getModifiers();
            if(!o.canAccess(obj)) o.setAccessible(true);
            result += (Modifier.isPublic(modifier) ? "public " : Modifier.isPrivate(modifier) ?
                    "private " : Modifier.isStatic(modifier) ? "static " : "") + (Modifier.isFinal(modifier) ? "final " : "")
                    + (Modifier.isAbstract(modifier) ? "abstract " : "") + (Modifier.isTransient(modifier) ? "transient " : "")
                    + o.getType() + " " + o.getName() + " = "  + o.get(obj) + ";\n";
        }
        result += "\n";
        Method[] methods = c.getMethods();
        int counter = 1;
        for(Method m:methods) {
            int modifiers = c.getModifiers();
            Parameter[] parameters = m.getParameters();
            result += counter + ") " + (Modifier.isPublic(modifiers) ? "public " : (Modifier.isPrivate(modifiers)) ?
                    "private " : (Modifier.isProtected(modifiers) ? "protected " : "")) + m.getName() + "(";
            for (int i = 0; i < parameters.length; i++) {
                result += parameters[i].getType().getName() + " " + parameters[i].getName() + (i + 1 != parameters.length ? ", " : "");
            }
            result += ");\n";
            counter++;
        }
        System.out.println(result);
        System.out.print("Введите порядковый номер метода: ");
        int pos = new Scanner(System.in).nextInt()-1;
        if(pos >= 0 && pos < methods.length) {
            if(methods[pos].getParameters().length == 0) {
                for (int i = 0; i < methods.length; i++) {
                    if (i == pos) {
                        methods[i].invoke(obj);
                    }
                }
            }
            else System.out.println("Вы не можете вызывать методы с параметрами.");
        }
        else System.out.println("Некорректный ввод!");
    }
}
