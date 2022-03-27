package main.java.com.HeadFirst.chapter_9.Detective;

import java.util.ArrayList;

class V3Radiator extends V2Radiator {
    V3Radiator(ArrayList list) {
        super(list);
        for (int g = 0; g < 10; g++) {
            list.add(new SimUnit("V3 радиатор"));
        }
    }
}
