package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringListImpl implements StringList {

    private String[] arr;
    private int size;

    public StringListImpl(int size) {
        this.arr = new String[size];
        size = 0;
    }

    private void checkForNullInput(String item) {
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

        String[] newArr = new String[size * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public String add(String item) {
        checkForNullInput(item);
        if (size == arr.length) {
            extendArr();
        }
        arr[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        checkForNullInput(item);
        checkIndexInput(index);
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        checkIndexInput(index);
        String removed = arr[index];
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removed;
    }


    @Override
    public boolean contains(String item) {
        checkForNullInput(item);
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkForNullInput(item);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException();

    }

    @Override
    public int lastIndexOf(String item) {
        checkForNullInput(item);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public String get(int index) {
        checkIndexInput(index);
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        String[] strings = new String[size];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = arr[i];
        }
        return strings;
    }

    @Override
    public String toString() {

        return Arrays.toString(this.toArray());
    }
}
