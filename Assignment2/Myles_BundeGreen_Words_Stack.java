import java.util.EmptyStackException;

public final class Myles_BundeGreen_Words_Stack<T> implements StackInterface<T>{
    
    private Node topNode; 
    
    public Myles_BundeGreen_Words_Stack(){
        topNode = null;
    }

    private class Node{
        private T data;
        private Node next;

        private Node(T dataPortion)
      {
         this(dataPortion, null);
      }
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      }
      
      private T getData()
      {
         return data;
      }
      
      private Node getNextNode()
      {
         return next;
      }
      
      /*private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }*/

    }

    public boolean push(T newEntry){
        topNode = new Node(newEntry, topNode);
        return true;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return topNode.getData();
        }
    }
    public T pop(){
        T top = peek();
        topNode = topNode.getNextNode();
        return top;
    }

    public boolean isEmpty(){
        if(topNode == null){
            return true;
        }
        return false;
    }
    public void clear(){
        topNode = null;
    }

    public boolean stackContains(T anEntry){
        return false;
    }
}