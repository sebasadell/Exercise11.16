import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] list = new String[0];
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("names.dat"))){
            list = (String[]) in.readObject();
            System.out.println(Arrays.toString(list));
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name (\"fin\" to finish): ");
        String name = input.next();
        while (!name.equals("fin")){
            String[] aux = new String[list.length + 1];
            for(int i = 0; i < list.length; i++){
                aux[i] = list[i];
            }
            aux[list.length] = name;
            list = aux;
            System.out.println("Enter name (\"fin\" to finish): ");
            name = input.next();
        }
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("names.dat"))){
            out.writeObject(list);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}