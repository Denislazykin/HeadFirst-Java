Организовывайте свой проект таким образом, что бы исходный код и class-файлы не находились в одной директории

Стандартная организационная структура предусматривает создание директории project, внутри которой должны находится каталоги src и classes

Объединение классов в пакет предотвращает конфликты именования с другими классами, если имя пакета будет начинаться с перевернутого домена

Что бы поместить класс в пакет, в самом начале его исходного кода нужно добавить объявление пакета\
package com.siteName;

Что бы быть частью пакета, класс должен находится внутри дерева каталогов, соответствующего структуре пакета. Если взять класс com.wickedlySmart.Foo, он должен храниться в директории wickedlySmart, размещенной внутри каталога com

Что бы ваш скомпилированный класс находился в правильной структуре дерикторий и на уровень ниже каталога classes, используйте при компиляции флаг -d\
cd C:\project\src\
java -d C:\project\src\com\nameSite\ClassName.java

Для запуска своего кода перейдите в директорию classes и укажите полное имя класса\
cd C:\project\out\artifact\
java com.nameSite.ClassName

Вы модете упаковывать свои классы в файл JAR(Java архив), который основан на формате pkzip

Можете слздать исполняемый JAR, поместив внутрь манифест, в котором указан класс с методом main(). Файл манифеста представляет собой обычный текстовый файл с записью, похожей на \
Main-Class: com.siteName.ClassName

Убедитес, что вы не забыли нажать Enter в конце строки выше, иначе он не будет работать

Что бы создать Jar\
jar -cvfm manifest.txt MyJar.jar com

Вся структура каталога пакета(только директории соответствующие пакету) должна находится непосредственно внутри JAR

Что бы запустить исполняемый Java архив \
java -jar MyJar.jar

Технология Java Web Start позволяет вам поставлять пользователю автономное клиентское приложение через Интернет

JWS включает в себя вспомогательное приложение, которое должно быть установлено на клиенте(помимо самого Java)

JWS приложение состоит из двух частей:исполняемого архива JAR и JNLP файла

JNLP файл - обычный документ в формате XML, который описывает ваше JWS приложение. Он содержит теги для указания имени и местонахождения Java-архива, а так же имя класса с методом main()

Когда браузер получает от сервера JNLP файл(после щелчка по ссылке на этот файл), он запускает вспомогательное JWS приложение

Вспомогательное JWS приложение считывает JNLP файл и запрашивает у веб сервера исполняемый JAR

Получив JAR, JWS вызывает из него метод main(), указанный в JNLP файле