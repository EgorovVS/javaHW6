package HW6;

import java.util.Locale;

public class Notebook {
    String name;
    String os;
    String color;
    int ram;
    int hdd;
    {
        this.os = "None";
    }

    public Notebook(String name, String color, int ram, int hdd){
        this.name = name;
        this.color = color;
        this.ram = ram;
        this.hdd = hdd;
    }
    public Notebook(String name, String color, int ram, int hdd,String os){
        this.name = name;
        this.color = color.toLowerCase();
        this.ram = ram;
        this.hdd = hdd;
        this.os = os.toLowerCase();
    }

    public String getOs() {
        return os;
    }

    public String getModel(){
        return String.format("%s %d GB RAM %s GB (%s)",name,ram,hdd,color);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }
}
