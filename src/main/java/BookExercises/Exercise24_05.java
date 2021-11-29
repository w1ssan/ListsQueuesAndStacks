package BookExercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * (Implement GenericQueue using inheritance) In Section 24.5, Stacks and
 * Queues, GenericQueue is implemented using composition. Define a new queue
 * class that extends java.util.LinkedList.
 */
public class Exercise24_05 {
    public static void main(String[] args) {
        ArrayList<Integer> startingList = new ArrayList<>();
        startingList.add(5);
        startingList.add(10);
        startingList.add(-2);
        startingList.add(0);
        startingList.add(51);

        System.out.println(startingList);

        GenericQueue<Integer> queue = new GenericQueue<>(startingList);

        System.out.println(queue);

        queue.enqueue(56);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println(queue.getSize());
    }

    public static class GenericQueue<E> extends LinkedList<E> {
        private static final long serialVersionUID = 7586471125622736147L;

        public GenericQueue() {
        }

        public GenericQueue(Collection<? extends E> c) {
            super(c);
        }

        public void enqueue(E e) {
            addLast(e);
        }

        public E dequeue() {
            return removeFirst();
        }

        public int getSize() {
            return size();
        }
    }
}
