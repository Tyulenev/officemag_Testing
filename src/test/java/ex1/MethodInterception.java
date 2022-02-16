package ex1;

import org.junit.Test;
import ru.tulenev.ex1.MainPage;
import ru.tulenev.ex1.Selector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MethodInterception implements InvocationHandler {

    @Test
        public void annotationValue() {
            MainPage mainPage = createPage(MainPage.class);
            assertNotNull(mainPage);
            assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
            assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
        }

    private MainPage createPage(Class clazz) {

        System.out.println("Meth Create Page Start!");


//        MainPage mp = new MainPage() {
//            @Override
//            public String textInputSearch() {
//                System.out.println("Method : textInputSearch()");
//                return "111";
//            }
//
//            @Override
//            public String buttonSearch() {
//                System.out.println("Method : buttonSearch()");
//                return "222";
//            }
//        };

        MainPage mpReturned = (MainPage)Proxy.newProxyInstance(
                mp.getClass().getClassLoader(),
                mp.getClass().getInterfaces(),
                new MethodInterception());

        return mpReturned;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("!!!!!!!!!!!!!!!!!!!!invoke meth:!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String str = method.getAnnotation(Selector.class).xpath();
        System.out.println("method.getAnnotation(Selector.class).xpath() : " + str);
        return str;
    }


}
