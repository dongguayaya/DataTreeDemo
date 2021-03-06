
//E是类型，泛型
public class ArrayData<T> {
    private T[] data;
    private int size;

    /**
     *
     * @param capacity
     */
    //构造函数，传入数组的容量capacity构造Array
    public ArrayData(int capacity){
        data=(T[]) new Object[capacity];
        size=0;
    }
    //无参数构造函数，默认数组的容量capacity=10
    public ArrayData(){
        this(10);
    }

    //获得数组中的元素个数
    public int getSize(){
        return size;
    }
    //获得数组中的容量
    public int getCapacity(){
        return data.length;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //向所有元素后添加一个新元素O(n)
    public void addLast(T e){
        add(size,e);
    }
    //在所有元素前添加一个新元素O(n)
    public void addFirst(T e){
        add(0,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index,T e){
        if(size==data.length)
            resize(2*data.length);
        if(index<0||index>size)
            throw  new IllegalArgumentException("Addlist failed,Array is full");
        for(int i=size-1;i>=index;i--)
            data[i+1]=data[i];

            data[index]=e;
            size++;

    }

    private void resize(int newCapacity) {
        T[] newData=(T[]) new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;
    }

    //获取index索引位置的元素
    public T get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get Failed.Index is illegal");

        }
        return data[index];
    }
    public T getLast(){
        return get(size-1);

    }
    public T getFirst(){
        return get(0);
    }
    //修改index索引位置的元素e
    void set(int index,T e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get Failed.Index is illegal");

        }
        data[index]=e;
    }
    //查找数组中是否有元素e
    public boolean contains(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;

    }
    //从数组中删除index位置的元素，返回删除的元素
    public T remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get Failed.Index is illegal");

        }
        T ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null; //loitering objects!=memory leak
        if(size==data.length/4&&data.length/2!=0)
            resize(data.length/2);
        return ret;
    }
    //从数组中删除第一个元素，返回删除的元素
    public T removeFirst(){
        return remove(0);
    }
    //从数组中删除最后一个元素，返回删除的元素
    public T removeLast(){
        return remove(size-1);
    }
    //从数组中删除e
    public void removeElement(T e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }

    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size =%d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
