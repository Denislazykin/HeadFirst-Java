Интерфейс - практически на 100% абстрактный класс, он определяет только абстрактные методы

Абстрактный класс - класс, для которого нельзя создать экземпляр

Абстрактный класс нужен для использования в качестве полиморфического аргумента, в виде типа возвращаемого значения или для создания полиморфного массива

Если класс абстрактный, значит, его необходимо расширить. Если же абстрактным является метод, он должен быть переопределен

Реализация абстрактного метода происходит так же, как и переопределение

Абстрактные методы не имеют тела, они существуют только для полиморфизма.Это значит, что первый конкректный класс в дереве наследования должен реализовать все абстрактные методы.

Абстрактный класс может включать как абстрактные, так и не абстрактные методы

Когда мы говорим:"Вы должны реализовать абстрактный метод", это означает, что вы должны дать методу тело. Иными словами, нужно создать неабстрактный метод в классе с такой же сигнатурой метода(именем и аргументами) и возвращаемым типом, совместимым с объявленным возвращаемым типом абстрактного метода

Интерфейс в Java решает проблему множественного наследования, разрешая вам пользоваться преймуществами этого наследования без негативных последствий от Смертоностного ромба смерти

Интерфейсы обходят Ромб смерти - с помощью того, что делают все методы абстрактными

Класс может реализовывать несколько интерфейсов. Класс, реализующий интерфейс, должен реализовывать все его методы, так как все методы интерфейсов неявно считаются публичными и абстрактными

Как узнать, когда нужно создавать класс, подкласс, абстрактный класс или интерфейс: 
* Создавайте класс, который ничего не наследует(кроме Object), когда ваш новый класс не проходит проверку на соответствие другим типам
* Создавайте дочерний класс, только когда вам нужно сделать более специфичную версию родительского класса и заменить или добавить новое поведение 
* Используйте абстрактный класс, когда хотите определить шаблон для группы подклассов и у вас есть хоть какой нибудь код реализации, который смогут применять все подклассы. Делайте класс абстрактным, когда хотите получить гарантию того, что никто не сможет создать объекты данного типа 
* Пользуйтесь интерфейсом, когда хотите определить роль, которую смогут играть другие классы, невзирая на то, где они находятся в иерархии наследования.

Если вы не хотите, что бы создавались экземпляры какого либо класса(то есть кто - то создавал для него объекты), отметьте его ключевым словом abstract

АК может содержать абстрактные и не абстрактные методы

Если класс содержит хотя бы один абстрактный метод, то он дожен быть отмечен как абстрактный

У абстрактного метода нет тела, и его объявление заканчивается точкой с запятой(без фигурных скобок)

Все абстрактные методы должны быть реализованы в первом конкректном подклассе в иерархии наследования

Возвращаемые значения и аргументы методов могут иметь тип Object

Вы можете вызвать методы объекта, только если они присутствуют в классе (или интерфейсе), который использовался в качестве типа ссылки, несмотря на фактический тип объекта.По этой причине ссылочная переменная типа object может применяться только для вызова методов, определенных в классе Object, несмотря на указываемый ссылкой тип объекта

Интерфейс определяет поведение, в общем смысле интерфейс рассказывает о том, как работать с классом, который этот интерфейс реализует, к примеру все двери умеют закрываться и открываться и нам не важно какая это дверь и как она сделана, главное, что это дверь и у неё есть наличие методов для открытия и закрытия. Интерфейс может использоваться классами, которые вообще никак не связаны с друг другом по смыслу (Comparable как пример). И самое важное множественное наследование.

Абстрактный класс определяет поведение и состояние. Абстрактный класс используют для наследования (т.е. мы имеем тесную связь между классами), с помощью него описывают общие черты для наследников. В нем могут находится конкретные (в интерфейсе тоже с java 8) и статические методы.

Ссылочная переменная типа Obj не может присваиваться ссылке другого типа без привидения. Приведение часто прменяется для присвоения ссылки одного типа ссылки, имеющей дочерний тип. Однако во время выполненя программы приведение не сработает, если тип объекта в куче окажется несовместимым с типом приведения \
Например : Dog d = (Dog) x.getObject(aDog)

Все объекты берутся из ArrayList<Object<Object>> как объекты типа Obj(это означает, что на них могут указывать только ссылки этого типа, если вы не станете использовать приведение)

Множественное наследование в Java запрещено из за проблемы связанной с Ромбом Смерти. Это значит, что вы можете наследовать лишь один класс

Создавате интерфейс, используя ключевое слово interface

Реализуйте интерфейс, используя ключевое слово implements

Для вызова родительской версии метода из заменяющего его дочернего класса используйте ключевое слово super
