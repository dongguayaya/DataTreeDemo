import java.lang.reflect.Array;

public class ArrayStack<E> implements Stack<E> {
    ArrayData<E> arrayData;
    public ArrayStack(int capacity){
        arrayData=new ArrayData<>(capacity);
    }
    public ArrayStack(){
        arrayData=new ArrayData<>();
    }
    @Override
    public int getSize(){
        return arrayData.getSize();
    }
    @Override
    public boolean isEmpty(){
        return arrayData.isEmpty();
    }

    public int getCapacity(){
        return arrayData.getCapacity();
    }

    @Override
    public void push(E e){
        arrayData.addLast(e);
    }
    @Override
    public E pop(){
        return arrayData.removeLast();
    }
    @Override
    public E peek(){
        return arrayData.getLast();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i=0;i<arrayData.getSize();i++){
            res.append(arrayData.get(i));
            if(i!=arrayData.getSize()-1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
