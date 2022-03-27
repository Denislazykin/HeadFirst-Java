package main.java.com.HeadFirst.chapter_9.Detective;

class SimUnit {
    String botType;

    SimUnit(String type) {
        botType = type;
    }

    int powerUse() {
        if ("Тепловая машина".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
