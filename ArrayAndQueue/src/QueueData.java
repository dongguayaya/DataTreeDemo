public interface QueueData<T> {
    int getSize();
    boolean isEmpty();
    T dequeue();
    T getFront();
}
