package com.tw.pratice;

import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhaochuxin on 15/12/26.
 */

public class MyRandom {
    public static void main(String[] args) {

        MyRandom randomgame = new MyRandom();
        System.out.println("请输入：");
        randomgame.play();
    }
    public void play(){
        int round = 0;
        Scanner scanner = new Scanner(System.in);
        String generatorNumber =test();
        while (round<6){
            String inputNumber;
            inputNumber = scanner.next().toString();
            String result = compare(inputNumber,generatorNumber);
            if (result.equals("4A0B")){
                System.out.println("you win!");
                return;
            }else {
                System.out.println(result);
            }
            round ++;
        }
        System.out.println("Game Over! the answer is"+ generatorNumber);

    }
    public static String test()
    {
         int generatenum = 0;
        for(int i = 0; i < 4; i++)
        {
            generatenum=(int)(Math.random()*9000+1000);
        }
       //System.out.println("generatenum:"+generatenum);
      ;

        return String.valueOf(generatenum);
//    return  "1234";
    }
    public String compare(String inputNumber, String generateNumber)
    {
        int A = 0;
        int B = 0;
        for (int i = 0; i < 4 ; i++) {
            String input = inputNumber.substring(i,i+1);
            String generate = generateNumber.substring(i,i+1);
            if (input.equals(generate)){
                A++;
            }else {
                if (generateNumber.contains(input)){
                    B++;
                }
            }

        }
        return A+"A"+B+"B";
    }
}

