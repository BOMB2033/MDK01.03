fun main(args: Array<String>) {
    print("Введите номер задачи: ")
    when(readln().toInt())
    {
        1 -> task1()
        2 -> task2()
        3 -> task3()
    }
}
fun task1()
{
    print("Введите сумму перевода: ")
    val amount = readln().toInt()
    val result:Float = if (amount >= 35) amount * 0.0075f else 0f
    println("Комиссия составит: $result рублей")
    println("Итог: ${amount.minus(result)} рублей")
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