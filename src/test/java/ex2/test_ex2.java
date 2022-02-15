package ex2;

import org.testng.annotations.Test;
import ru.tulenev.ex2.Priority;
import ru.tulenev.ex2.TestMethodInfo;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class test_ex2 {

    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user1", lastModified = "20.08.2019")
    public void annotation() {
        Class c = test_ex2.class;
        Method[] methods =  c.getDeclaredMethods();
        for (Method meth:methods) {
            if (meth.isAnnotationPresent(TestMethodInfo.class)) {
                System.out.println("Test method name: " + meth.getName());
                System.out.println("Annotation TestMethodInfo.priority : " + meth.getAnnotation(TestMethodInfo.class).priority() +
                        "\nAnnotation TestMethodInfo.author : " + meth.getAnnotation(TestMethodInfo.class).author() +
                        "\nAnnotation TestMethodInfo.lastModified() : " + meth.getAnnotation(TestMethodInfo.class).lastModified());
            }
        }
                assertEquals(1, 1);
    }
}
