package com.lukamaret.lukbot.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lukamaret.lukbot.infrastructure.listeners.DefaultListenersRepository;
import com.lukamaret.lukbot.infrastructure.tasks.DefaultTasksRepository;
import com.lukamaret.lukbot.main.guice.ConfigurationModule;
import com.lukamaret.lukbot.main.guice.MainModule;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File configFile = new File("configuration.json");
        Injector configurationInjector = Guice.createInjector(new ConfigurationModule(configFile));
        Injector injector = Guice.createInjector(new MainModule(configurationInjector));

        new DefaultListenersRepository(injector).registerListeners();
        new DefaultTasksRepository(injector).registerTasks();

        LoggerFactory.getLogger(Main.class).info("LukBot started");

    }

}
