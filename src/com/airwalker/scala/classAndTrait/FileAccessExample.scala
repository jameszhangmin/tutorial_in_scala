package com.airwalker.scala.classAndTrait

import scala.io.Source

/**
 * Created by Zhang.Min on 2015/12/28.
 */
object FileAccessExample extends App{

  val file = Source.fromFile("/data/demo.data")
  //按行
  for(line <- file.getLines()) {
    println(line)
  }

  //按字符
  for(c <- file) {
    println(c)
  }

  //从网络,用于写爬虫程序
  val remote_file = Source.fromURL("http://www.baidu.com")
  for(c <- remote_file.getLines()) {
    println(c)
  }

}
