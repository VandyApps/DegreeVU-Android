package edu.vanderbilt.degreevu.service

import android.os.{Looper, Message, Handler}
import android.content.Context

/**
 * A basic Actor that uses Android's messaging framework.
 */
trait HandlerActor extends Handler {

  def !(msg: AnyRef): Unit = {
    Message.obtain(this, 0, msg).sendToTarget()
  }

  def request(msg: AnyRef)(implicit requester: HandlerActor): Unit = {
    this ! (requester, msg)
  }

}

object HandlerActor {

  /**
   * Create a synchronous Handler that runs tasks on the main thread
   */
  def sync(callback: Handler.Callback): HandlerActor = {
    new SyncHandlerActor(callback)
  }

  /**
   * Create an asynchronous Handler that runs tasks on a separate HandlerThread,
   * one whose looper is passed in as parameter.
   */
  def async(looper: Looper,
            callback: Handler.Callback): HandlerActor = {
    new AsyncHandlerActor(looper, callback)
  }

  private class AsyncHandlerActor(looper: Looper,
                                  callback: Handler.Callback)
      extends Handler(looper, callback)
              with HandlerActor

  private class SyncHandlerActor(callback: Handler.Callback)
      extends Handler(callback)
              with HandlerActor

  trait Server extends Handler.Callback {

    def init(ctx: AppService): Unit

    def handleRequest(req: AnyRef): Unit

    def handleTell(tell: AnyRef): Unit

    var requester: HandlerActor = null

    override def handleMessage(msg: Message): Boolean = {
      msg.obj match {
        case AppService.Initialize(ctx) => init(ctx)
        case (r: HandlerActor, req: AnyRef) =>
          requester = r
          handleRequest(req)
        case a: AnyRef => handleTell(a)
      }
      true
    }

  }
  
}