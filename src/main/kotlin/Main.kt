package com

fun main() {
    data class saying (
        val id : Int,
        val content : String,
        val author : String
    )

    var lastId = 1
    val lists = mutableListOf<saying>();


    println("== 명언 앱 ==")

    while(true){
        print("명령) ")
        val input = readlnOrNull()!!.trim()
        if (input == "종료") {
            break

        } else if (input=="등록") {
            print("명언 : ")
            val content = readlnOrNull()!!.trim()
            print("작가 : ")
            val author = readlnOrNull()!!.trim()
            println("${lastId}번 명언이 등록되었습니다.")
            lists.add(saying(lastId, content, author))
            lastId++
        }
        else if (input=="목록") {
            println("번호 / 작가 / 명언")
            println("----------------------------")
            for(i in lists.size-1 downTo 0 ){
                println("${lists[i].id} / ${lists[i].author} / ${lists[i].content}")
            }
        }
        else if (input.startsWith("삭제")) {
            val delId = input.substringAfter("id=", "").trim()
            val id = delId.toIntOrNull()

            if (id == null) {
                println("id가 없습니다.")
            } else {
                if(lists.removeIf{it.id==id}) {
                    println("${id}번 명언이 삭제되었습니다.")
                } else {
                    println("${id}번 명언이 없습니다.")
                }
            }
        }
    }
}