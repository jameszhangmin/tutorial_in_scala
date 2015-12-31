package com.airwalker.scala.advanced

/**
 * Created by Zhang.Min on 2015/12/31.
 */

class Pair[T <: Comparable[T]](val first : T, val second : T){      //class Pair[T](val first : T, val second : T){
  def smaller = if (first.compareTo(second) < 0) first else second  //这个first真的有compareTo方法吗？
                                                                    // 我们知道只有继承了Comparable接口的类才有这个方法
}



object Bounds extends App{
  val p = new Pair("A", "B")
  println(p.smaller)

  val p1 = new Pair(1, 2) //这里会NG 想想为什么
  print(p1.smaller)
}