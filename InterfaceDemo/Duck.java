public class Duck implements Runnable, Swimmable, Soundable {

    @Override
    public void run() {
        System.out.println("Vịt chạy lạch bạch trên bờ");
    }

    @Override
    public void swim() {
        System.out.println("Vịt đang bơi dưới nước");
    }

    @Override
    public void sound() {
        System.out.println("Cạp cạp!");
    }
}
