Исключение - объект типа Exception(как вы помните из главы о полиморфизме, это может быть экземпляр класса, находящийся в иерархии наследования ниже Exception)

Исключения выбрасываются явно оператором throw

Исключения выбрасываются вызванным методом или конструктором(не проверяемые или явно объявленные)

Исключения выбрасываются виртуальной машиной(только непроверяемые)

Непроверяемые исключения свидетельствуют о серьезной проблеме в нашей виртуальной машине, либо о серьезной проблеме в нашей программе.

Проверяемые исключения - это те которые свидетельствуют о наличии проблемы во внешнем взаимодействии.

Обработка исключенией позволяет нам разграничивать код на код, который должен выполняться при обычном протекании программы и код, который должен выполняться при выбросе исключений

Несколько catch блоков могут следовать за try блоком, но лишь 1 finally блок может следовать за catch блоками

Одновременно вы можете использовать все 3 типа блоков или по 2: try блок с catch блоком; try блок с finally блоком.По отдельности блоки использовать невозможно.

Последовательность блоков всегда должна соответствовать следующему порядку: try->catch->finally

Finally блок выполняется вне зависимости от того выбросилось исключение или нет

Сабклассы RunTimeException = unchecked exceptions

Runtime исключение бывают в коде, в котором присутствуют ошибочные выражения, т.е. в выбросе данных исключений вивоват программист. Компилятор не в состоянии проверить возможность выброса runtime исключений

Runtime исключения можно не объявлять и не обрабатывать, но при желании можно сделать и то и другое

Саб классы Exception = checked exceptions

Проверяемые исключения указывают на часть кода, который находится за пределами непосредственного контроля программой и который может являться причиной выброса исключений. Они как правило возникают при взаимодействии вашей программы с внешними источниками(работа с файлами, БД, сетью), из за которых и могут возникать проблемы. Компилятор всегда проверяет возможность выброса проверяемых исключений

Проверяемые исключения всегда должны быть или объявленны или обработанны

Если метод А использует внутри себя метод Б, который может выбросить проверяемое исключение, то метод А должен:\
1)Или заключить вызов метода Б в try/catch блоки \
2)Или объявить, что он тоже может выбросить это проверяемое исключение или его супер класс

Error - это очень серьезные ошибки, которые не могут быть напрямую контролированны вашей программой

Error-ы могут быть объявлены, но объявлять их считается глупой практикой. Некоторые errors могут быть обработаны, но это тоже будет очень глупой затеей. Errors, как и runtime исключения считаются непроверяемыми

Очередность catch блоков важна. Компилятор не пропустит код, если исключение родительского класса будет стоять перед исключением дочернего класса

Если в части кода, которая не находится в блоке try и или в блоке try выбрасывается исключение, то соответствующая оставшаяся часть кода уже не обрабатывается

После выброса исключения мы можем увидеть стэк трейс для всех методов, задействованых в выбросе этого исключения

При создании объекта исключения вы можете воспользоваться его конструктором, который принимает String параметр и вписать в него необходимую информацию. Вы так же можете воспользоваться конструктором, который не принимает параметры

catch(Exception e) {\
System.out.println(e); <-выводит на экран тип исключения и сообщение \
System.out.println(e.getMessage()); <-выводит на экран сообщение \
e.printStackTrace(); <-выводит на экран стек трейс

Finally блок выполняется даже в том случае, если в блоке try или catch имеется return

Finally блок не выполнится только в том случае, если вы прекращаете работу программы с помощью System.exit в try блоке или catch блоке или же, если происходит крушение JVM

Если return имеется и в catch блоке, и в finally блоке, то оутпутом метода будет возвращаемое значение из finally блока

Если return в catch блоке возвращает примитив, то в finally блоке вы его изменить не сможете. Если return в catch блоке возвращает ссылочную переменную, то в finally блоке вы его сможете изменить

Исключение может быть перевыброшенно. Это обычно делают тогда, когда код вашего текущего метода обработал данное исключение не полностью и выбрасывает его вновь, что бы метод, который будет вызывать текущий метод завершил обработку данного исключения

При написании кода, вы можете использовать вложенные блоки try, catch, finally

Если исключение выбрасывается из catch блока, то оно не может быть обработано одноуровневым catch блоком

При написании кода, вы можете создавать свои собственные исключения. В зависимости от необходимости, создавайте исключения, которые наследуются от классов Exception или RunTimeException

Один метод поймает то, что выбросил другой.Исключение всегда выбрасывается обратно в вызывающий код.Метод, который может выбросить исключение, должен об этом объявить

Если при выполнении программы что то пошло не так, метод может выбросить исключение

