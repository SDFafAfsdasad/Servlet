package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建真实对象
        Lenovo lenovo=new Lenovo();

        //动态代理增强lenovo对象
        /*
            三个参数：
                类加载器：真实对象.getClass().getClassLoader()
                接口数组：真实对象.getClass().getInterfaces()
                处理器：new InvocationHandler()
        */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {

            //代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
            /*
                参数：
                    proxy：代理对象
                    method：代理对象调用的方法，被封装为的对象
                    args：代理对象调用的方法时，传递的实际参数
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("running...");

                //使用真实对象调用该方法
                Object obj = method.invoke(lenovo, args);

                return obj;
            }
        });

//        String computer = lenovo.sale(8000);
//        System.out.println(computer);
        proxy_lenovo.show();
    }
}
