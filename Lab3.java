import java.util.Arrays;
import java.util.Scanner; 

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack stack = new MyStack();
        boolean running = true;

        while (running) {
            System.out.println("\nҮйлдэлээ сонгоно уу:");
            System.out.println("1 - Стекийн орой дээр элемент нэмэх");
            System.out.println("2 - Стекийн орой дээрээс элемент гаргах");
            System.out.println("3 - Стекийн орой дээр байгаа элементийг харах");
            System.out.println("4 - Стек хоосон эсэхийг шалгах");
            System.out.println("5 - Стекыг массив руу хөрвүүлэх");
            System.out.println("6 - Стекийн элементүүдийг санамсаргүй хольж буцаах (rand)");
            System.out.println("7 - Стекийн давхардсан элементүүдийг арилгах (unique)");
            System.out.println("8 - Олон элемент нэмэх");
            System.out.println("9 - Стекийн элемент байгаа эсэхийг шалгах");
            System.out.println("10 - Стекыг хэвлэх");
            System.out.println("0 - Гарах");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Нэмэх элементыг оруулна уу: ");
                    Object element = scanner.nextLine();
                    stack.push(element);
                    System.out.println("Элемент нэмэгдсэн.");
                    break;
                case 2:
                    if (!stack.empty()) {
                        System.out.println("Стекийн орой дээрээс гаргасан элемент: " + stack.pop());
                    } else {
                        System.out.println("Стек хоосон байна.");
                    }
                    break;
                case 3:
                    if (!stack.empty()) {
                        System.out.println("Стекийн орой дээр байгаа элемент: " + stack.peek());
                    } else {
                        System.out.println("Стек хоосон байна.");
                    }
                    break;
                case 4:
                    System.out.println(stack.empty() ? "Стек хоосон байна." : "Стек хоосон биш байна.");
                    break;
                case 5:
                    Object[] array = stack.toArray();
                    System.out.println("Стек массиваар: " + Arrays.toString(array));
                    break;
                case 6:
                    stack = stack.rand();
                    System.out.println("Стекийн элементүүд санамсаргүй хольсон.");
                    break;
                case 7:
                    stack = stack.Unique();
                    System.out.println("Стекийн давхардсан элементүүд арилгасан.");
                    break;

                case 8:
                    System.out.print("Нэмэх элементүүдийг оруул (таслалаар): ");
                    String[] elements = scanner.nextLine().split(",");
                    Object[] objElements = new Object[elements.length];
                    for (int i = 0; i < elements.length; i++) {
                        objElements[i] = elements[i].trim();
                    }
                    stack = stack.addRange(objElements);
                    System.out.println("Элементүүд стекд нэмэгдсэн.");
                    break;
                case 9:
                    System.out.print("Шалгах элементээ оруулна уу: ");
                    Object checkElement = scanner.nextLine();
                    System.out.println(stack.exists(checkElement) ? "Элемент стекд байна." : "Элемент стекд байхгүй байна.");
                    break;
                case 10:
                    System.out.println("Одоогийн стек: " + stack);
                    break;
                case 0:
                    running = false;
                    System.out.println("Гарах...");
                    break;
                default:
                    System.out.println("Буруу сонголт. Дахин оролдоно уу.");
                    break;
            }
        }

        scanner.close();
    }
}

