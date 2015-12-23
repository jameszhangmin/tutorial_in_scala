package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/16.
 */

//类
class Person{
  var name : String = _
  val age = 10
  //private关键字
  private[this] val gender = "male"
}

//构造函数

//1 主构造器直接跟在类名后面，主构造器中的参数，最后会被编译成字段
//2 主构造器执行的时候会执行类中所有语句
//>>>>>>演示： 把主构造器参数name前的val去掉
//3 架设参数声明时，不带val或var，那么该参数相当于private[this]
class Person1(val name : String, val age : Int){
  println("this is the primary constructor!")
}

//辅助构造器

//辅助构造器可以不带val var
//1、辅助构造器名称为this
//2、每一个辅助构造器必须首先调用已经存在的辅助构造器或主构造器
class Person2(var name : String, val age : Int){
  println("this is the primary constructor!")
  var gender : String = _
  val city = "Beijing"
  def this(name : String, age : Int, gender : String){
    this(name,age)
    this.gender = gender
  }
}


//继承

//如果父类有这个字段了，直接写就行了，不要val var,同时自己特有的字段要有val或者var
//extends后面跟上父类的构造器（主/辅助）
class Student(name : String, age : Int,val major : String) extends Person2(name, age) {
  override val city = "Shanghai"
  println("this is the sub-class of Person2, major is " + major)

//  override def toString = {
//    "Override toString()..."
//  }
}

object Example {
  def main(args: Array[String]) {
    val p = new Person
    p.name = "Jack"
    println(p.name + " : " + p.age)
    // 以下无法编译通过
    //println(p.name + " : " + p.gender)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")

    val p1 = new Person1("Jack1",20)
    println(p1.name + " : " + p1.age)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART3>>>>>>>>>>>>>>>>>>>>>")

    val p2 = new Person2("Jack2",20,"male")
    println(p2.name + " : " + p2.gender)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART4>>>>>>>>>>>>>>>>>>>>>")

    val s = new Student("Jay",10, "Math")

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART5>>>>>>>>>>>>>>>>>>>>>")
    println(s.toString)

  }

}
