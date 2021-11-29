package BookExercises;

/**
 * (Prime number iterator) Define an iterator class named PrimeIterator for
 * iterating
 * prime numbers. The constructor takes an argument that specifies the limit
 * of the maximum prime number. For example, new PrimeIterator(23302)
 * creates an iterator that iterates prime numbers less than or equal to 23302. Write
 * a test program that uses this iterator to display all prime numbers less than or
 * equal to 120000.
 */
import java.util.Iterator;

public class Exercise24_14 {
    public static void main(String[] args) {
        Iterator<Integer> iterator = new PrimeIterator(120000);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static class PrimeIterator implements java.util.Iterator<Integer> {
        private int limit;
        private int current = 1;

        public PrimeIterator(int limit) {
            this.limit = limit;
        }

        @Override
        public Integer next() {
            return current;
        }

        static boolean isPrime(int number) {
            for (int divisor = 2; divisor < number; divisor++)
                if (number % divisor == 0)
                    return false;
            return true;
        }

        @Override
        public boolean hasNext() {
            current++;

            while (true) {
                if (isPrime(current))
                    break;
                current++;
            }

            if (current >= limit)
                return false;
            else
                return true;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException
                    ("Method not supported");
        }
    }

}

