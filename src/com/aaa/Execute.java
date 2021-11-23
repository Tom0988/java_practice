package com.aaa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Machine{  // what we want to do in this class :
                // 1.input coin and add to total
                // 2.have some drinks (map<name, cost>)
                // 3.buy drinks, reduce coin by greedy
                // 4.when user input 0, return all the coin and end the program
    int total = 0;
    static int[] coinType = {10, 5, 1};
    Map<String, Integer> drinksName = new HashMap<>();
    void initDrinks(){
        this.drinksName.put("coffee", 20);
        this.drinksName.put("water", 15);
        this.drinksName.put("cola", 25);
    }

    void addDrinks(String name, int cost){ // add drinks
        this.drinksName.put(name, cost);
    }

    void inputCoin(int coin){ // input coin, store into total and print your total
        this.total += coin;
        System.out.println("now your total coin is " + this.total);
    }

    void buyDrinks(String name){
        int cost = this.drinksName.get(name);
        if (this.total >= cost){
            int i = 0;
            while(cost != 0){
                if(cost >= coinType[i]) {
                    cost -= coinType[i];
                    this.total -= coinType[i];
                }
                else{
                    i++;
                }
            }
        }else System.out.println("your maney is not enough...");
    }

    void end(){
        System.out.println("returning your coin: " + this.total);
    }
}

public class Execute {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.initDrinks();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("1: enter coin, 2: buy, 3: exit");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.print("enter your coin: (1, 5, 10)");
                    int coin = sc.nextInt();
                    machine.inputCoin(coin);
                    break;
                case 2:
                    System.out.println(machine.drinksName.entrySet());
                    String name = sc.next();
                    machine.buyDrinks(name);
                    break;
                case 3:
                    machine.end();
                    exit = true;
                    break;
            }
        }
    }
}
