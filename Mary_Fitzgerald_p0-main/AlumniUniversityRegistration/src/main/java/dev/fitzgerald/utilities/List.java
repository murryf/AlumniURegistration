package dev.fitzgerald.utilities;
// List should dynamically resize
// allow me to insert elements and have the order of insertion maintained
// does allow duplicates
/**
 * Interface to describe a list utility for a hand-made data structure
 * */
public interface List<T> {

    void add(T element);    //lists can add to themselves

    T get(int index);       //lists can return values from themselves

    int size();             //lists have a defined size

}
