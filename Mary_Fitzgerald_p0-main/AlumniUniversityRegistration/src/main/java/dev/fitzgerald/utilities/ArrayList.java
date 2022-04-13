package dev.fitzgerald.utilities;

import java.util.Arrays;

/**
 * Class to define an ArrayList object for data storage by implementing List.
 * Part of a set of hand-build data structures
 * */
public class ArrayList<T> implements List<T>{

    //fields
    private Object [] elements;
    private int currentIndex;

    /**
     * Constructor for the ArrayList object
     * */
    public ArrayList(){
        this.elements = new Object[10];
        this.currentIndex = 0;
    }

    /**
     * Method to add an object to the end of the ArrayList
     * @param element the element to be added
     * */
    @Override
    public void add(T element) {
        if(currentIndex <this.elements.length){ //if space, add element
            this.elements[currentIndex] = element;
        }else{
            // resizing logic
            this.elements = Arrays.copyOf(this.elements, this.elements.length + 10);
            this.elements[currentIndex] = element;
        }
        this.currentIndex++;
    }

    /**
     * Method to remove an element from the ArrayList
     * @param i the index of the element to remove
     * */
    public void remove(int i){
        int numMoved = this.size() - i - 1; //the size minus the index minus one
        if(numMoved >0){//if in the middle
            System.arraycopy(this.elements, i+1, this.elements, i, numMoved); //move everything over a bit
        }
        elements[--this.currentIndex] = null; //decrement the index
    }

    /**
     * Method to get something from a given index in the ArrayList
     * @param index the index to be checked
     * @return the object at that location
     * */
    @Override
    public T get(int index) {
        return (T) this.elements[index]; //ensure it is generic
    }

    /**
     * Method to implement the size function of a list
     * @return the size of the array, or current index position
     * */
    @Override
    public int size() {
        return this.currentIndex;
    }
}
