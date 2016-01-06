package com.airwalker.scala.advanced

import java.io.File

import scala.io.Source

/**
 * Created by Zhang.Min on 2016/1/6.
 */

class RichFile(val file : File){
  def read = Source.fromFile(file.getPath).mkString
}
object Context {
  implicit def file2RichFile(f : File) = new RichFile(f)
}


object ImplicitExample extends App{
  /**
   * 1. 先定义一个类RichFile，有些特别的方法read
   * 2. 当new一个普通File类的时候发现没有read方法
   * 3. 只要有line19的存在，scala就会在Context的这个作用域去找有没有RichFile，一旦发现的时候就会调用RichFile的这个read方法
   * 4. 使用的时候先把隐式转换所在的类引进来，这样就不会影响到其他的地方
   * */
  import Context._ //注释掉import之后看看还有read方法没？
  new File("XXX").read
}
