public class DoubleLinkedList <T> {
    /**
     * Double Linked List with head and tail Pointers
     * */

    private int size;
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.size = 0;
        this.head = this.tail = null;
    }

    public int getSize(){
        return this.size;
    }

    public void pushFront(T obj){

        Node n = new Node(obj);

        if (head == null){
            this.head = this.tail = n;
        } else {
            n.nextItem = this.head;
            this.head.prevItem = n;
            this.head = n;
        }
        this.size++;
    }

    public void pushEnd(T obj){
        Node n = new Node(obj);
        if (head == null){
            this.head = this.tail = n;
        } else {
            n.prevItem = this.tail;
            this.tail.nextItem = n;
            this.tail = n;
        }
        this.size++;
    }

    public T popFront(){
        if (head == null){
            System.out.println("List is Empty!");
            return null;
        }
        Node tmp = head;

        head = head.nextItem;
        head.prevItem = null;
        this.size--;

        return (T) tmp.item;
    }

    public T popEnd(){
        if (head == null){
            System.out.println("List is Empty!");
            return null;
        }

        Node tmp = tail;
        tail = tail.prevItem;
        tail.nextItem = null;
        this.size--;

        return (T) tmp.item;
    }

    public void addAt(int at, T obj){
        if(at >= size || at < 0){
            System.out.println("Out of bounds!"); // TODO: Here should be thrown Exception
            return;
        }

        if (at == 0){
            pushFront(obj);
            return;
        }

        Node n = new Node(obj);
        Node iterator;
        if (at <= size / 2){
            iterator = head;

            for (int i = 0; i < at; i++){
                iterator = iterator.nextItem;
            }

        } else {
            iterator = tail;

            for (int i = size - 1; i > at; i--){
                iterator = iterator.prevItem;
            }
        }

        n.prevItem = iterator.prevItem;
        iterator.prevItem.nextItem = n;
        n.nextItem = iterator;
        iterator.prevItem = n;
        this.size++;
    }

    public T popAt(int at){
        if (at >= size || at < 0 ){
            System.out.println("Out of bounds!!");
            return null;
        }

        if (at == 0){
            return popFront();
        }
        if (at == size - 1){
            return popEnd();
        }

        Node iterator;
        if (at <= size / 2){
            iterator = head;
            for (int i = 0; i < at; i++){
                iterator = iterator.nextItem;
            }
        } else {
            iterator = tail;
            for (int i = size-1; i > at + 1; i--){
                iterator = iterator.prevItem;
            }
        }
        Node tmp = iterator;
        iterator.prevItem.nextItem = iterator.nextItem;
        iterator.nextItem.prevItem = iterator.prevItem;
        this.size--;

        return (T) tmp.item;
    }

    public T getFirst(){
        return (T) this.head.item;
    }

    public T getLast(){
        return (T) this.tail.item;
    }

    public void printForward(){
        Node iterator = head;
        System.out.print("Print Forward : ");
        while(iterator !=null){
            System.out.print(iterator.item + " ");
            iterator = iterator.nextItem;
        }
        System.out.println();
    }

    public void printBackward(){
        Node iterator = tail;
        System.out.print("Print Backward : ");
        while (iterator!=null){
            System.out.print(iterator.item + " ");
            iterator = iterator.prevItem;
        }
        System.out.println();
    }
    private class Node <T> {
        private T item;
        private Node nextItem;
        private Node prevItem;

        Node(T obj){
            this.item = obj;
        }
    }
}
