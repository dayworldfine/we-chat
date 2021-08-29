package cn.chat.client;

import cn.chat.agreement.protocol.login.ReconnectRequest;
import cn.chat.client.netty.model.ActionBuilder;
import cn.chat.client.event.ChatEvent;
import cn.chat.client.event.LoginEvent;
import cn.chat.client.util.CacheUtil;
import cn.chat.client.netty.NettyClient;
import cn.chat.ui.view.chat.ChatController;
import cn.chat.ui.view.chat.IChatMethod;
import cn.chat.ui.view.login.ILoginMethod;
import cn.chat.ui.view.login.LoginController;
import io.netty.channel.Channel;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @ClassName：Application
 * @Description: 启动类
 * @Author：13738700108
 * @Data 2021/8/7 13:30
 * @Version: v1.0
 **/
public class ClientApplication extends javafx.application.Application{

    private Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    //默认线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. 启动窗口
        IChatMethod chat = new ChatController(new ChatEvent());
        ILoginMethod login = new LoginController(new LoginEvent(), chat);
        login.doShow();

        ActionBuilder actionBuilder = new ActionBuilder();
        actionBuilder.setChat(chat);
        actionBuilder.setLogin(login);

        // 2. 启动socket连接
        logger.info("NettyClient连接服务开始 inetHost：{} inetPort：{}", "127.0.0.1", 7397);
        NettyClient nettyClient = new NettyClient(actionBuilder);
        Future<Channel> future = executorService.submit(nettyClient);
        Channel channel = future.get();
        if (null == channel) {
            throw new RuntimeException("netty client start error channel is null");
        }

        while (!nettyClient.isActive()) {
            logger.info("NettyClient启动服务 ...");
            Thread.sleep(500);
        }
        logger.info("NettyClient连接服务完成 {}", channel.localAddress());

        // Channel状态定时巡检；3秒后每5秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            while (!nettyClient.isActive()) {
                System.out.println("通信管道巡检：通信管道状态 " + nettyClient.isActive());
                try {
                    System.out.println("通信管道巡检：断线重连[Begin]");
                    Channel freshChannel = executorService.submit(nettyClient).get();
                    if (null == CacheUtil.userId) {
                        continue;
                    }
                    freshChannel.writeAndFlush(new ReconnectRequest(CacheUtil.userId));
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("通信管道巡检：断线重连[Error]");
                }
            }
        }, 3, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
