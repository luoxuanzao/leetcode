import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode1114 {
    class Foo {

        AtomicInteger firstJob = new AtomicInteger(0);
        AtomicInteger secondJob = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstJob.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (firstJob.get() != 1) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondJob.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (secondJob.get() != 1) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
