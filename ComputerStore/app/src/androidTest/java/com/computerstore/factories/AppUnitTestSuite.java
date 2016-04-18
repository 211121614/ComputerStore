package com.computerstore.factories;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AppUnitTestSuite extends TestSuite {

    public static Test suite() {
        return new TestSuiteBuilder(AppUnitTestSuite.class)
                .includeAllPackagesUnderHere().build();
    }


    public AppUnitTestSuite() {
        super();
    }
}
