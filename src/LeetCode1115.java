import sun.rmi.runtime.Log;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class LeetCode1115 {

    class FooBar {
        private int n;
        AtomicInteger atomicInteger = new AtomicInteger(0);

        public FooBar(int n) {
            this.n = n;
        }


        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (atomicInteger.get() % 2 != 0) {
                    Thread.yield();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                atomicInteger.incrementAndGet();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (atomicInteger.get() % 2 != 1) {
                    Thread.yield();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {

        LeetCode1115 leetCode1115 = new LeetCode1115();
        FooBar fooBar = leetCode1115.new FooBar(5);
        ThreadFactory factory = r -> new Thread(r, "123");

        ExecutorService exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), factory);

        exec.execute(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        exec.execute(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        exec.shutdown();
    }
}
