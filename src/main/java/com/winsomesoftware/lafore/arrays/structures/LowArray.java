package com.winsomesoftware.lafore.arrays.structures;

public class LowArray<T> implements Low<T> {

    private T[] array;

    public LowArray(int size) {
        array = (T[])new Object[size];
    }

    @Override
    public void setElem(int index, T element) {
         array[index] = element;
    }

    public T getElem(int index) {
        return array[index];
    }
}
