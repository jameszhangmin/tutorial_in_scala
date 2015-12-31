package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/23.
 */






//可堆叠式修改——构造顺序
class Animal {
  println("This is animal")
  def say() { println("Hey") }
}

trait Furry extends Animal {
  println( "Furry.......")
  override def say() { println("FFFFFFFF");super.say()}
}

trait HasLegs extends Animal {
    println("I have legs!!!")
}

trait FourLegged extends HasLegs {
  println("one,two,three,four,I've four!")
  override def say() { println("GGGGGGGGGGG");super.say()}
}

class Cat extends Animal with Furry with FourLegged{
  println("miao~~~")

}




//可堆叠式修改——super的调用顺序
trait Base1 {
  def print() { println("Base1") }
}
trait A extends Base1 {
  override def print() { println("A"); super.print() }
}
trait B extends Base1 {
  override def print() { println("B"); super.print() }
}
class Base2 {
  def print() { println("Base2") }
}
trait Base3 {
  def print() { println("Base3") }
}
class C extends Base2 with Base3 with A with B {
  override def print() { println("C"); super.print() }
}

object TraitExample extends App{

  val cat = new Cat
  cat.say()

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")

  (new C).print

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART3>>>>>>>>>>>>>>>>>>>>>")

  //看一下下面的情况
  class C2 extends Base2
  with A
  with Base3
  with B {
    override def print() { println("C2"); super.print() }
  }

  (new C2).print
}
