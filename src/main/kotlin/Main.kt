fun main(args: Array<String>) {
    while (true) {
        print("Введите номер задачи: ")
        when (readln().toInt()) {
            1 -> task1()
            2 -> task2()
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
    print("Введите сумму предыдущих переводов в этом месяце : ")
    val sumMonth = readln().toFloat()
    print("Введите сумму перевода: ")
    val sum = readln().toFloat()
    print("1.MasterCard\n2.Maestro\n3.Visa\n4.Мир\n5.VK Pay\nВыберите тип карты (номер): ")
    val typeCard = readln().toInt()

    println("Комиссия составит: ${fee(sumMonth,sum,typeCard)} рублей")
    if (fee(sumMonth,sum,typeCard) != "отказ операции")
        println("Итог: ${sum.minus(fee(sumMonth,sum,typeCard).toFloat())} рублей")
}

fun fee(sumMonth:Float, sum:Float, typeCard:Int):String
{
    when(typeCard)
    {
        1,2 -> return if(sumMonth in 300.0..75_000.0) if(sumMonth < 600_000) "0" else "отказ операции" else if(sumMonth < 600_000) (sum*0.006F+20F).toString() else "отказ операции"
        3,4 -> if(sum > 35F) return if(sumMonth <600_000) (sum*0.0075F).toString() else return "отказ операции" else return "отказ операции"
        else -> return if (sumMonth > 40_000F || sum >15_000) "отказ операции" else "0"
    }
}