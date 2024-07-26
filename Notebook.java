import java.util.*;

public class Notebook {
private String model;
private int ram;
private int hdd;
private String os;
private String color;


public Notebook(String model, int ram, int hdd, String os, String color) {
    this.model = model;
    this.ram = ram;
    this.hdd = hdd;
    this.os = os;
    this.color = color;
}

public static void main(String[] args) {
    Set<Notebook> notebooks = new HashSet<>();
    notebooks.add(new Notebook("Lenovo", 8, 500, "Windows", "Black"));
    notebooks.add(new Notebook("Dell", 16, 1000, "Windows", "Silver"));
    notebooks.add(new Notebook("HP", 8, 500, "Linux", "Black"));
    notebooks.add(new Notebook("Asus", 32, 500, "Windows", "Grey"));

    Map<String, String> filterCriteria = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите цифру, соответствующую необходимому критерию:");
    System.out.println("1 - ОЗУ");
    System.out.println("2 - Объем ЖД");
    System.out.println("3 - Операционная система");
    System.out.println("4 - Цвет");
    int criteria = scanner.nextInt();

    switch (criteria) {
        case 1:
            System.out.println("Введите минимальное значение ОЗУ:");
            int minRam = scanner.nextInt();
            filterCriteria.put("ram", String.valueOf(minRam));
            break;
        case 2:
            System.out.println("Введите минимальное значение объема ЖД:");
            int minHdd = scanner.nextInt();
            filterCriteria.put("hdd", String.valueOf(minHdd));
            break;
        case 3:
            System.out.println("Введите операционную систему:");
            String os = scanner.next();
            filterCriteria.put("os", os);
            break;
        case 4:
            System.out.println("Введите цвет:");
            String color = scanner.next();
            filterCriteria.put("color", color);
            break;
        default:
            System.out.println("Неправильный ввод");
            break;
    }

    filterNotebooks(notebooks, filterCriteria);
}

public static void filterNotebooks(Set<Notebook> notebooks, Map<String, String> filterCriteria) {
    for (Notebook notebook : notebooks) {
        boolean matchesCriteria = true;

        for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "ram":
                    if (notebook.ram < Integer.parseInt(value)) {
                        matchesCriteria = false;
                    }
                    break;
                case "hdd":
                    if (notebook.hdd < Integer.parseInt(value)) {
                        matchesCriteria = false;
                    }
                    break;
                case "os":
                    if (!notebook.os.equalsIgnoreCase(value)) {
                        matchesCriteria = false;
                    }
                    break;
                case "color":
                    if (!notebook.color.equalsIgnoreCase(value)) {
                        matchesCriteria = false;
                    }
                    break;
            }
        }

        if (matchesCriteria) {
            System.out.println("Модель: " + notebook.model + ", ОЗУ: " + notebook.ram + "Гб, Объем ЖД: " + notebook.hdd + "Гб, Операционная система: " + notebook.os + ", Цвет: " + notebook.color);
        }
    }
}
}