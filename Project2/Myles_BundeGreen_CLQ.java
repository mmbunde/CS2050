public final class Myles_BundeGreen_CLQ<T> implements DictionaryQueueInterface<T>{
        private Node queueNode;
        private Node freeNode;
        
        public Myles_BundeGreen_CLQ(){
            freeNode = new Node(null, null);
            freeNode.setNextNode(freeNode);
            queueNode = freeNode;
        }
        
        public boolean enqueue(T anEntry){
            boolean added = false;
            freeNode.setData(anEntry);
            if(isNewNodeNeeded()){
                Node newNode = new Node(null, freeNode.getNextNode());
                freeNode.setNextNode(newNode);
                added = true;
            }
            freeNode = freeNode.getNextNode();
            return added;
        }

        public T dequeue(){
            T front = getFront();
            queueNode.setData(null);
            queueNode = queueNode.getNextNode();
            return front;
        }

        public T getFront(){
            if(isEmpty()){
                throw new EmptyQueueException();
            }
            else{
                return queueNode.getData();
            }
        }

        public boolean isEmpty(){
            boolean empty = false;
            if(freeNode == queueNode){
                empty = true;
            }
            return empty;
        }
        public boolean isNewNodeNeeded(){
            return queueNode == freeNode.getNextNode();
        }

        public void clear(){
            queueNode.setData(null);
            freeNode = queueNode;
        }

        private class Node{
            private T data;
            private Node next;

            private Node(T dataPortion){
                this(dataPortion, null);
            }
            private Node(T dataPortion, Node linkPortion){
                data = dataPortion;
                next = linkPortion;
            }
            private T getData(){
                return data;
            }
            private Node getNextNode(){
                return next;
            }
            private void setData(T newData){
                data = newData;
            }
            private void setNextNode(Node nextNode){
                next = nextNode;
            }
            
        }
}