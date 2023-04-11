package com.ltp.gradesubmission;

import org.hibernate.service.spi.ServiceException;

import java.util.Optional;

public class TestCase {
    public static void main(String[] args) {

        System.out.println(power(2, 8));
//        steps(5);
//        System.out.println(factorial(5));
    }

    public static int power(int base, int exponent){
        if(exponent < 1){
            return 1;
        }

        int pows = power(base, exponent - 1);
       return base * pows;
    }

    public static int steps(int steps){
        if(steps < 1){
            return 1;
        }

        System.out.println("Walk!");
        return 8 * steps(steps-1);
    }

    public static int factorial(int num){
        if(num == 1){
            return 1;
        }

        return num * factorial(num -1);
    }
}
