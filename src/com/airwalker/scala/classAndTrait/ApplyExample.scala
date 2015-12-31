package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/23.
 */
class ApplyTest{
  println("class ApplyTest initialized...")
  def test {
    println("test")
  }

  //类里面也有apply方法
  def apply() = "APPLY IN CLASS"
}


//包对象
package object bobsdelights{
  def showFruit(fruit : String){
    println("This fruit is " + fruit)
  }
}

object ApplyTest {
  def apply() = new ApplyTest

  def print {
    println("blabla")
  }

  var count = 0
  def incr {
      count  = count +1
  }
}



object ApplyExample extends App {
  //注意 这里的括号表示调用单例对象的apply方法，如果没有括号，仅仅表示引用了这个实例对象
  val a = ApplyTest()

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")

  //这里测试 Class 类里面的apply方法
  val t = new ApplyTest
  println(t())

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART3>>>>>>>>>>>>>>>>>>>>>")

  //这里测试单例
  for (i <- 1 to 10){
    ApplyTest.incr
  }
  println(ApplyTest.count)

  println(">>>>>>>>>>>>>>>>>>>>>>>>PART4>>>>>>>>>>>>>>>>>>>>>")

  import com.airwalker.scala.classAndTrait.bobsdelights
  val packageObj = bobsdelights.showFruit("apple")

}
