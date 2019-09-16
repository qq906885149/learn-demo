package com.jedis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @Auther : ChenZhongChuang
 * @Date : 2019/9/16 2:10 PM
 * @Descoription :
 */
public class JedisConfig {
    Jedis buildJedis(){
        String host="116.62.199.204";
        int port=6379;
        int timeout=0;
        String password="Lottery-BASE";
        int db=1;
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(),host,port,timeout,password,db);
        return jedisPool.getResource();

    }
      public static void main(String[] args){
          JedisConfig jedisConfig = new JedisConfig();
          Set<String> keys = jedisConfig.buildJedis().keys("*");

          System.out.println(keys);
      }
}
