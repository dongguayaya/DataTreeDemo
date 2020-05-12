public class LinkedListQueue<T> implements QueueData<T> {

    private class Node{
        public T e;
        public Node next;
        public Node(T e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(T e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }

    }
    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(T e) {
        if(tail==null){
            tail=new Node(e);
            head=tail;
        }
        else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Can not dequeue from an empty queue");
        Node retNode=head;
        head=head.next;
        retNode.next=null;
        if(head==null)
            tail=null;
        size--;
        return retNode.e;
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Can not dequeue from an empty queue");
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue: front");
        Node cur=head;
        while(cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("null tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedListQueue<Integer> queue=new LinkedListQueue<>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
