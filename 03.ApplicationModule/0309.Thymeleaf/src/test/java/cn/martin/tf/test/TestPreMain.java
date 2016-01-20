package cn.martin.tf.test;

/**
 * Created by lcssos on 16/1/6.
 */
public class TestPreMain {
    public static void main(String[] args) throws Exception {

        A a = new A();

        while (true) {
            a.say();
            Thread.sleep(3000);
        }
    }
}
