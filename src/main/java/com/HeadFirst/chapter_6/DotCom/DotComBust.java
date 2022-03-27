package main.java.com.HeadFirst.chapter_6.DotCom;

import main.java.com.HeadFirst.chapter_5.SimpleDotComGame.GameHelper;

import java.util.*;

/*
Игровой класс
Создает объекты DotCom, получает пользовательский ввод,
играет, пока все сайты не будут потоплены
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    /*
    Сохдаем АЛ только для объектов DotCom
     */
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    /*
    Создаем три объекта DotCom, даем им имена
    и помещаем в АЛ
     */
    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Javarush.ru");
        DotCom two = new DotCom();
        two.setName("google.com");
        DotCom three = new DotCom();
        three.setName("ya.ru");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        /*
        Выводим краткие инструкции для пользователя
         */
        System.out.println("Ваша цель - потопить три сайта");
        System.out.println("Javarush.ru, google.com, ya.ru");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        /*
        Повторяем с каждым объектом DotCom в списке
         */
        for (DotCom dotComSet : dotComsList) {
            /*
            Запрашиваем у вспомогательного объекта адресс сайта
             */
            ArrayList<String> newLocation = helper.placeDotCom(3);
            /*
            Вызываем сетер из объекта DotCom, что бы передать ему местоположение,
            которое только что получили от вспомогательного объекта
             */
            dotComSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        /*
        Повторяем до тех пор, пока список объектов DotCom не станет пустым
         */
        while (!dotComsList.isEmpty()) {
            /*
            Получаем пользовательский ввод
             */
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        /*
        Инкрементируем количество попыток, которые сделал пользователь
         */
        numOfGuesses++;
        /*
        Подразумеваем промах, пока не выяснили обратного
         */
        String result = "Мимо";
        /*
        Повторяем это для всех объектов DotCom в списке
         */
        for (DotCom dotComToTest : dotComsList) {
            /*
            Просим DotCom проверить ход пользователя, ищем попадание(или потопление)
             */
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Ранил")) {
                /*
                Выбираемся из цикла раньше времени, нет смысла проверять другие сайты
                 */
                break;
            }
            if (result.equals("Убил")) {
                dotComsList.remove(dotComToTest);
                /*
                Ему пришел конец, так что удаляем его из списка сайтов
                и выходим из цикла
                 */
                break;
            }
        }
        /*
        Выводим для пользователя результат
         */
        System.out.println(result);
    }
    /*
    Выводим сообщение о том, как прошла игра
     */
    private void finishGame() {
        System.out.println("Все сайты ушли ко дну!Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у Вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        /*
        Создаем игровой объект
         */
        DotComBust game = new DotComBust();
        /*
        Говорим игровому объекта подготовить игру
         */
        game.setUpGame();
        /*
        Говорим игровому объекту начать главный игровой цикл
         */
        game.startPlaying();
    }
}
