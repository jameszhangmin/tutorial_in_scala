package com.airwalker.scala.advanced

/**
 * Created by Zhang.Min on 2015/12/31.
 */

class Pair[T <: Comparable[T]](val first : T, val second : T){      //class Pair[T](val first : T, val second : T){
  def smaller = if (first.compareTo(second) < 0) first else second  //这个first真的有compareTo方法吗？
                                                                    // 我们知道只有继承了Comparable接口的类才有这个方法
}


//演示上限和下限的另一个例子
class Pair1[T](val first : T, val second : T){
  def replaceFirst(newFirst : T) = new Pair1[T](newFirst,second)
}

//再复杂点
class PersonPair(val name : String)//{override def toString = s"name : $name"}

class StudentPair(name : String) extends PersonPair(name)// {override def toString = s"name : $name"}

//我们现在要用Person来替换Student
class Pair2[SUB](val first : SUB, val second : SUB){
  def replaceFirst[SUPER >: SUB](newFirst : SUPER) = new Pair2(newFirst,second)
  override def toString = {"first : " + first + " second : " + second}
}

//这里我们利用 <% 对传入的类型做了视图界定
//其中涉及到scala的Int“隐式转换”成RichInt，RichInt有compareTo接口
//可见view bounds比upper bounds更牛逼
class IntPair[T <% Comparable[T]](val first : T, val second : T){
  def smaller = if (first.compareTo(second) < 0) first else second
}


object Bounds extends App{
  val p = new Pair("A", "B")
  println(p.smaller)

//  val p1 = new Pair(1, 2) //这里会NG 想想为什么
//  print(p1.smaller)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")


  val p1 = new Pair1("Apple","Orange")
  println(p1.replaceFirst("banana").first)


  println(">>>>>>>>>>>>>>>>>>>>>>>>PART3>>>>>>>>>>>>>>>>>>>>>")

  val s1 = new StudentPair("A2")
  val s2 = new StudentPair("B2")

  val pair2 = new Pair2(s1,s2) //Pair2[StudentPair,StudentPair]

  val p2 = new PersonPair("AA")

  print(pair2.replaceFirst(p2))

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART4>>>>>>>>>>>>>>>>>>>>>")

  val p3 = new IntPair(1, 2) //视图界定
  println(p3.smaller)
  println(new IntPair("AA","BB").smaller)//String当然也没问题
}