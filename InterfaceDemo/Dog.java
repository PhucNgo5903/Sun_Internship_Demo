public class Dog implements Runnable, Soundable {

    @Override
    public void run() {
        System.out.println("Chó đang chạy bằng 4 chân");
    }

    @Override
    public void sound() {
        System.out.println("Gâu gâu!");
    }
}
