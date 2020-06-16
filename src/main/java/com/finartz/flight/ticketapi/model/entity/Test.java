package com.finartz.flight.ticketapi.model.entity;

public class Test {

    public static void main(String[] args){
         Integer quota = 165;

         Integer sold = 32;

         Double price = 50.0;

         int sonuc = (quota*10)/100;
         int kalan = sold % sonuc;
         int sonprice=0;

         if (kalan==0) {
             sonprice= (int) (price*1.10);
         }

        System.out.println(sonuc);
        System.out.println(kalan);
        System.out.println(sonprice);
        System.out.println(String.format("%.2f", 4.52135));

    }
}
