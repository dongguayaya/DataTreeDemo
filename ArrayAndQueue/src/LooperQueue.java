

public class LooperQueue<T> implements QueueData<T> {
    private T[] data;
    private int front,tail;
    private int size;
    public LooperQueue(int capacity){
        data=(T[])new Object[capacity+1];
        front=0;
        size=0;
        tail=0;
    }
    public LooperQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty(){
        return front==tail;
    }
    @Override
    public int getSize(){
        return size;
    }
    public void enqueue(T e){
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;

    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Can not dequeue from an empty queue");
        T ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity() / 4 && getCapacity() / 2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Can not dequeue from an empty queue");
        return data[front];
    }

    private void resize(int newCapacity){
        T[] newData=(T[])new Object[newCapacity+1];
        for(int i=0;i<size;i++){
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Queue:size =%d,capacity=%d\n",size,getCapacity()));
        res.append("front [");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LooperQueue<Integer> queue=new LooperQueue<>();
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
