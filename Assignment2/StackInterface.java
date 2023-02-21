/**
   An interface for the ADT stack.
*/
public interface StackInterface<T>
{
	/** Adds a new entry to this stack.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or false if not. */
   public boolean push(T newEntry);
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop();
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek();
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty();
   
   /** Tests whether this stack contains a given entry.
	 @param anEntry  The entry to find.
	 @return  True if the bag contains anEntry, or false if not. */
   public boolean stackContains(T anEntry);
  
   /** Removes all entries from this stack. */
   public void clear();
} // end StackInterface
