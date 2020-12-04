package com.sam.anteass.common.auth;

import com.alibaba.fastjson.JSON;
import com.sam.anteass.common.entity.sys.SysUser;
import com.sam.anteass.common.pojo.sys.SysUserRedis;
import com.sam.anteass.common.utils.AnteassConstant;
import com.sam.anteass.common.utils.AnteassPassword;
import com.sam.anteass.common.utils.AnteassString;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Set;

@Service
public class AnteassAuth {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    // 生成token
    // 规则 => id + type + random
    public String buildToken(Long id, String type) {
        return String.format("%s-%s-%s", AnteassPassword.encry(type), AnteassPassword.encry(id.toString()), AnteassString.get6RandomChar());
    }

    // 从redis获取用户信息
    public SysUserRedis getSysUserRedis(HttpServletRequest request) {
        return getSysUserRedis(getTokenFromRequest(request));
    }

    // 从redis获取用户信息
    public SysUserRedis getSysUserRedis(String token) {
        return JSON.parseObject(stringRedisTemplate.opsForValue().get(token), SysUserRedis.class);
    }

    public Long getUserId(String token) {
        SysUserRedis sysUserRedis = this.getSysUserRedis(token);
        return sysUserRedis == null ? null : sysUserRedis.getUserId();
    }

    // 构建并保存到Redis
    public void build2RedisOnlyUserId(String token, SysUser sysUser) {
        this.save2Redis(token, this.buildSysUserRedisOnlyUserId(sysUser));
    }

    // 更新Redis内容
    public void build2Redis(String token, SysUserRedis sysUserRedis) {
        this.save2Redis(token, sysUserRedis);
    }

    // 删除token
    public void removeToken(SysUser sysUser, String type) {
        this.removeByPrefix(this.getTokenPrefix(sysUser.getId(), type));
    }

    public void removeToken(HttpServletRequest request) {
        removeToken(getTokenFromRequest(request));
    }

    // 通过token删除记录
    public void removeToken(String token) {
        stringRedisTemplate.delete(token);
    }

    // 构建SysUserRedis
    // 只有userId,用户登录时用
    private SysUserRedis buildSysUserRedisOnlyUserId(SysUser sysUser) {
        SysUserRedis sysUserRedis = new SysUserRedis();
        sysUserRedis.setUserId(sysUser.getId());
        return sysUserRedis;
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader("token");
    }

    // 获取token前缀
    private String getTokenPrefix(Long id, String type) {
        return String.format("%s-%s", AnteassPassword.encry(type), AnteassPassword.encry(id.toString()));
    }

    // 通过key前缀删除记录
    private void removeByPrefix(String prefix) {
        Set<String> keys = stringRedisTemplate.keys(prefix + "*");
        stringRedisTemplate.delete(keys);
    }

    // 存到redis，有效期2天
    private void save2Redis(String token, SysUserRedis sysUserRedis) {
        stringRedisTemplate.opsForValue().set(token, JSON.toJSONString(sysUserRedis));
        stringRedisTemplate.expire(token, Duration.ofSeconds(AnteassConstant.TOKEN_EXPIRE));
    }

}
