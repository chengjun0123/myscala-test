package com.dajiangtai.scala

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.api.scala._
/**
  * Created by chengjun on 2020/10/8.
  */
object StreamWordCount {
  def main(args: Array[String]): Unit = {
    val params=ParameterTool.fromArgs(args)
    val host:String=params.get("host")
    val port:Int=params.getInt("port")

    val env = StreamExecutionEnvironment.getExecutionEnvironment
   //val textDataStream = env.socketTextStream("192.168.204.129", 7777)
   val textDataStream = env.socketTextStream(host,port)
    //逐一读取数据 打散之后进行wordCount
    val wordCountDataStream = textDataStream.flatMap(_.split("\\s"))
      .map((_, 1)).keyBy(0).sum(1)
    wordCountDataStream.print().setParallelism(1)
    env.execute("stream word count job")
  }
}
//