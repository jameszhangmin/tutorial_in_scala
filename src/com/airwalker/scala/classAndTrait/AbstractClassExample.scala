package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/17.
 */

//抽象类
abstract class Person3{
  def speak
  //抽象类字段
  val name : String
  var age : Int
}

class Student3 extends Person3 {
  def speak {
    println("speak!!!")
  }
  //实现抽象类字段(赋值)
  val name = "AAA"
  var age = 10
}


//特质
trait Logger{
  def log(msg : String) {
    println("log " + msg)
  }
}

//如果这个是第一个实现特质的类，不能用with，而必须用extends，即不可能没有extends而直接with
class TestLogger extends Logger {
  def test{
    log("xxxx")
  }
}


//特质的继承
trait SuperLogger{
  def log(msg : String)
}
trait SubLogger extends SuperLogger{
  def log(msg : String) {
    println(msg)
  }
}
class ExtendsLogger extends SubLogger {
  def test {
    log("HHHHHH")
  }
}




trait ConsoleLogger{
  def log(msg : String){
    println("save money : " + msg)
  }
}
trait MessageLogger extends ConsoleLogger{
  //注意：覆盖一个有实现的方法（不是抽象方法），这里要override
  override def log(msg : String){
    println("save mony from bank : " + msg)
  }
}
abstract class Account{
  def save
}
class MyAccount extends Account with ConsoleLogger {
  def save{
    log("100")
  }
}

trait PrintLogger extends  Logger {
  override def log(msg : String){
    println("print save money : " + msg)
  }
}


object AbstractClassExample extends App{
  val student3 = new Student3
  student3.speak

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")

  println(student3.name + " : " + student3.age)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART3>>>>>>>>>>>>>>>>>>>>>")

  val t = new TestLogger
  t.test

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART4>>>>>>>>>>>>>>>>>>>>>")

  val el = new ExtendsLogger
  el.test

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART5>>>>>>>>>>>>>>>>>>>>>")

  val acc = new MyAccount
  acc.save

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART6>>>>>>>>>>>>>>>>>>>>>")

  //报错，PrintLogger和ConsoleLogger冲突
//  val acc1 = new MyAccount with PrintLogger
//  acc.save
}
