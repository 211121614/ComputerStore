package computerstore.com.computerstore.services.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import computerstore.com.computerstore.conf.util.App;
import org.junit.Assert;
import computerstore.com.computerstore.domain.components.Chassis;
import computerstore.com.computerstore.services.components.Impl.ChassisServiceImpl;


public class ChassisServiceTest extends AndroidTestCase {
    private ChassisServiceImpl chassisService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ChassisServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ChassisServiceImpl.ChassisServiceLocalBinder binder
                    = (ChassisServiceImpl.ChassisServiceLocalBinder) service;
            chassisService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testUpdateChassis() throws Exception {
        Chassis chassis = new Chassis.Builder()
                .productNumber("SGC-2100-KWN1")
                .stock(50)
                .description("COOLERMASTER CM STORM SCOUT 2")
                .price(2000.00)
                .build();
        Chassis chas = chassisService.updateChassis(chassis);
        Assert.assertEquals(null, chas.getPrice());

    }

    public void testpostStorageDevice() throws Exception {
        Chassis chassis = new Chassis.Builder()
                .productNumber("SGC-2100-KWN1")
                .stock(50)
                .description("COOLERMASTER CM STORM SCOUT 2")
                .price(2000.00)
                .build();
        Chassis chas = chassisService.updateChassis(chassis);
        Assert.assertEquals(null, chas.getPrice());

    }


}
