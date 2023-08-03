import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;

public class test<T> {


    class Pair<T> {

        private T value;

        public T getValue() {
            System.out.println("父类");
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    class DateInter extends Pair<Date> {

        @Override
        public void setValue(Date value) {
            super.setValue(value);
        }

        @Override
        public Date getValue() {
            System.out.println("子类");
            return super.getValue();
        }
    }

    public void test() {
        Pair a = new DateInter();
        a.getValue();
        List list11 = new ArrayList<String>();
    }


    public static <E> E show(E one) { //这是正确的
        System.out.println(one);
        return one;
    }


    public static void main(String[] args) {
        test t = new test();
        t.test();
        test.show(1);
    }
}
