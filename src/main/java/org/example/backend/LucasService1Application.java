package org.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LucasService1Application {
    public static void main(String[] args) {
        SpringApplication.run(LucasService1Application.class, args);
    }
    public static List<Integer> LucasSec(int num) {
        List<Integer> lucasNumbers = new ArrayList<>();

        if (num >= 0) lucasNumbers.add(2);
        if (num >= 1) lucasNumbers.add(1);

        int a = 2, b = 1, temp;

        for (int i = 2; i <= num; i++) {
            temp = a + b;
            a = b;
            b = temp;
            lucasNumbers.add(temp);
        }

        return lucasNumbers;
    }

}
