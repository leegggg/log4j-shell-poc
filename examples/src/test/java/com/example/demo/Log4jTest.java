package com.example.demo;

import com.sun.jndi.ldap.LdapCtx;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.InitialLdapContext;
import java.util.Hashtable;
import java.util.Properties;

import static java.lang.Math.random;


public class Log4jTest {
    Properties ldapEnv;
    public Log4jTest() {
        ldapEnv = new Properties();
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ldapEnv.put(Context.PROVIDER_URL, "ldap://172.25.64.20:10389/dc=example,dc=com");
    }

    @Test
    public void jndiDns() throws NamingException {
        Properties env = new Properties();
        //设定DNS Service Provider.
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        env.put(Context.PROVIDER_URL, "dns://172.26.0.1");
        DirContext dnsContext = new InitialDirContext(env);
        //设定查询类型, 例如A, MX, AAAA, SRV等.
        final String[] types = new String[]{"A"};
        //返回查询结果, sun.com的DNS A记录.
        Attributes attrs = dnsContext.getAttributes("demo.example.com", types);
        System.out.println(attrs);
    }

    @Test
    public void ldapSerial() throws NamingException {
        // obtain initial directory context using the environment
        DirContext ctx = new InitialDirContext(ldapEnv);
        Integer i = (Integer) ctx.lookup("cn=myRandomInt");
        System.out.println("i is now: " + i);

        // create some random number to add to the directory
        i = (int) (random() * 65536);
        System.out.println("Adding " + i + " to directory...");
        ctx.rebind("cn=myRandomInt", i);

        i = (Integer) ctx.lookup("cn=myRandomInt");
        System.out.println("Retrieved i from directory with value: " + i);
    }

    @Test
    public void jndiLdapUser() throws NamingException {
        // Create the initial context
        Context ctx = new InitialContext(ldapEnv);
        // Check that it is bound
        LdapCtx obj = (LdapCtx) ctx.lookup("cn=users,dc=denver");
        Attributes attrs = obj.getAttributes("uid=wasadmin");
        System.out.println(attrs.get("cn"));
        // Close the context when we're done
        ctx.close();
    }

    @Test
    public void jndiLdapRef() throws NamingException {
        // Create the initial context
        Context ctx = new InitialContext(ldapEnv);
        // Create the object to be bound
        Fruit fruit = new Fruit("lemon");
        // Perform the bind
        ctx.rebind("cn=Favorite Fruit", fruit);
        // Check that it is bound
        Object obj = ctx.lookup("cn=Favorite Fruit");
        System.out.println(obj);
        // Close the context when we're done
        ctx.close();
    }

}