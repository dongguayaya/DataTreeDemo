import java.util.Random;

public class Main {
    private static double testUF(UF uf,int m){

        int size=uf.getSize();
        Random random=new Random();
        long startTime=System.nanoTime();
        for(int i=0;i<m;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.unionElements(a,b);
        }
        for(int i=0;i<m;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int size=10000000;
        int m=10000000;
//        UnionFindQ unionFindQ=new UnionFindQ(size);
//        System.out.println("UnifindQ:"+testUF(unionFindQ,m)+"s");
//        UnionFindU unionFindU=new UnionFindU(size);
//        System.out.println("UnifindU:"+testUF(unionFindU,m)+"s");
        UnionFindU2 unionFindU2=new UnionFindU2(size);
        System.out.println("UnifindU:"+testUF(unionFindU2,m)+"s");
        UnionFindU3 unionFindU3=new UnionFindU3(size);
        System.out.println("UnifindU:"+testUF(unionFindU3,m)+"s");
    }
}
