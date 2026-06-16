class Node{
    int val;
    Node next;
    Node(){
        this.val = 0;
        this.next = null;
    }
    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size=0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        int count=0;
        Node temp = head;
        while(count<index){
            temp=temp.next;
            count++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = this.head;
        this.head = temp;
        if (size == 0) this.tail = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }
        Node temp = new Node(val);
        this.tail.next = temp;
        this.tail = temp;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==size){
            addAtTail(val);
            return;
        }
        else if(index>size){
            return;
        }
        else if(index <= 0){
            addAtHead(val);
            return;
        }
        else{
            int count=0;
            Node temp = head;
            Node toAdd = new Node(val);
            while(count < index - 1){
                temp=temp.next;
                count++;
            }
            Node temp1 = temp.next;
            temp.next = toAdd;
            toAdd.next = temp1;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (size == 1) tail = null;
        } else {
            int count=0;
            Node temp = head;
            while(count < index-1){
                temp=temp.next;
                count++;
            }
            temp.next = temp.next.next;
            if (index == size - 1) tail = temp;
        }
        size--;
    }
}