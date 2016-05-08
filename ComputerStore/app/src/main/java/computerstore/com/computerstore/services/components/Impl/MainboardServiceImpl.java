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
import computerstore.com.computerstore.domain.components.Mainboard;
import computerstore.com.computerstore.respository.components.Impl.MainboardRepositoryImpl;
import computerstore.com.computerstore.respository.components.MainboardRepository;
import computerstore.com.computerstore.restapi.components.api.Impl.MainboardAPIImpl;
import computerstore.com.computerstore.restapi.components.api.MainboardAPI;
import computerstore.com.computerstore.services.components.MainboardService;


public class MainboardServiceImpl extends IntentService implements MainboardService {
    private final MainboardAPI api;
    private final MainboardRepository repo;

    public static final String ACTION_ADD = "computerstore.com.computerstore.services.components.Impl.action.ADD";
    public static final String ACTION_UPDATE = "computerstore.com.computerstore.services.components.Impl.action.UPDATE";

    public static final String EXTRA_ADD = "computerstore.com.computerstore.services.components.Impl.extra.ADD";
    public static final String EXTRA_UPDATE = "computerstore.com.computerstore.services.components.Impl.extra.UPDATE";

    private static MainboardServiceImpl service = null;

    public static MainboardServiceImpl getInstance() {
        if (service == null)
            service = new MainboardServiceImpl();
        return service;
    }

    private MainboardServiceImpl() {
        super("MainboardServiceImpl");
        api = new MainboardAPIImpl();
        repo = new MainboardRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addMainboard(Context context,Mainboard contact) {
        Intent intent = new Intent(context,MainboardServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    public void updateMainboard(Context context,Mainboard contact) {
        Intent intent = new Intent(context,MainboardServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Mainboard mainboard = (Mainboard) intent.getSerializableExtra(EXTRA_ADD);
                postContact(mainboard);
            } else if (ACTION_UPDATE.equals(action)) {
                final Mainboard mainboard = (Mainboard) intent.getSerializableExtra(EXTRA_UPDATE);
                updateContact(mainboard);
            }
        }
    }

    private void updateContact(Mainboard mainboard) {
        //REMOTE UPADTE AND LOCAL UPDATE
        try {
           Mainboard updatedContact = api.updateMainboard(mainboard);
            repo.save(updatedContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postContact(Mainboard mainboard) {
        //POST AND LOCAL SAVE
        try {
           Mainboard createdContact = api.createMainboard(mainboard);
            repo.save(createdContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
