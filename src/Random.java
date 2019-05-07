public class Random {


    public Random(){
        System.out.println("Super constructor");
    }

    public static <T> void print(T t){
        System.out.println(t);
    }

    public void testMethod(){
        print("random");
    }
}
