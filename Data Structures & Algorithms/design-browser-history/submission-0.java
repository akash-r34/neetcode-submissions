public class Node{
    String val;
    Node next;
    Node back;

    public Node(String val){
        this.val=val; 
        this.next=null;
        this.back=null;
    }
}
public class LinkedList{
    Node head;
    Node tail;
    Node current;
    int size;
    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.current=null;
        this.size=0;
    }
    public void add(String val){
        Node temp = new Node(val);
        if(this.head==null){
            this.head=temp;
            this.tail=this.head;
        }
        else{
            this.current.next = temp;
            temp.back=this.current;
            this.tail=temp;
        }
        this.current=this.tail;
        this.size++;
    }
    public String backbySteps(int steps){
        int i=0;
        while(this.current.back!=null && i < steps){
            this.current=this.current.back;
            i++;
        }
        return this.current.val;
    }
    public String forwardbySteps(int steps){
        int i=0;
        while(this.current.next!=null && i < steps){
            this.current=this.current.next;
            i++;
        }
        return this.current.val;
    }
}

class BrowserHistory {
    LinkedList browserHistory;

    public BrowserHistory(String homepage) {
        this.browserHistory = new LinkedList();
        this.browserHistory.add(homepage);
    }
    
    public void visit(String url) {
        this.browserHistory.add(url);
    }
    
    public String back(int steps) {
        return this.browserHistory.backbySteps(steps);
        
    }
    
    public String forward(int steps) {
        return this.browserHistory.forwardbySteps(steps);
    }
}