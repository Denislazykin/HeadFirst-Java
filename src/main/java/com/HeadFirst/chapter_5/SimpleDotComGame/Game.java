package main.java.com.HeadFirst.chapter_5.SimpleDotComGame;

public class Game {
    public static void main(String[] args) {
        /*
        Создаем переменную, что бы следить
        за количеством ходов пользователя
         */
        int numOfGuesses = 0;
        /*
        Спец класс, который содержит метод для
        према пользовательсткого ввода
         */
        GameHelper helper = new GameHelper();
        /*
        Создаем объект сайт
         */
        SimpleDotCom theDotCom = new SimpleDotCom();
        /*
        Генерируем число для первой ячейки
        и используем его для формирования массива ячеек
         */
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        /*
        Передаем сайту местоположение его ячеек
         */
        theDotCom.setLocationCells(locations);
        /*
        Создаем переменную, что бы проверять в
        цикле, не закончилась ли игра.
         */
        boolean isAlive = true;
        while (isAlive) {
            /*
            Получаем строку вводимую пользователем
             */
            String guess = helper.getUserInput("Введите число");
            /*
            Просим сайт проверить полученные данные:сохраняем
            возвращенный результат в переменную String
             */
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("УБИЛ")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " поптыток(и)");
            }
        }
    }
}
