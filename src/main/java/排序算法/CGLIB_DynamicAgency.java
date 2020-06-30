package 排序算法;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by liufeng on 2020/6/22 10:40
 */
public class CGLIB_DynamicAgency implements MethodInterceptor {


    /**
     * 随机8万条数据测试
     */
    @Test
    public void speedTime() {
        // 11s
         run(_1冒泡排序算法实现.class);
        // 4s
         run(_2选择排序算法实现.class);
        // 1s
        run(_3插入排序算法实现.class);
    }

    /**
     * @param c 使用的对象字节码
     */
    public static void run(Class c) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(new CGLIB_DynamicAgency());
        BasicInterface cGsubject = (BasicInterface) enhancer.create();
        cGsubject.speedTest();
    }

    /**
     * @param o           被代理的实例对象
     * @param method
     * @param objects
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long begin = System.currentTimeMillis();

        Object o1 = methodProxy.invokeSuper(o, objects);

        long end = System.currentTimeMillis();

        System.out.printf("%s——————spend time = %.2f秒\n", o.getClass().getSimpleName(), (end - begin)/1000.0);

        return o1;
    }

}


