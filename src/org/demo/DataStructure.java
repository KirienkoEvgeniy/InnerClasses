package org.demo;

import java.util.NoSuchElementException;

interface DataStructureIterator extends java.util.Iterator<Integer> {
}

public class DataStructure {

    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    private int index = 0;

    public DataStructure() {

        //заполнение массива числами от 0 до 15
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    private class EvenIterator implements DataStructureIterator {


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < SIZE;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if (index < SIZE) {
                return arrayOfInts[index++];
            } else {
                throw new NoSuchElementException("No such element.");
            }
        }
    }

    public EvenIterator getEvenIterator() {
        DataStructure.EvenIterator evenIterator = new DataStructure().new EvenIterator();
        return evenIterator;
    }

    public static void main(String[] args) {
        DataStructure dataStructure = new DataStructure();
        DataStructure.EvenIterator evenIterator = dataStructure.getEvenIterator();
        while (evenIterator.hasNext()) {
            Integer next = evenIterator.next();
            System.out.print(" " + next);

        }
    }

}