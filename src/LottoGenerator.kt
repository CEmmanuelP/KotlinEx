import java.util.*

class Lotto{
    fun printLottoNumbers(){
        val lotto = getLottoNumberList()

        print(lotto[0])

        for (i in 1..5){
            print(", " + lotto[i])
        }

    }

    fun getLottoNumberList() : List<Int> {
        val numberList = getNumberList()
        var lotto = listOf<Int>()

        Collections.shuffle(numberList)

        lotto = numberList.subList(0, 6)
        Collections.sort(lotto)

        return lotto
    }

    fun getNumberList() : List<Int>{
        val list = mutableListOf<Int>()

        for(i in 1..45){
            list.add(i)
        }

        return list;
    }
}

fun main(args : Array<String>) {
    val lotto = Lotto()

    val sc: Scanner = Scanner(System.`in`)

    val times = sc.nextInt()

    for(i in 1..times) {
        lotto.printLottoNumbers()
        println()
    }
}