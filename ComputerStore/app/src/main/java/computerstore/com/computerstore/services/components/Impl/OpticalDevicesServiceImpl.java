package computerstore.com.computerstore.services.components.Impl;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import computerstore.com.computerstore.conf.databases.DBConstants;
import computerstore.com.computerstore.conf.util.App;
import computerstore.com.computerstore.domain.components.OpticalDevices;
import computerstore.com.computerstore.respository.components.Impl.OpticalDevicesRepositoryImpl;
import computerstore.com.computerstore.respository.components.OpticalDevicesRepository;
import computerstore.com.computerstore.restapi.components.api.Impl.OpticalDevicesAPIImpl;
import computerstore.com.computerstore.restapi.components.api.OpticalDevicesAPI;
import computerstore.com.computerstore.services.components.OpticalDevicesService;


public class OpticalDevicesServiceImpl extends IntentService implements OpticalDevicesService {
    private final OpticalDevicesAPI api;
    private final OpticalDevicesRepository repo;

    public static final String ACTION_ADD = "computerstore.com.computerstore.services.components.Impl.action.ADD";
    public static final String ACTION_UPDATE = "computerstore.com.computerstore.services.components.Impl.action.UPDATE";

    public static final String EXTRA_ADD = "computerstore.com.computerstore.services.components.Impl.extra.ADD";
    public static final String EXTRA_UPDATE = "computerstore.com.computerstore.services.components.Impl.extra.UPDATE";

    private static OpticalDevicesServiceImpl service = null;

    public static OpticalDevicesServiceImpl getInstance() {
        if (service == null)
            service = new OpticalDevicesServiceImpl();
        return service;
    }

    private OpticalDevicesServiceImpl() {
        super("OpticalDevicesServiceImpl");
        api = new OpticalDevicesAPIImpl();
        repo = new OpticalDevicesRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addOpticalDevices(Context context, OpticalDevices contact) {
        Intent intent = new Intent(context, OpticalDevicesServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    public void updateOpticalDevices(Context context, OpticalDevices contact) {
        Intent intent = new Intent(context, OpticalDevicesServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final OpticalDevices opticalDevices = (OpticalDevices) intent.getSerializableExtra(EXTRA_ADD);
                postContact(opticalDevices);
            } else if (ACTION_UPDATE.equals(action)) {
                final OpticalDevices opticalDevices = (OpticalDevices) intent.getSerializableExtra(EXTRA_UPDATE);
                updateContact(opticalDevices);
            }
        }
    }

    private void updateContact(OpticalDevices opticalDevices) {
        //REMOTE UPADTE AND LOCAL UPDATE
        try {
            OpticalDevices updatedContact = api.updateOpticalDevices(opticalDevices);
            repo.save(updatedContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postContact(OpticalDevices opticalDevices) {
        //POST AND LOCAL SAVE
        try {
            OpticalDevices createdContact = api.createOpticalDevices(opticalDevices);
            repo.save(createdContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
