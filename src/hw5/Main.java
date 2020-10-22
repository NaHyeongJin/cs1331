package hw5;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
