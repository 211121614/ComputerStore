package computerstore.factories;

/**
 * Created by Aidem on 2016/04/17.
 */

import com.computerstore.factories.components.MainboardTest;
import com.computerstore.factories.components.MemoryTest;
import com.computerstore.factories.components.MonitorTest;
import com.computerstore.factories.components.NotebookTest;
import com.computerstore.factories.components.OpticalDevicesTest;
import com.computerstore.factories.components.PCUTest;
import com.computerstore.factories.components.PrinterTest;
import com.computerstore.factories.components.SpeakerTest;
import com.computerstore.factories.components.StorageDeviceTest;
import com.computerstore.factories.employees.EmployeesTest;
import com.computerstore.factories.sales.SalesComponentsTest;
import com.computerstore.factories.sales.SalesTest;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import computerstore.factories.components.CPUTest;
import computerstore.factories.components.ChassisTest;
import computerstore.factories.components.DisplayCardTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ChassisTest.class,
        CPUTest.class,
        DisplayCardTest.class,
        MainboardTest.class,
        MemoryTest.class,
        MonitorTest.class,
        NotebookTest.class,
        OpticalDevicesTest.class,
        PCUTest.class,
        PrinterTest.class,
        SpeakerTest.class,
        StorageDeviceTest.class,
        EmployeesTest.class,
        SalesComponentsTest.class,
        SalesTest.class})
public class AppUnitTestSuite {
}
