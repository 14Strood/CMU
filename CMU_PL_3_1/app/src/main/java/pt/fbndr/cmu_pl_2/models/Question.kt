package pt.fbndr.cmu_pl_2.models

data class Question(
    var id:Int=0,
    var x:Int=0,
    var y:Int=0,
    var solution:Int=0,
    var input:Int=-1,
    var answer:Boolean=false
) {}