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
}
