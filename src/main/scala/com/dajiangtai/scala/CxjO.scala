package com.dajiangtai.scala
import java.awt.color
import java.awt.{Color, Font}
import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.lang._

import org.apache.flink.api.scala._

import scala.collection.mutable;
//import  java.util.{HashMap=>JavaHashMap};
import java.util.{HashMap=>_,_}
import scala.collection.mutable._;



/**
  * Created by chengjun on 2020/10/6.
  */
object CxjO {
  def main(args: Array[String]): Unit = {
    println("test\n");
    //创建一个批处理的执行环节
    val env=ExecutionEnvironment.getExecutionEnvironment
    val inputPath="E:\\IdeaProjects\\test2\\src\\main\\resources\\hello"
    val inputDataSet=env.readTextFile(inputPath)
    //分词之后做count
    val wordCountDataSet=inputDataSet.flatMap(_.split(" "))
      .map((_,1))
      .groupBy(0)
      .sum(1)
    println(wordCountDataSet.collect())

    wordCountDataSet.print()
    println("end")





    /**
    val log1=Iteblog("cwy",12);
    println(log1.age);
    println(log1.name);
    println(log1.hashCode())
    println(log1.toString);
    val log2=Iteblog("cwy",12);
    println(log1.equals(log2));


    val bos=new ByteArrayOutputStream()
    val oos=new ObjectOutputStream(bos);
    oos.writeObject(log1);
    println(bos);


    //1.
    val ss="035";
    println(ss);
    val has=new mutable.HashMap[String,String]();
    has.put("123","sdff");
    //2.
    val per=new Person(10,20)
    val per1=new Person(10,20)
    println(per1.hashCode());
    println(per1.toString());

    println(per.hashCode());
    println(per.toString());
    //3.
    per.move(10,20);

    //4.
    println("sfsdfsf\n");
    val cxj="ssdf";
    println(cxj);
    **/
  }
}
