fun main(args: Array<String>) {
    while (true) {
        print("Введите номер задачи: ")
        when (readln().toInt()) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
        }
    }
}
fun task1()
{
    print("Сколько секунд прошло: ")
    println("быд(а) ${agoToText(readln().toInt())}")
}
fun agoToText(sec:Int):String
{
    when(sec)
    {
        in 0..60 -> return "только что"
        in 61..3600 -> return when(sec/60){
            1,21,31,41,51 -> "${sec/60} минуту назад"
            2,22,32,42,52,3,23,33,43,53,4,24,34,44,54 -> "${sec/60} минуты назад"
            else -> "${sec/60} минут назад"
        }
        in 3600+1..24*3600 -> return when(sec/3600){
            1,21 -> "${sec/3600} час назад"
            2,22,3,23,4,24 -> "${sec/3600} часа назад"
            else -> "${sec/3600} часов назад"
        }
        in 3600*24+1..3600*24*2 -> return "вчера"
        in 3600*24*2+1..3600*24*3 -> return "позавчера"
        else -> return "давно"
    }
}

fun task2()
{
    print("Введите число: ")
    val string = readln().toCharArray()
    val result = if (string[string.lastIndex] == '1') "человеку" else "людям"
    println("Понравилось ${string.concatToString()} $result")
}
fun task3()
{
    print("Постоянный ли клиент? (Да/Нет): ")
    val str = readln().lowercase()
    val constant = str=="да"
    print("Сумма покупки: ")
    var sum = readln().toFloat()
    var result = when(sum)
    {
        in 0f..1_000f -> sum
        in 1_001f..10_000f -> sum-100f
        else -> sum-sum*0.05f
    }
    result -= if(constant) result*0.01f else 0f
    println("Сумма составит $result")
}