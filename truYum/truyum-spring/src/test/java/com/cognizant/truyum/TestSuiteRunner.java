package com.cognizant.truyum;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.truyum.service.CartServiceTest;
import com.cognizant.truyum.service.MenuItemServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ MenuItemServiceTest.class, CartServiceTest.class })
public class TestSuiteRunner {

}
