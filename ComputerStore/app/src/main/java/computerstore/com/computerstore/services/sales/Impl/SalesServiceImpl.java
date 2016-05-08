package computerstore.com.computerstore.services.sales.Impl;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import computerstore.com.computerstore.domain.sales.Sales;
import computerstore.com.computerstore.respository.sales.SalesRepository;
import computerstore.com.computerstore.services.sales.SalesService;

/**
 *
 * @author Aidem
 */

public class SalesServiceImpl extends IntentService implements SalesService {

    private final SalesRepository repo;

    public static final String ACTION_UPDATE = "computerstore.com.computerstore.services.sales.Impl.action.UPDATE";

    public static final String EXTRA_UPDATE = "computerstore.com.computerstore.services.sales.Impl.extra.UPDATE";

    public SalesServiceImpl() {
        super("SalesServiceImpl");
    }

    private static SalesServiceImpl service = null;

    public static SalesServiceImpl getInstance() {
        if (service == null)
            service = new SalesServiceImpl();
        return service;
    }

    @Override
    public void updateSales(Context context, Sales contact) {
        Intent intent = new Intent(context, SalesServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);
    }


}

