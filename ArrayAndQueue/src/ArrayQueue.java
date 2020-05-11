

public class ArrayQueue<T> implements QueueData {

    private ArrayData<T> arrayData;
    public ArrayQueue(int capacity){
        arrayData=new ArrayData<>(capacity);
    }
    public ArrayQueue(){
        arrayData=new ArrayData<>();
    }
    @Override
    public int getSize(){
        return  arrayData.getSize();
    }
    @Override
    public boolean isEmpty(){
        return  arrayData.isEmpty();
    }


    public void enqueue(T e) {
        arrayData.addLast(e);
    }


    @Override
    public T dequeue()
    {
        return arrayData.removeFirst();
    }

    @Override
    public T getFront() {
        return arrayData.getFirst();
    }

    public int getCapacity(){
        return arrayData.getCapacity();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i=0;i<arrayData.getSize();i++){
            res.append(arrayData.get(i));
            if(i!=arrayData.getSize()-1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>();
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
