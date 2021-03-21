package com.dajiangtai.scala

/**
  * Created by chengjun on 2020/10/6.
  */
class Person(xc: Int, yc: Int) {
  var x: Int = xc;
  var y: Int = yc;

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx;
    y = y + dy;
    print("x 的坐标点是：" + x + "\n");
    print("y的坐标点是：" + y + "\n");

  }
}
