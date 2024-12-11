import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyChain chn = new MyChain();
        boolean running = true;

        while (running) {
            System.out.println("\nҮйлдэлээ сонгоно уу:");
            System.out.println("1 - Жагсаалтанд элемент нэмэх");
            System.out.println("2 - Жагсаалтыг массив руу хөрвүүлэх");
            System.out.println("3 - Олон элемент нэмэх таслалаар");
            System.out.println("4 - Өөр нэг жагсаалт үүсгэж нэгдүүлэн хэвлэнэ");
            System.out.println("5 - давхардсан элементүүдийг арилгах ");
            System.out.println("6 - Жагсаалтыг хэвлэх");
            System.out.println("0 - Гарах");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Нэмэх элементыг оруулна уу: ");
                    int element = scanner.nextInt();
                    chn.add(chn.size(), element);
                    System.out.println("Элемент нэмэгдсэн.");
                    break;
                case 2:
                    Object[] array = chn.toArray();
                    System.out.println("Жагсаалт массиваар:");
                    for (Object obj : array) {
                        System.out.print(obj + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Нэмэх элементээ оруул (таслалаар): ");
                    String[] inputElements = scanner.nextLine().split(",");
                    Object[] elements = new Object[inputElements.length];
                    for (int i = 0; i < inputElements.length; i++) {
                        elements[i] = Integer.parseInt(inputElements[i].trim());
                    }
                    chn.addRange(elements);
                    System.out.println("Элементүүд нэмэгдсэн.");
                    break;
                case 4:
                    MyChain unionChain = new MyChain();
                    System.out.print("Өөр жагсаалтанд нэмэх элементээ оруулна уу (таслалаар): ");
                    String[] unionElements = scanner.nextLine().split(",");
                    for (String elem : unionElements) {
                        unionChain.add(unionChain.size(), Integer.parseInt(elem.trim()));
                    }
                    MyChain unionResult = chn.union(unionChain);
                    System.out.println("Нэгдсэн жагсаалт: " + unionResult);
                    break;
                case 5:
                    MyChain intersectionChain = new MyChain();
                    System.out.print("Өөр жагсаалтанд нэмэх элементээ оруулна уу (таслалаар): ");
                    String[] intersectionElements = scanner.nextLine().split(",");
                    for (String elem : intersectionElements) {
                        intersectionChain.add(intersectionChain.size(), Integer.parseInt(elem.trim()));
                    }
                    MyChain intersectionResult = chn.intersectMethod1(intersectionChain);
                    System.out.println("Давхардсан элемент: " + intersectionResult);
                    break;
                case 6:
                    System.out.println("Жагсаалт: " + chn);
                    break;
                case 0:
                    running = false;
                    System.out.println("Баяртай");
                    break;
                default:
                    System.out.println("Тийм сонголт алга");
                    break;
            }
        }

        scanner.close();
    }
}
