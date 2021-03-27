
class SinglyLinkedList <T> {
    /**
     *  There are a various types of linked lists
     * 1. Single linked List
     *   1.1 Single linked list the latest Item is connected to the first one
     * 2. Double linked list
     *   2.1. Double linked list where the latest Item is connected to the first one
     * */

    private Node head;
    private int size;

    // Constructor
    public SinglyLinkedList(){
        head = null;
        size = 0;
    }

    public void pushFront(T obj){
        this.size++;

        Node<T> n = new Node();
        n.item = obj;
        n.nextItem = head;
        head = n;
    }

    public void pushEnd(T obj){
        this.size++;

        Node<T> n = new Node();
        n.item = obj;

        if (head == null){
            head = n;
        } else {
            Node iterator = head;
            while(iterator.nextItem != null){
                iterator = iterator.nextItem;
            }
            iterator.nextItem = n;
        }
    }

    public T popFront(){
        if (head == null){
            System.out.println("SinglyLinkedList Underflow"); // TODO: Probably here should be thrown exception :D
            return null;
        }

        this.size--;
        Node n = head;
        head = head.nextItem;

        return (T) n.item;

    }

    public T popEnd(){
        if (head == null){
            System.out.println("SinglyLinkedList Underflow"); // TODO: Probably here should be thrown exception as well :D
            return null;
        }

        if (head.nextItem == null){
            this.size--;
            Node n = head;
            head = null;
            return (T) n.item;
        }

        Node iterator = head;

         while (iterator.nextItem.nextItem != null){
             iterator = iterator.nextItem;
         }
         this.size--;
         Node n = iterator;
         iterator.nextItem = null;

         return (T) n.item;
    }

    public T popAt(int i){

        if (head == null){
            System.out.println("Your list is empty!");
            return null;
        }

        if (i >= size){
            System.out.println("You are trying to remove not existing item!");
            return null;
        }

        if (head.nextItem == null){
            Node temp = head;
            size--;
            head = null;
            return (T) head;
        }
        if (i == 0){ // TODO: Ask whether there is memory leak!
            Node temp = head;
            head = head.nextItem;
            return (T) temp;
        }

        Node iterator = head;
        for (int j = 0; j < i - 1; j++){
            iterator = iterator.nextItem;
        }

        Node temp = iterator;
        iterator.nextItem = iterator.nextItem.nextItem;
        size--;
        return (T) temp;

    }

    public void printItems(){
        Node iterator = head;
        while (iterator != null){
            System.out.println(iterator.item);
            iterator = iterator.nextItem;
        }
        System.out.println("Singly Linked List has " + this.size + " items");
    }

    private class Node<T>  {
        private T item;
        private Node nextItem;
    }
}
