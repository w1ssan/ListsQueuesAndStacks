package BookExercises;

import java.util.Iterator;

/**
 * (Fibonacci number iterator) Define an iterator class named Fibonacci
 * Iterator for iterating Fibonacci numbers. The constructor takes an argument
 * that specifies the limit of the maximum Fibonacci number. For example,
 * new FibonacciIterator(23302) creates an iterator that iterates Fibonacci numbers
 * less than or equal to 23302. Write a test program that uses this iterator to
 * display all Fibonacci numbers less than or equal to 120000.
 */
public class Exercise24_13 {

    public static void main(String[] args) {
        FibonacciIterator fibIterator = new FibonacciIterator(100000);
        while (fibIterator.hasNext()) {
            System.out.println(fibIterator.next());
        }
    }

    public static class FibonacciIterator implements Iterator<Long> {
        private long limit;
        private long f1;
        private long f2;
        private int iteration;

        public FibonacciIterator(long limit) {
            this.limit = limit;
            f1 = 0L;
            f2 = 1L;
            iteration = 0;
        }

        @Override
        public boolean hasNext() {
            return (f1 + f2) < limit;
        }

        @Override
        public Long next() {
            long fib;
            if (iteration == 0) { fib = f1; }
            else if (iteration == 1) { fib = f2; }
            else {
                fib = f1 + f2;
                f1 = f2;
                f2 = fib;
            }
            iteration++;
            return new Long(fib);
        }
    }
}
