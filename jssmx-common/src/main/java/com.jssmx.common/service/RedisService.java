package com.jssmx.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.function.Function;

@Service
public class RedisService {

    @Autowired(required = false)//如果spring容器中有，就注入，没有就忽略
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<ShardedJedis,T> func){
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return func.apply(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != shardedJedis){
                //关闭，检测连接是否有效，有效则放回连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * 执行set操作
     * @param key
     * @param value
     * @return
     */
    public String set(final String key,final String value){
        return this.execute((ShardedJedis e) -> e.set(key,value));
    }

    /**
     * 执行get操作
     * @param key
     * @return
     */
    public String get(final String key){
        return this.execute((ShardedJedis e) -> e.get(key));
    }

    /**
     * 删除一个key
     * @param key
     * @return
     */
    public Long del(final String key){
        return this.execute((ShardedJedis e) -> e.del(key));
    }

    /**
     * 设置生存时间，单位为秒
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key,final Integer seconds){
        return this.execute((ShardedJedis e) -> e.pexpire(key,seconds));
    }

    /**
     * 设置String类型的值，并且指定生存时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key,final String value,final Integer seconds){
        return this.execute((ShardedJedis e) -> {
           String result = e.set(key,value);
           e.pexpire(key,seconds);
           return result;
        });
    }
}
