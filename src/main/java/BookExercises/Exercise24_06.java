package BookExercises;

import BookExamples.Heap;

import java.util.Comparator;

/**
 * (Generic PriorityQueue using Comparator) Revise MyPriorityQueue
 * in Listing 24.8, using a generic parameter for comparing objects. Define a new
 * constructor
 * with a Comparator as its argument as follows:
 * PriorityQueue(Comparator<? super E> comparator)
 */
public class Exercise24_06 {

    public static class MyPriorityQueue<E extends Comparable<E>> {
        public static void main(String[] args) {
            Patient patient1 = new Patient("John", 2);
            Patient patient2 = new Patient("Jim", 1);
            Patient patient3 = new Patient("Tim", 5);
            Patient patient4 = new Patient("Cindy", 7);

            MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
            priorityQueue.enqueue(patient1);
            priorityQueue.enqueue(patient2);
            priorityQueue.enqueue(patient3);
            priorityQueue.enqueue(patient4);

            while (priorityQueue.getSize() > 0) {
                System.out.print(priorityQueue.dequeue() + " ");
            }
            System.out.println();

            MyPriorityQueue<Patient> pq2 =
                    new MyPriorityQueue<>();//new DescendingComparator<Patient>()
            pq2.enqueue(patient1);
            pq2.enqueue(patient2);
            pq2.enqueue(patient3);
            pq2.enqueue(patient4);

            while (pq2.getSize() > 0) {
                System.out.print(pq2.dequeue() + " ");
            }
            System.out.println();
        }

        static class Patient implements Comparable<Patient> {
            private String name;
            private int priority;

            public Patient(String name, int priority) {
                this.name = name;
                this.priority = priority;
            }

            @Override
            public String toString() {
                return name + "(priority:" + priority + ")";
            }

            @Override
            public int compareTo(Patient patient) {
                if (priority > patient.priority) {
                    return 1;
                } else if (priority < patient.priority) {
                    return -1;
                }
                return 0;
            }
        }

        private Heap<E> heap = new Heap<>();

        public MyPriorityQueue() {
            heap = new Heap<>();
        }

        /*
        public MyPriorityQueue(Comparator<? super E> comparator) {
            heap = new Heap<>(comparator);
        }

         */

        public void enqueue(E newObject) {
            heap.add(newObject);
        }

        public E dequeue() {
            return heap.remove();
        }

        public int getSize() {
            return heap.getSize();
        }
    }
    public static class DescendingComparator<E extends Comparable<E>> implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            if (o1.compareTo(o2) < 0) {
                return 1;
            } else if (o1.compareTo(o2) > 0) {
                return -1;
            }
            return 0;
        }
    }

}
