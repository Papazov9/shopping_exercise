package Encapsulation.Shopping;

import Encapsulation.Shopping.Person;
import Encapsulation.Shopping.Product;
import Encapsulation.farm.Chicken;
import Encapsulation.maths.Box;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInput = scanner.nextLine().split(";");
        String[] productInput = scanner.nextLine().split(";");

        LinkedHashMap<String, Person> peopleMap = new LinkedHashMap<>();
        LinkedHashMap<String, Product> productsMap = new LinkedHashMap<>();

        for (int i = 0; i < personInput.length; i++) {
            String name = personInput[i].split("=")[0];
            double money = Double.parseDouble(personInput[i].split("=")[1]);
            Person currentPerson = new Person(name, money);
            peopleMap.putIfAbsent(name, currentPerson);
        }

        for (int i = 0; i < productInput.length; i++) {
            String name = productInput[i].split("=")[0];
            double cost = Double.parseDouble(productInput[i].split("=")[1]);
            Product currentProduct = new Product(name, cost);
            productsMap.putIfAbsent(name, currentProduct);
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String person = command.split("\\s+")[0];
            String product = command.split("\\s+")[1];

            Person buyer = peopleMap.get(person);
            Product productToBuy = productsMap.get(product);

            buyer.buyProduct(productToBuy);

            command = scanner.nextLine();
        }

        peopleMap.entrySet().forEach(p -> {
            if (p.getValue().getProducts().isEmpty()) {
                System.out.printf("%s – Nothing bought%n",p.getKey());
            }else {
                System.out.println(p.getKey()+" - "+p.getValue().getProducts().toString().replaceAll("[\\[\\]]",""));
            }
        });

    }
}
