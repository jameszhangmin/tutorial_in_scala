package com.airwalker.scala.basic

/**
 * created by Zhang.Min on 2015/12/14
 */
object Basic {

  //方法定义
  def add(x : Int ,y : Int) : Int = {
    x + y
  }
  //没有返回值
  def add() {
    println("say hello")
  }


  //默认参数
  def sayName(name: String = "Jack") {
    println(name)
  }

  //类似加载配置文件
  def loadConf(conf : String = "default") {
    println(conf)
  }

  //变长参数
  def sum(elems : Int*):Int={
    elems.sum
  }


  def main (args: Array[String]){
    println(add(1,2))

    add()

    sayName("Joe")
    loadConf()
    //带名参数
    //scala允许参数名直接命名的方式调用
    add(y=2,x=1)//注意参数名必须一模一样
    println(sum(1,2,3,4,5,6))//变长调用


    //遍历数组
    val a = Array(1,2,3,4,5,6,7,8)
    for (i <- 0 until a.length) {
      println(a(i))
    }
    //更多使用的场景
    for(ele <- a){
      println(ele)
    }
  }
}
