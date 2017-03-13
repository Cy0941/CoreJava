package cn.cxy.test.ch6;

/**
 * Function: 静态内部类
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/13 23:23 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class StaticInnerClassTest {
    public static void main(String[] args){
        double[] d = new double[20];
        for (int i = 0; i < 20; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.Pair.minmax(d);
        System.out.println("min = "+p.getFirst());
        System.out.println("max = "+p.getSecond());
    }
}

class ArrayAlg{
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public static Pair minmax(double[] values){
            double min = Double.MIN_VALUE;
            double max = Double.MAX_VALUE;
            for (double v : values) {
                if (min > v){
                    min = v;
                }
                if(min < v){
                    max = v;
                }
            }
            return new Pair(min,max);
        }
    }
}
