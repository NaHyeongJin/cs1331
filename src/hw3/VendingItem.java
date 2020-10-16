package hw3;

public enum VendingItem {
    Lays(1.50), Doritos(1.50), Coke(2.50), Ramblin_Reck_Toy(180.75), Rubiks_Cube(30.00), Rat_Cap(15.00),
    FASET_Lanyard(10.00), Graphing_Calculator(120.00), UGA_Diploma(0.10), Pie(3.14), Clicker(55.55), Cheetos(1.25),
    Sprite(2.50), Red_Bull(4.75), Ramen(3.15), Cold_Pizza(0.99);

    private final double price; // 항목의 가격 생성자에서 초기화

    // 가격 매개변수로 받는 생성자
    private VendingItem(double price) {
        this.price = price;
    }

    // price final이라 getter만 만들면 됨
    public double getPrice() {
        return price;
    }

    // 시뮬레이션 하기 위한 String을 반환함.
    // 이렇게 보일거임
    // “(name): $xx.xx”
    public String toString() {
        return this.name() + ": $" + this.price;
    }

}
