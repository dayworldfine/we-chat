package cn.chat.server.service.impl;
import cn.chat.server.common.SocketChannelUtil;
import cn.chat.server.service.InetService;
import cn.chat.server.pojo.model.inet.ChannelUserInfo;
import cn.chat.server.pojo.model.inet.ChannelUserReq;
import cn.chat.server.pojo.model.inet.InetServerInfo;
import cn.chat.server.repository.InetRepository;
import cn.chat.server.netty.NettyServer;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
@Service("inetService")
public class InetServiceImpl implements InetService {

    private Logger logger = LoggerFactory.getLogger(InetServiceImpl.class);

    @Value("${netty.ip}")
    private String ip;
    @Value("${netty.port}")
    private int port;

    @Resource
    private NettyServer nettyServer;
    @Resource
    private InetRepository inetRepository;

    @Override
    public InetServerInfo queryNettyServerInfo() {
        InetServerInfo inetServerInfo = new InetServerInfo();
        inetServerInfo.setIp(ip);
        inetServerInfo.setPort(port);
        inetServerInfo.setStatus(nettyServer.channel().isActive());
        return inetServerInfo;
    }

    @Override
    public Long queryChannelUserCount(ChannelUserReq req) {
        return inetRepository.queryChannelUserCount(req);
    }

    @Override
    public List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req) {
        List<ChannelUserInfo> channelUserInfoList = inetRepository.queryChannelUserList(req);
        for (ChannelUserInfo channelUserInfo : channelUserInfoList) {
            Channel channel = SocketChannelUtil.getChannel(channelUserInfo.getUserId());
            if (null == channel || !channel.isActive()) {
                channelUserInfo.setStatus(false);
            } else {
                channelUserInfo.setStatus(true);
            }
        }
        return channelUserInfoList;
    }
}
