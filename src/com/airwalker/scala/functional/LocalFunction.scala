package com.airwalker.scala.functional

/**
 * Created by Zhang.Min on 2015/12/29.
 */
object LocalFunction extends App {

  //嵌套函数
  def add3(x : Int, y : Int, z : Int) : Int = {
    def add2(x : Int, y : Int) : Int = {
      x + y
    }
    add2(add2(x, y), z)
  }
  println(add3(1,2,3))



  //by-value
  def callByValue(flag : Boolean, onTrue : () => Unit, onFalse : () => Unit) : Unit = {
    println("callByValue start")
      if (flag) onTrue() else onFalse()
    println("callByValue stop")
  }

  callByValue(true, ()=>{println("it's true")}, () => {println("it's false")})
//  callByValue(false,()=>{println("it's true")}, () => {println("it's false")})


  //ba-name
  def callByName(flag : Boolean, onTrue : => Unit, onFalse : => Unit) : Unit = {
    println("callByName start")
      if (flag) onTrue else onFalse
    println("callByName stop")
 }
  callByName(true, println("it's true"), println("it's false"))
}
