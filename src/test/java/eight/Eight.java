package eight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.util.Eval;
import groovy.util.GroovyScriptEngine;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Eight {

  private final List<Integer> list = new ArrayList<Integer>();

  @Before
  public void init() {
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
  }

  //minus: no cashing
  @Test
  public void evalTest() {
    assertSame(Eval.me("3**3"), 27);
    assertSame(Eval.me("list", list, "list.find{it > 3}"), 4);
  }

  @Test
  public void groovyShellTest() {
    final GroovyShell shell = new GroovyShell();
    final Object sumResult = shell.evaluate("3 + 5");
    final List listFromScript = (List) shell.evaluate("[1,2,3,4]");

    assertSame(8, sumResult);
    assertEquals(list, listFromScript);
  }

  @Test
  public void groovyShellSharingDataTest() {
    final Binding sharedData = new Binding();
    final GroovyShell shell = new GroovyShell(sharedData);

    sharedData.setProperty("list", this.list);
    sharedData.setVariable("s", "split-string");
    shell.evaluate("name='Peter'");

    assertSame("Peter", shell.getProperty("name"));
    assertSame(1, shell.evaluate("list.find{it < 3}"));

    ArrayList<String> splitResult = new ArrayList<String>();
    splitResult.add("split");
    splitResult.add("string");

    assertEquals(splitResult, shell.evaluate("s.split('-').toList()"));
  }

  @Test
  public void groovyClassLoaderTest() throws Exception {
    final GroovyClassLoader loader = new GroovyClassLoader();
    final Class first = loader.parseClass("class First { String helloFirst() { 'Hello first' } }");

    assertEquals("First", first.getName());
    assertEquals("Hello first", first.getMethod("helloFirst").invoke(first.newInstance(), null));
  }

  @Test
  public void groovyScriptEngineTest() throws Exception {
    final Class script = new GroovyScriptEngine("src/main/java/eight/").loadScriptByName("HelloEngine.groovy");
    final Object scriptInstance = script.newInstance();

    assertEquals("Hello, this is importing script",
        script.getDeclaredMethod("hello", new Class[]{}).invoke(scriptInstance, new Object[]{})
    );
  }
}
