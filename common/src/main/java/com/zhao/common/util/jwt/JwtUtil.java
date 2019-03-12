package com.zhao.common.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhao.common.enums.BaseTypeName;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.*;

//@Slf4j
@Deprecated
public class JwtUtil {
    private final static String HS256_TOKEN = "this is a token";

    public static JWTCreator.Builder jwtBuilder(Map<String, Object> claim, String issuer, Date issuedAt, Date expiresAt, Map<String, Object> header, String subject, String... audience) {
        JWTCreator.Builder jwtBuilder = JWT.create();
        //签发者
        if (null != issuer) {
            jwtBuilder.withIssuer(issuer);
        }
        //签发时间
        if (null != issuedAt) {
            jwtBuilder.withIssuedAt(issuedAt);
        }
        //过期时间
        if (null != expiresAt) {
            jwtBuilder.withExpiresAt(expiresAt);
        }
        if (null != audience) {
            jwtBuilder.withAudience(audience);
        }
        if (null != header) {
            jwtBuilder.withHeader(header);
        }
        if (null != subject) {
            jwtBuilder.withSubject(subject);
        }
        if (null != claim) {
            claim.entrySet().stream().forEach(entry -> {

                String typeName = entry.getValue().getClass().getTypeName();

                switch (typeName) {
                    case "java.lang.String":
                        jwtBuilder.withClaim(entry.getKey(), (String) ConvertUtils.convert(entry.getValue(), String.class));
                        break;
                    case "java.lang.Long":
                        jwtBuilder.withClaim(entry.getKey(), (Long) ConvertUtils.convert(entry.getValue(), Long.class));
                        break;
                    case "java.lang.Double":
                        jwtBuilder.withClaim(entry.getKey(), (Double) ConvertUtils.convert(entry.getValue(), Double.class));
                        break;
                    case "java.lang.Integer":
                        jwtBuilder.withClaim(entry.getKey(), (Integer) ConvertUtils.convert(entry.getValue(), Integer.class));
                        break;
                    case "java.lang.Boolean":
                        jwtBuilder.withClaim(entry.getKey(), (Boolean) ConvertUtils.convert(entry.getValue(), Boolean.class));
                        break;
                    case "java.util.Date":
                        jwtBuilder.withClaim(entry.getKey(), (Date) ConvertUtils.convert(entry.getValue(), Date.class));
                        break;
                    case "java.sql.Timestamp":
                        jwtBuilder.withClaim(entry.getKey(), (Timestamp) ConvertUtils.convert(entry.getValue(), Timestamp.class));
                        break;
                    default:

                }

            });
        }

        return jwtBuilder;
    }

    //创建token
    public static String create(Object entry, String issuer, Date issuedAt, Date expiresAt, Map<String, Object> header, String subject, String... audience) {

        Algorithm algorithm = Algorithm.HMAC256(HS256_TOKEN);
        Map<String, Object> entityToMap = null;
        try {
            entityToMap = entityToMap(entry);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jwtBuilder(entityToMap, issuer, issuedAt, expiresAt, header, subject, audience).sign(algorithm);
    }

    public static String create(Object entry, String issuer, Date issuedAt, Date expiresAt, Map<String, Object> header, String subject) {

        return create(entry, issuer, issuedAt, expiresAt, header, subject, null);
    }

    public static String create(Object entry, String issuer, Date issuedAt, Date expiresAt, Map<String, Object> header) {

        return create(entry, issuer, issuedAt, expiresAt, header, null, null);
    }

    public static String create(Object entry, String issuer, Date issuedAt, Date expiresAt) {

        return create(entry, issuer, issuedAt, expiresAt, null, null, null);
    }

    public static String create(Object entry, String issuer, Date issuedAt) {

        return create(entry, issuer, issuedAt, null, null, null, null);
    }

    public static String create(Object entry, String issuer) {

        return create(entry, issuer, null, null, null, null, null);
    }

    public static String create(Object entry) {

        return create(entry, null, null, null, null, null, null);
    }

    //解码token 封装对象
    public static DecodedJWT decode(String token, Class<?> clazz) {

        DecodedJWT jwt = JWT.decode(token);
        return jwt;
    }

    //校验
    public static DecodedJWT verifier(String token) {
        Algorithm algorithm = Algorithm.HMAC256(HS256_TOKEN);
        //判断条件
        JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("username", "zhao456").build();


        //校验失败抛出异常
        DecodedJWT verify = jwtVerifier.verify(token);

        return verify;
    }

    //将数据实体转换为Claim集合
    public static Map<String, Object> entityToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> entityMap = Maps.newHashMap();
        Class clazz = obj.getClass();
        //获取所有不为null的变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (null == field.get(obj)) {
                continue;
            }
            entityMap.put(field.getName(), field.get(obj));

        }
        return entityMap;
    }


    public static void main(String[] args) throws IllegalAccessException {


//        String jwt = create();
//
//        //DecodedJWT decode = JwtUtil.verifier(jwt);
//
//        DecodedJWT decode= decode(jwt,null);
//
//
//        System.out.println(decode.getHeader());
//        System.out.println(new String(Base64.getDecoder().decode(decode.getHeader())));
//        System.out.println(new String(Base64.getDecoder().decode(decode.getPayload())));
//        System.out.println(decode.getPayload());
//        System.out.println(decode.getSignature());
//        System.out.println(decode.getToken());

        String[] a = new String[12];

        System.out.println(a.getClass().getTypeName());

        System.out.println(Integer.TYPE);
        System.out.println(String.class.getName());
        System.out.println(Integer.TYPE);
        System.out.println(Integer.TYPE);
        System.out.println(String.class.getName());
        System.out.println(Character.class.getName());
        System.out.println(Double.class.getName());
        System.out.println(Float.class.getName());
        System.out.println(Long.class.getName());
        System.out.println(Integer.class.getName());
        System.out.println(Short.class.getName());
        System.out.println(Byte.class.getName());
        System.out.println(Boolean.class.getName());
        System.out.println(Date.class.getName());
        System.out.println(Timestamp.class.getName());
        System.out.println(List.class.getTypeName());
    }


}
