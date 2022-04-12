package dev.fitzgerald.utilities;

import java.util.Arrays;

public class ArrayList<T> implements List<T>{

    private Object [] elements;
    private int currentIndex;

    public ArrayList(){
        this.elements = new Object[10];
        this.currentIndex = 0;
    }

    @Override
    public void add(T element) {
        if(currentIndex <this.elements.length){
            this.elements[currentIndex] = element;
        }else{
            // resizing logic
            this.elements = Arrays.copyOf(this.elements, this.elements.length + 10);
            this.elements[currentIndex] = element;
        }
        this.currentIndex++;

    }

    public void remove(int i){
        Object oldValue = this.elements[i];
        int numMoved = this.size() - i - 1;
        if(numMoved >0){
            System.arraycopy(this.elements, i+1, this.elements, i, numMoved);
        }
        elements[--this.currentIndex] = null;
    }

    @Override
    public T get(int index) {
        return (T) this.elements[index];
    }

    @Override
    public int size() {
        return this.currentIndex;
    }
}
