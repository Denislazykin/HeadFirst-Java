package main.java.com.HeadFirst.chapter_9.Detective;

import java.util.ArrayList;

class V2Radiator {
    V2Radiator(ArrayList list) {
        System.out.println("создаем V2 радиатор");
        for (int x = 0; x < 5; x++) {
            list.add(new SimUnit("V2 радиатор"));
        }
    }
}
