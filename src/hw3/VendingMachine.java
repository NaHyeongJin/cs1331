package hw3;

import java.util.Random;

public class VendingMachine {
    private static double totalSales; // 총 판매량. 초기화 때 0으로 초기화해야하고 판매할 때마다 +1
    private VendingItem[][][] shelf; // 이 3차원 배열은 자판기에서 항목이 배열되는 방식을 나타냄.
    // shelf [i] [j] [k]는 i 번째 행, j 번째 열 및 k 번째 위치에있는 VendingItem을 나타냄.
    // 여기서 위치 0 (shelf [i] [j] [0])은 "스택 ”및 각 후속 위치는 그 뒤에있는 항목을 나타냄.
    // [6][3][5]로 초기화해야 함
    private int luckyChance; // 사용자가 현재 vend()에서 당첨 될 확률 0으로 초기화해야 함.
    private Random rand; // 그냥 Random 인스턴스

    // 이것은 VendingMachines에 대한 매개변수 없는 단일 생성자임
    // 필드를 초기화하고 여기에서 restock()을 호출하여 누군가 초기화하자마자 자동 판매기가 사용할 준비가되도록 해야 함.
    public VendingMachine() {
        totalSales = 0;
        shelf = new VendingItem[6][3][5];
        luckyChance = 0;
        rand = new Random();
        restock();
    }

    // 얘는 자판기에서 품목을 분배하는 메소드임
    // 사용자 입력을 나타내는 매개 변수 코드를 받음
    // 이 코드는 선택한 항목의 행과 열을 나타내는 숫자가 뒤에 오는 문자 형식으로 지정됨 ex) vend(A6);
    // 행과 열에서 항목 분배해야 하고 항목 뒤로 이동해야하고 항상 0위치에 항목이 있게 해야 함(가능하면)
    // 이 메서드는 또한 어떤 것을 분배하기 전에 코드의 유효성을 검사해야하며 에러 나면 오류문 인쇄 후 null 반환 (이상한 곳으로 지정하면
    // 에러인듯)
    // 또한 사용자가 선택한 위치에 항목이 없으면 오류 문을 인쇄하고 null을 반환해야 함. (항목 없는데 지정해도 에러)
    // free() 메서드에 의해 분배되는 항목이 무료면 print해야 함.
    // 필요에 따라 totalSales 필드를 업데이트해야 함. 항목이 무료이거나 문제가 발생한 경우 totalSales를 업데이트 하면 안됨
    public VendingItem vend(String code) {
        VendingItem answer;
        if (code.length() != 2) {
            System.out.println("Input Error!");
            return null;
        }
        int row = (int) (code.charAt(1) - '1');
        int col = (int) (code.charAt(0) - 'A');
        if (row < 0 || row >= shelf.length) {
            System.out.println("Input Error!");
            return null;
        }
        if (col < 0 || col >= shelf[row].length) {
            System.out.println("Input Error!");
            return null;
        }
        if (shelf[row][col][0] == null) {
            System.out.println("It's empty.");
            return null;
        }
        answer = shelf[row][col][0];
        if (free()) {
            System.out.println("Lucky!");
        } else {
            totalSales += answer.getPrice();
        }
        for (int i = 0; i < shelf[row][col].length - 1; i++) {
            shelf[row][col][i] = shelf[row][col][i + 1];
            if (shelf[row][col][i + 1] == null)
                break;
            if (i == shelf[row][col].length - 2)
                shelf[row][col][i + 1] = null;
        }
        return answer;
    }

    // 얘는 현재 사용자가 무료로 받아야 하는지 결정하기 위해 vend()와 함께 사용해야 함
    // 이 메서드는 true를 반환 할 확률이 luckyChance와 같아야함 (rand 사용).
    // 메서드가 true를 반환하면 luckyChance를 0으로 재설정 메서드가 false를 반환하면 luckyChance를 1 씩 증가시킴
    private boolean free() {
        if (rand.nextInt(100) < luckyChance) {
            luckyChance = 0;
            return true;
        } else {
            luckyChance++;
            return false;
        }
    }

    // 이 메서드는 호출 될 때마다 무작위로 선택한 항목으로 자동 판매기의 각 지점을 채워야함
    // 힌트 : 이 기능을 사용하려면 Enum의 rand 및 values​​() 메서드를 사용하면 됨.
    // link : https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    public void restock() {
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int j2 = 0; j2 < shelf[i][j].length; j2++) {
                    shelf[i][j][j2] = VendingItem.values()[rand.nextInt(VendingItem.values().length)];
                }
            }
        }
    }

    // 얘는 totalSales 필드에 대한 getter임.
    // 얘는 static임 왜냐하면 totalSales가 정적 변수이고 모든 자동 판매기에서 판매 추적하기 때메
    public static double getTotalSales() {
        return totalSales;
    }

    // 이 메서드는 자동 판매기의 총 VendingItem 수를 반환해야함.
    // 얘 getter 아님
    public int getNumberOfItems() {
        int cnt = 0;
        for (VendingItem[][] vendingItems : shelf) {
            for (VendingItem[] vendingItems2 : vendingItems) {
                for (VendingItem vendingItems3 : vendingItems2) {
                    cnt += (vendingItems3 == null) ? 0 : 1;
                }
            }
        }
        return cnt;
    }

    // 이 메서드는 자동 판매기에있는 모든 VendingItems의 총 합계 값을 반환해야함.
    // 얘 getter 아님
    public double getTotalValue() {
        double values = 0;
        for (VendingItem[][] vendingItems : shelf) {
            for (VendingItem[] vendingItems2 : vendingItems) {
                for (VendingItem vendingItems3 : vendingItems2) {
                    values += (vendingItems3 == null) ? 0 : vendingItems3.getPrice();
                }
            }
        }
        return values;
    }

    // 이 메서드는 luckyChance의 현재 값을 반환
    // 얘 테스트용이라 호출 할 필요 없음
    public int getLuckyChance() {
        return luckyChance;
    }

    // 얜 기본적으로 제공됨 시뮬레이션에 사용할 VendingMachine의 문자열 표현을 반환함
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------" + "------------\n");
        s.append("                            VendaTron 9000                " + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------" + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ", (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------" + "------------\n");
        s.append(String.format("There are %d items with a total " + "value of $%.2f.%n", getNumberOfItems(),
                getTotalValue()));
        s.append(String.format("Total sales across vending machines " + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }

}