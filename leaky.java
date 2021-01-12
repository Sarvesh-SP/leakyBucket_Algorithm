package leakyBucket;
import java.util.*;
import java.util.Random;
public class leaky {
    public static void main(String[] args) {
        int bckt, total = 0, rem_bytes, iter, oprate, flow;
        int pkt[] = new int[20];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of input flows");
        flow = in.nextInt();

        System.out.println("Enter the number of iterations");
        iter = in.nextInt();


        System.out.println("Enter the bucket size and output rate");
        bckt = in.nextInt();
        oprate = in.nextInt();

        Random rand = new Random();

        for (int i = 0; i < iter; i++) {
            System.out.println("Iteration "+ (i+1));
            for(int j = 0; j < flow; j++){
                rand.setSeed(System.nanoTime());
                pkt[j] = rand.nextInt(5000);
                total += pkt[j];

                if (total <= bckt){
                    System.out.println("Packet accepted with total "+ total);
                }
                else {
                    total -= pkt[j];
                    System.out.println("Packet not accepted with total "+ total);
                }

            }
            if (oprate > total){
                rem_bytes = total;
                total = 0;
                System.out.println("==========================================");
                System.out.println("Oprate is "+ oprate + "Bytes sent of the bucket is: "+ rem_bytes);
            }
            else {
                total -= oprate;
                System.out.println("Oprate is "+ oprate + "Bytes sent of the bucket is: "+ total);
                System.out.println("----------------------------------------------");
            }
        }

    }
}
