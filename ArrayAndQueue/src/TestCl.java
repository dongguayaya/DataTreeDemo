import java.util.Random;

public class TestCl {
    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(QueueData<Integer> q,int opCount){
        long startTime=System.nanoTime();
        Random random=new Random();
        for(int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            q.dequeue();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {

        int opCount=100;

        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time"+time1+" s");

        LooperQueue<Integer> loopQueue=new LooperQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LooperQueue,time2"+time2+" s");

        LinkedListQueue<Integer> linkQueue=new LinkedListQueue<>();
        double time3=testQueue(linkQueue,opCount);
        System.out.println("LooperQueue,time3"+time3+" s");
    }
}
