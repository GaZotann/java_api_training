package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


public class LauncherTest {
    @Test
    void mainTest1(){
        String[] args = {};
        org.assertj.core.api.Assertions.assertThat(args.length).isEqualTo(0);
    }
    @Test
    void mainTest2(){
        String[] args = {"9876"};
        org.assertj.core.api.Assertions.assertThat(args[0]).isEqualTo("9876");
    }
}
