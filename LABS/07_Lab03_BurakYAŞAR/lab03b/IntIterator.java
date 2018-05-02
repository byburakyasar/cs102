package lab03b;

import java.util.Iterator;
/*
 * IntIterator interface that adds a new method nextInt to iterate through Integers
 * @author Burak YA�AR
 * @version 23.03.2017
 */
public interface IntIterator extends Iterator
{
   // Abstract method to return next element of the iterable object as an Integer
   abstract int nextInt();
}