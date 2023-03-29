package HW6;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus A1", "Black", 8, 256);
        Notebook notebook2 = new Notebook("Samsung S1", "white", 16, 512, "Windows");
        Notebook notebook3 = new Notebook("Acer Ac1", "white", 16, 256, "Windows");
        Notebook notebook4 = new Notebook("Samsung S2", "black", 8, 512);
        Notebook notebook5 = new Notebook("Samsung S3", "white", 16, 1024, "Linux");
        Notebook notebook6 = new Notebook("Samsung S4", "black", 16, 1024, "Linux");
        Notebook notebook7 = new Notebook("Apple Ap1", "white", 16, 512, "MacOS");
        Notebook notebook8 = new Notebook("Apple Ap2", "black", 16, 512, "MacOS");
        Notebook notebook9 = new Notebook("Apple Ap3", "black", 16, 512, "MacOS");
        Notebook notebook10 = new Notebook("Acer Ac2", "black", 8, 256, "Windows");
        stock.put(1, notebook1);
        stock.put(2, notebook2);
        stock.put(3, notebook3);
        stock.put(4, notebook4);
        stock.put(5, notebook5);
        stock.put(6, notebook6);
        stock.put(7, notebook7);
        stock.put(8, notebook8);
        stock.put(9, notebook9);
        stock.put(10, notebook10);
        isOn();
    }

    public static HashMap<String, String> filter = new HashMap<>();
    public static TreeMap<Integer, Notebook> stock = new TreeMap<>();

    public static void isOn() {
        while (true) {
            if (filter.size() == 4) {
                getSuitable();
                break;
            }
            mainMenu();
            resume(button());
        }
    }
    public static void greeting(){
        System.out.println("Вас приветствует сток-каталог ноутбуков!");
    }

    public static void mainMenu() {
        System.out.println("Пожалуйста, выберите интересующий вас параметр: \n" +
                " 1: Операционная система \n" +
                " 2: Цвет \n" +
                " 3: Оперативная память \n" +
                " 4: Жесткий диск");

    }

    public static int button() {
        Scanner sc = new Scanner(System.in);
        int button = sc.nextInt();
        return button;
    }

    public static void resume(int button) {
        switch (button) {
            case (1):
                System.out.println("Укажите интересующую вас ОС (Windows, Linux, MacOS, None)");
                setFilter("OS", userInput().toLowerCase());
                break;
            case (2):
                System.out.println("Укажите интересующий вас цвет (black, white)");
                setFilter("Color", userInput().toLowerCase());
                break;
            case (3):
                System.out.println("Укажите интересюущий вас размер оперативной памяти (8,16)");
                setFilter("RAM", userInput());
                break;
            case (4):
                System.out.println("Укажите интересующий вас размер памяти (256, 512, 1024)");
                setFilter("HDD", userInput());
                break;
            case (5):
                getSuitable();
                break;
        }
    }

    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void setFilter(String Parameter, String userValue) {
        filter.put(Parameter, userValue);
    }

    public static void getSuitable() {
        LinkedList<String> suitable = new LinkedList<>();
        for (Map.Entry<Integer, Notebook> entry : stock.entrySet()) {
            Notebook value = entry.getValue();
            if (filter.get("OS").equals(value.getOs()) && (filter.get("Color").equals(value.getColor()) &&
                    (Integer.parseInt(filter.get("RAM")) <= value.getRam()) &&
                    (Integer.parseInt(filter.get("HDD")) <= value.getHdd()))) {
                suitable.add(value.getModel());
            }
        }
        System.out.println("Подходящие вам модели: ");
        for (String str : suitable) {
            System.out.println(str);
        }
        System.out.println("Спасибо, что пользуетесь нашим сервисом!");
    }
}
