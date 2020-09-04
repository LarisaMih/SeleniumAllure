package com.Re;

import org.testng.annotations.Test;

public class Start {

    @Test
    public void StartProcess() throws Exception {
        RedesingTest pp = new RedesingTest();
        pp.OpenMainPage();
        pp.AssertLineTitle();
        pp.finish();
    }


    @Test
    public void StartProces() throws Exception {
        RedesingTest p = new RedesingTest();
        p.OpenMainPage();
        p.search();
        p.finish();
    }

    @Test(priority = 5)
    public void StartTask() throws Exception {

        Runtime.getRuntime().exec("cmd /k C:\\Users\\User\\IdeaProjects\\Redesing\\src\\test\\resources/task.bat");
    }

    @Test(priority = 6)
    public void StartTaskAll() throws Exception {
        Runtime.getRuntime().exec("cmd /k C:\\Users\\User\\IdeaProjects\\Redesing\\src\\test\\resources/taskAll.bat");
    }


}
