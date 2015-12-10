# dockerjavaexample

This project build a docker which fail in some contexts. <br />
For build:<br />
1) mvn clean install<br />
2) docker build -t dockerjavaexample .<br />
For run docker:<br />
1) docker run -it --rm -p 9090:9090 dockerjavaexample<br />
<br />
For view the problem:<br />
http://localhost:9090/hello<br />

I use Docker 1.9.0 in all cases.

I tested in:
- Ubuntu 14.04 LTS with kernel 3.19.0-33-generic --> FAIL
- Ubuntu 14.04 LTS with kernel 3.13.0 --> OK
- MAC OS X El Capitan --> OK
- Linux debian8 4.2.0-040200-generic #201508301530 SMP Sun Aug 30 19:31:40 UTC 2015 x86_64 GNU/Linux --> OK
- Linux nodo1 4.2.0-0.bpo.1-amd64 #1 SMP Debian 4.2.3-2~bpo8+1 (2015-10-20) x86_64 GNU/Linux --> ERROR

The error is:

[qtp879943720-13] WARN org.eclipse.jetty.server.HttpChannel - //localhost:9090/hello
java.lang.NoSuchMethodError: javax.servlet.http.HttpServletResponse.getHeaders(Ljava/lang/String;)Ljava/util/Collection;
	at spark.utils.GzipUtils.checkAndWrap(GzipUtils.java:64)
	at spark.webserver.MatcherFilter.doFilter(MatcherFilter.java:251)
	at spark.webserver.JettyHandler.doHandle(JettyHandler.java:61)
	at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:189)
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:119)
	at org.eclipse.jetty.server.Server.handle(Server.java:517)
	at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:302)
	at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:242)
	at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:245)
	at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:95)
	at org.eclipse.jetty.io.SelectChannelEndPoint$2.run(SelectChannelEndPoint.java:75)
	at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.produceAndRun(ExecuteProduceConsume.java:213)
	at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.run(ExecuteProduceConsume.java:147)
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:654)
	at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:572)
	at java.lang.Thread.run(Thread.java:745)
[qtp879943720-13] WARN org.eclipse.jetty.server.HttpChannel - //localhost:9090/hello
java.lang.NoSuchMethodError: javax.servlet.http.HttpServletResponse.getHeaders(Ljava/lang/String;)Ljava/util/Collection;
	at spark.utils.GzipUtils.checkAndWrap(GzipUtils.java:64)
	at spark.webserver.MatcherFilter.doFilter(MatcherFilter.java:251)
	at spark.webserver.JettyHandler.doHandle(JettyHandler.java:61)
	at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:189)
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:119)
	at org.eclipse.jetty.server.Server.handle(Server.java:517)
	at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:302)
	at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:242)
	at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:245)
	at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:95)
	at org.eclipse.jetty.io.SelectChannelEndPoint$2.run(SelectChannelEndPoint.java:75)
	at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.produceAndRun(ExecuteProduceConsume.java:213)
	at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.run(ExecuteProduceConsume.java:147)
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:654)
	at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:572)
	at java.lang.Thread.run(Thread.java:745)
