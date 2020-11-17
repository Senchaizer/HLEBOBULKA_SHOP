/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Consumer;
import entity.Products;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import tools.savers.Saver;

/**
 *
 * @author user
 */
public class ConsumerManager {
    private Scanner scanner = new Scanner(System.in);
    public Consumer addConsumer() {
        System.out.println("---Добавить покупателя---");
       
        System.out.println("Введите имя покупателя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию покупателя: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Введите количество денег покупателя: ");
        Integer cash = scanner.nextInt();
        scanner.nextLine();
        Consumer consumer = new Consumer(firstName, lastName, cash);
        return consumer;
    }
    public void addConsumerToList(Consumer consumer, List<Consumer> listConsumers){
        listConsumers.add(consumer);
        Saver saver = new Saver();
        saver.saveToFile(listConsumers, "listConsumers");
    } 
    public void printListConsumers(List<Consumer> listConsumers){
        System.out.println("---Список покупателей---");
        for (int i = 0; i < listConsumers.size(); i++) {
            Consumer consumer = listConsumers.get(i);
            
            System.out.printf("%d."+" Имя: "+"%s "+"%s"+" деньги: "+"%s"+"%n"
            ,i+1
            ,consumer.getFirstName()    
            ,consumer.getLastName()
            ,consumer.getCash()
            );

            
        }
    }
    public void buyProduct(List<Consumer> listConsumers, List<Products> listProducts, ProductManager productManager){
        System.out.println("---Купить товар---");
        if(listProducts.size()!=0){
            printListConsumers(listConsumers);
            System.out.println("Выберите номер покупателя: ");
            int consumerNum = scanner.nextInt()-1;
            productManager.printListProducts(listProducts);
            System.out.println("Выберите номер товара: ");
            int productNum = scanner.nextInt()-1;
            if(listConsumers.get(consumerNum).getCash()>=listProducts.get(productNum).getPrice()) {
                System.out.printf("%s "+"%s купил"+" %s  за "+listProducts.get(productNum).getPrice()+"$ %n"
                        , listConsumers.get(consumerNum).getFirstName()
                        , listConsumers.get(consumerNum).getLastName()
                        , listProducts.get(productNum).getName()


                        );
                listConsumers.get(consumerNum).setCash(listConsumers.get(consumerNum).getCash()-listProducts.get(productNum).getPrice());
                Saver saver = new Saver();
                saver.saveToFile(listConsumers, "listConsumers");
                listProducts.get(productNum).setQuantity(listProducts.get(productNum).getQuantity()-1);
                if(listProducts.get(productNum).getQuantity()==0){
                    listProducts.remove(productNum);
                }
                saver.saveToFile(listProducts, "listProducts");

            }else {
                System.out.println("Не достаточно средств");
            }
        }else {
            System.out.println("Нет товара");
        }    
    }
    
}
