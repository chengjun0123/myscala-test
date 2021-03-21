package com.dajiangtai.scala

/**
  * Created by chengjun on 2020/10/10.
  */
//单例对象实例
import java.io._

import scala.io.Source

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
    println("x=" + x)
    println("y=" + y)
  }
}

//继承的用法
class Location(lx: Int, ly: Int, lz: Int) extends Point(lx, ly) {
  var z = lz;

  def move(mx: Int, my: Int, mz: Int): Unit = {
    x = x + mx
    y = y + my
    z = z + mz
    println("x=" + x)
    println("y=" + y)
    println("z=" + z)
  }

  override def toString: String = {
    x + "," + y + "," + z
  }

}

//伴生对象实例
class Marker private(val color: String) {
  println("创建" + this)

  override def toString: String = "颜色标记：" + color;
}

object Marker {
  private val markers: Map[String, Marker] = Map("red" -> new Marker("red"), "blue" -> new Marker("blue"), "green" -> new Marker("green"))

  def apply(color: String) = {
    if (markers.contains(color)) markers(color) else null
  }

  def getMarker(color: String) = {
    if (markers.contains(color)) markers(color) else null
  }
}

//特征的实例
class Point2(px: Int, py: Int) extends Equal {
  var x: Int = px
  var y: Int = py

  def isEqual(obj: Any) = obj.isInstanceOf[Point2] && obj.asInstanceOf[Point2].x == x
}

//case class
case class Course(name: String, cid: Int)

object testScala {
  def main(args: Array[String]): Unit = {
    //文件的读写操作
    val write=new PrintWriter(new File("D:\\123.txt"))
    write.write("hadoop hello\nhadoop daiangtai\nhadoop dajiangtai2\n")
    write.close()
    Source.fromFile("D:\\123.txt").foreach{ print }
    //科利华操作
    val aa=multiplyBy(9)(500)
    println(aa)
    //val n=aa(500)
    //println(n)




    //unapply的用法
    val x = testScala(9)
    println(x)
    x match {
      case testScala(num) => println(x + "是" + num + "的2次方")
      case _ => println("not matched")

    }
    //异常处理的办法
    excepTest("abc")
    //test("AA")
    //test("")
    //样例的使用
    val hadoop = Course("hadoop", 23)
    val strom = Course("strom", 24)
    val flink = Course("flink", 25)
    for (course <- List(hadoop, strom, flink)) {
      course match {
        case Course("hadoop", 23) => println("yyy")
        case Course("strom", 24) => println("xxx")
        case Course("flink", 25) => println("zzzz")
      }
    }

    //模式匹配
    def matchTest(x: Any): String = x match {
      case 1 => "scala"
      case 2 => "java"
      case y: String => "php"
      case _ => "other"
    }

    println(matchTest(13))

    var p1 = new Point2(2, 3)
    var p2 = new Point2(2, 4)
    var p3 = new Point2(2, 5)
    println(p1.isEqual(p2))


    //val location=new Location(1,2,3)
    //location.move(1,1,1);
    //println(location.toString)

    //单例函数调用 省掉.
    println(Marker("red"))
    println("------------")
    println(Marker.getMarker("blue"))

    val point = new Point(10, 20)
    printPoint

    def printPoint: Unit = {
      println("x的坐标点：" + point.x);
      println("y的坐标点：" + point.y);
    }

    // println("sfsfsf");
    //val ss=3.1514F;
    //println(ss);
  }

  def test(color: String): Unit = {
    //val n=99;
    color match {
      case "AA" => println("AA")
      case "BB" => println("BB")
      case _ => throw new IllegalArgumentException("nothing learn is now")
    }
  }

  def excepTest(num: String): Unit = {
    try {
      Integer.parseInt(num)
    }
    catch {
      case ex: NumberFormatException => println("parameter is not Integer !")
      case ex: IllegalArgumentException => println("parameter is nor ilegal")
    } finally {
      println("exit");
    }
  }

  def apply(x: Double) = {
    x * x
  }

  def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

  //科里化
  def multiplyBy(factor:Double)(x:Double)=factor*x
}
