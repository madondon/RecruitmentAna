package com.example.scala.cn.itcast.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def count(){
    //1.创建SparkContext
    val conf=new SparkConf().setMaster("local[6]").setAppName("word_count")
    val sc=new SparkContext(conf)
    //2.加载文件
    val rdd1=sc.textFile("dataset/wordcount.txt")
    //3.处理
//把一句话分为多个单词
    val rdd2=rdd1.flatMap(item => item.split(" "))
//把每个单词指定一个词频
    val rdd3=rdd2.map(item => (item,1))
//聚合    curr：当前值 agg：局部结果
    val rdd4=rdd3.reduceByKey((curr,agg)=>curr+agg)
    //4.得到结果
    val result=rdd4.collect()
    result.foreach(item =>println(item ))
  }
}
