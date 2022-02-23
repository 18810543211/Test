package doctorsay.izx.com.test.utils;

/**
 * Desc
 * <p>
 * Auther sujie
 * <p>
 * Date Time 2021/12/23 11:05 上午
 */
public class TestDL {

    public TestDL() {
    }

    // 饿汉单利
    private static final TestDL testDL1 = new TestDL();

    public static TestDL getInstance1() {
        return testDL1;
    }


    // 懒汉单利
    private static TestDL testDL2 = null;

    public static synchronized TestDL getInstance2() {
        if (testDL2 == null) {
            synchronized (TestDL.class) {
                if (testDL2 == null) {
                    testDL2 = new TestDL();
                }
            }
        }
        return testDL2;
    }


    // 静态内部类
    public static TestDL getInstance3() {
        return ATest.testDL3;
    }

    public static class ATest {
        private static final TestDL testDL3 = new TestDL();
    }
}
