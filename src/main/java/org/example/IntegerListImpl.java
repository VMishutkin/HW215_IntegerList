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
        if (index > size) {
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
                for (; i < size - 1; i++) {
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
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removed;
    }
    @Override
    public IntegerList copyOf(){
        IntegerList newList = new IntegerListImpl(this.size());
        for (int i = 0; i < this.size(); i++) {
            newList.add(this.get(i));
        }
    return newList;
    }


    @Override
    public boolean contains(Integer item) {
        /*
        checkForNullInput(item);
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;*/

        this.qsort();
        if(this.binarySearch(item)==-1){
            return false;
        }
        return true;
    }

    @Override
    public int indexOf(Integer item) {
        checkForNullInput(item);
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        throw new ItemNotFoundException();

    }

    @Override
    public int lastIndexOf(Integer item) {
        checkForNullInput(item);
        for (int i = size - 1; i >= 0; i--) {
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
    private int binarySearch(Integer number){
        int low = 0;
        int high = this.size - 1;
        while (low<=high){
            int mid = (low+high)/2;
            int guess = arr[mid];
            if(guess==number){
                return mid;
            }else if(guess>number){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return -1;
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
    public IntegerList addAll(IntegerList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            this.add(otherList.get(i));
        }
        return this;
    }


    @Override
    public String toString() {

        return Arrays.toString(this.toArray());
    }


    private Integer[] sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j>0 && arr[j-1]>=tmp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }


        return arr;
    }
    @Override
    public IntegerList isort(){
        this.arr = sortInsertion(this.toArray());
        return this;
    }

    @Override
    public IntegerList csort(){


        for (int i = 0; i < size-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=tmp;
        }


        return this;
    }


    @Override
    public IntegerList qsort() {
        if (size < 2) {
            return this;
        } else {
            int middle = this.get(0);
            IntegerList less = new IntegerListImpl(1);
            IntegerList more = new IntegerListImpl(1);
            for (int i = 1; i < this.size(); i++) {
                if (this.get(i) < middle) {
                    less.add(this.get(i));
                } else {
                    more.add(this.get(i));
                }
            }
            IntegerList result = new IntegerListImpl(1);
            result.addAll(less.qsort());
            result.add(middle);
            result.addAll(more.qsort());
            return result;
        }
    }

    public Integer binarySearch(){
return null;
    }


}
