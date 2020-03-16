package com.github.Svetlana.Vasilyuk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.github.Svetlana.Vasilyuk.Greeting.personalGreet;
import static com.github.Svetlana.Vasilyuk.Greeting.simpleGreet;

public class GreetingTest {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingTest.class);

    @Test
    public void simpleGreetTest() {
        LOG.info("Выполняется простой тест");
        LOG.info("Приветствие: \"" + simpleGreet() + "\"");
        Assert.assertEquals(simpleGreet(), "Приветствую!", "Приветствие некорректно");
        LOG.info("Простой тест завершен");
    }

    @DataProvider(name = "Дата-провайдер с ФИ")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Петр", "Николаев"},
                {"Ирина", "Дмитриева"}
        };
    }

    @Test(dataProvider = "Дата-провайдер с ФИ")
    public void personGreetTest(String name, String surname) {
        LOG.info("Выполняется параметризованный тест");
        String greetingAct = personalGreet(name, surname);
        String greetingExp = String.format("Приветствую, %s %s!", name, surname);
        LOG.info("Приветствие: \"" + greetingAct + "\"");
        Assert.assertEquals(greetingAct, greetingExp, "Приветствие некорректно");
        LOG.info("Параметризованный тест завершен");
    }
}