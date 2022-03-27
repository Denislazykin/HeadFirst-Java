package main.java.com.HeadFirst.chapter_6.DotCom;

import java.util.ArrayList;

/*
Объекты DotCom
Знают имена и местоположения сайтов и умеют
проверить пользовательский ход на попадание
 */
public class DotCom {
    private String name;
    private ArrayList<String> locationCells;

    public void setName(String string) {
        name = string;
    }
    /*
    Сеттер, который обновляет местоположение сайта
    (случайный адрес, представляемый методом placeDotCom
     */
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public String checkYourself(String userInput) {
        String result = "Промах";
        /*
        Если ход пользователя совпал с одним из Элементов АЛ,
        то метод indexOf() вернет его местоположение. Если
        нет, то вернёт -1
         */
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            /*
            Применяем метод remove() из АЛ для удаления элемента
             */
            locationCells.remove(index);
            /*
            Используем метод isEmpty(), что бы проверить, все ли адреса были разгаданы
             */
            if (locationCells.isEmpty()) {
                result = "Убил";
            } else {
                result = "Ранил";
            }
        }
        return result;
    }
}
