import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class LeetCode1116 {
    class ZeroEvenOdd {
        private int n;
        AtomicInteger zero = new AtomicInteger(1);
        AtomicInteger even = new AtomicInteger(0);
        AtomicInteger odd = new AtomicInteger(1);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (zero.get() != 1) {
                    Thread.yield();
                }
                printNumber.accept(0);
                zero.decrementAndGet();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                while (zero.get() == 1 || even.get() == 0) {
                    Thread.yield();
                }
                printNumber.accept(i);
                zero.incrementAndGet();
                even.decrementAndGet();
                odd.incrementAndGet();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                while (zero.get() == 1 || odd.get() == 0) {
                    Thread.yield();
                }
                printNumber.accept(i);
                zero.incrementAndGet();
                odd.decrementAndGet();
                even.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1116 leetCode1116 = new LeetCode1116();
        ZeroEvenOdd zeroEvenOdd = leetCode1116.new ZeroEvenOdd(2);
        ThreadFactory factory = r -> new Thread(r, r.toString());

        ExecutorService exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), factory);

        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(System.out::println);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String toString() {
                return "zero";
            }
        });

        exec.execute(new Runnable() {
                         @Override
                         public void run() {
                             try {
                                 zeroEvenOdd.even(System.out::println);
                             } catch (InterruptedException e) {
                                 throw new RuntimeException(e);
                             }
                         }

                         public String toString() {
                             return "even";
                         }
                     }
        );

        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(System.out::println);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            public String toString() {
                return "odd";
            }
        });
        exec.shutdown();
    }
}
