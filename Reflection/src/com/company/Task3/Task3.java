package com.company.Task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task3 {
    public static void invoke(Object obj, String methodName, Object ... args) throws InvocationTargetException, IllegalAccessException, FunctionNotFoundException {
        Method[] methods = obj.getClass().getMethods();
        boolean f0 = false, f1 = false;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName)) {
                f0 = true;
                if (methods[i].getParameterCount() == args.length) {
                    f1 = true;
                    Parameter[] params = methods[i].getParameters();
                    for (int j = 0; j < params.length; j++) {
                        if (!params[j].getType().equals(args[j].getClass())) {
                            break;
                        }
                    }
                    String result = "Method name: " + methods[i].getName() + "\n";
                    result += "Types: [";
                    for (Parameter p : params) {
                        result += p.getType().getSimpleName() + ",";
                    }
                    result += "]\n";
                    result += "Values: [";
                    for (Object o : args) {
                        result += o + ", ";
                    }
                    result += "]\n";
                    result += "Result: ";
                    System.out.print(result);
                    methods[i].invoke(obj, args);
                }
            }
        }
        if(!(f0 && f1)) throw new FunctionNotFoundException();
    }
}
