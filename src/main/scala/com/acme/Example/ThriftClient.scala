package com.acme.Example

import java.net.InetSocketAddress

import com.acme.Example.thriftscala.{Hello, Hello$FinagleClient}
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.thrift.{ThriftClientFramedCodec, ThriftClientRequest}
import com.twitter.finagle.{Service, Thrift}
import org.apache.thrift.protocol.TBinaryProtocol

//object ThriftClient {
//  def main(args: Array[String]) {
//    val client = Thrift.newIface[Hello.FutureIface]("localhost:8081")
//
//    client.hi() onSuccess { response =>
//      println(">> Received response: " + response)
//    }
//  }
//}


object TestRPCClient extends App {
  val service: Service[ThriftClientRequest, Array[Byte]] = ClientBuilder()
    .hosts(new InetSocketAddress("localhost", 8081))
    .codec(ThriftClientFramedCodec())
    .hostConnectionLimit(1)
    .build()

  val client = new Hello$FinagleClient(service, new TBinaryProtocol.Factory())
  val req = "hello world"

  val response = client.hi()

  response onSuccess { res =>
    println("get response: " + res)
  } onFailure { res =>
    println("Oops, failed " + res)
  }
}
