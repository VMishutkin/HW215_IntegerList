package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntegerListImpl implements IntegerList {

    private Integer[] arr;
    private int size;

    public IntegerListImpl(int size) {
        this.arr = new Integer[size];
        size = 0;
    }

    private void checkForNullInput(Integer item) {
        if (item == null) {
            throw new AddNullException();
        }
    }

    private void checkIndexInput(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void extendArr() {

        Integer[] newArr = new Integer[size * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public Integer add(Integer item) {
        checkForNullInput(item);
        if (size == arr.length) {
            extendArr();
        }
        arr[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkForNullInput(item);
        if(index>size){
            throw new IndexOutOfBoundsException();
        }

        if (size == arr.length) {
            extendArr();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        checkForNullInput(item);
        checkIndexInput(index);
        arr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkForNullInput(item);

        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                for (; i < size-1; i++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                return item;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public Integer remove(int index) {
        checkIndexInput(index);
        Integer removed = arr[index];
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removed;
    }


    @Override
    public boolean contains(Integer item) {
        checkForNullInput(item);
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        checkForNullInput(item);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException();

    }

    @Override
    public int lastIndexOf(Integer item) {
        checkForNullInput(item);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public Integer get(int index) {
        checkIndexInput(index);
        return arr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (this == otherList) {
            return true;
        }
        if (otherList == null || this == null || otherList.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] != otherList.get(i)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (arr != null && arr[0] != null) {
            return false;
        }
        return true;
    }


    @Override
    public void clear() {
        arr = null;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArr = new Integer[size];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public String toString() {

        return Arrays.toString(this.toArray());
    }
}
